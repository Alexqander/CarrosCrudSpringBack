package com.mx.sda.carroscrudspring.services;
import com.mx.sda.carroscrudspring.model.Coche;
import com.mx.sda.carroscrudspring.model.CocheRepository;
import com.mx.sda.carroscrudspring.utils.LoggerClass;
import org.springframework.beans.factory.annotation.Autowired;
import com.mx.sda.carroscrudspring.utils.Mesage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CocheService {
    @Autowired
    CocheRepository cocheRepository;

    @Transactional
    public ResponseEntity<Mesage> findAll(){
        List<Coche> allCoches = cocheRepository.findAll();
        LoggerClass log = new LoggerClass(allCoches);
        log.info();
        return new ResponseEntity<>(new Mesage("ok",false,allCoches), HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<Mesage> findCoche(long id){
        return new ResponseEntity<>(new Mesage("OK",false,cocheRepository.findById(id)), HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<Mesage> updateCoche(long id,Coche coche){
        Coche existCoche = cocheRepository.findById(id);
        if(existCoche!=null){
            if (!coche.getMarca().isEmpty())
                existCoche.setMarca(coche.getMarca());
            if (!coche.getModelo().isEmpty())
                existCoche.setModelo(coche.getModelo());
            if (coche.getPrecio() == 0)
                existCoche.setPrecio(coche.getPrecio());
            if (!coche.getColor().isEmpty())
                existCoche.setColor(coche.getColor());
            if (coche.getAnio() == 0)
                existCoche.setAnio(coche.getAnio());
            existCoche.setActivo(coche.getActivo());
            Coche updated = cocheRepository.saveAndFlush(existCoche);
            LoggerClass log = new LoggerClass(updated);
            log.warn();
            return new ResponseEntity<>(new Mesage("ok",false,updated), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Mesage("error",true,null),
                HttpStatus.BAD_REQUEST);
    }
    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Mesage>save(Coche coche){
        Optional<Coche> existsCoche = Optional.ofNullable(cocheRepository.findById(coche.getId()));
        if (existsCoche.isPresent()){
            return new ResponseEntity<>(new Mesage("Ya existe un coche con ese ID",true,null),
                    HttpStatus.BAD_REQUEST);
        }
        Coche saved = cocheRepository.saveAndFlush(coche);
        LoggerClass log = new LoggerClass(saved);
        log.warn();
        return new ResponseEntity<>(new Mesage("OK",false,saved),
                HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Mesage>deleteCoche(long id){
        Coche cocheDeleteExists = cocheRepository.findById(id);
        if (cocheDeleteExists!=null){
            LoggerClass log = new LoggerClass("Deleted element");
            cocheRepository.deleteById(id);
            log.warn();
            return new ResponseEntity<>(new Mesage("Deleted",false,cocheDeleteExists),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new Mesage("Error",true,null),
                HttpStatus.NOT_FOUND);
    }

}
