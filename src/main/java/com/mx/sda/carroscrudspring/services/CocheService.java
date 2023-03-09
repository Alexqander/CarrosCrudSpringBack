package com.mx.sda.carroscrudspring.services;

import com.mx.sda.carroscrudspring.CarrosCrudSpringApplication;
import com.mx.sda.carroscrudspring.model.Coche;
import com.mx.sda.carroscrudspring.model.CocheRepository;
import com.mx.sda.carroscrudspring.utils.LoggerClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.mx.sda.carroscrudspring.utils.Mesage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class CocheService {
    @Autowired
    CocheRepository cocheRepository;




    @Transactional
    public ResponseEntity<Mesage> findAll(){


        LoggerClass log = new LoggerClass(cocheRepository.findAll());
        log.info();

        return new ResponseEntity<>(new Mesage("ok",false,cocheRepository.findAll()), HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<Mesage> findCoche(long id){
        return new ResponseEntity<>(new Mesage("OK",false,cocheRepository.findById(id)), HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<Mesage> updateCoche(Coche coche){
        Coche existCoche =cocheRepository.findById(coche.getId());
        if(existCoche!=null){
            if (!coche.getMarca().isEmpty())
                existCoche.setMarca(coche.getMarca());
            if (!coche.getModelo().isEmpty())
                existCoche.setModelo(coche.getModelo());
            if (!coche.getActivo())
                existCoche.setActivo(coche.getActivo());
            if (coche.getPrecio() == 0)
                existCoche.setPrecio(coche.getPrecio());
            if (!coche.getColor().isEmpty())
                existCoche.setColor(coche.getColor());
            if (coche.getAnio() == 0)
                existCoche.setAnio(coche.getAnio());


            LoggerClass log = new LoggerClass(cocheRepository.save(existCoche));
            log.warn();
            return new ResponseEntity<>(new Mesage("ok",false,cocheRepository.save(existCoche)), HttpStatus.OK);
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

        LoggerClass log = new LoggerClass(cocheRepository.saveAndFlush(coche));
        log.warn();
        return new ResponseEntity<>(new Mesage("ok",false,cocheRepository.saveAndFlush(coche)),
                HttpStatus.OK);
    }

}
