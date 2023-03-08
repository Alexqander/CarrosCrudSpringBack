package com.mx.sda.carroscrudspring.services;

import com.mx.sda.carroscrudspring.model.Coche;
import com.mx.sda.carroscrudspring.model.CocheRepository;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("OK",false,cocheRepository, HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<Message> findCoche(long id){
        return new ResponseEntity<>(new Message("OK",false,cocheRepository.findById(id)), HttpStatus.OK);
    }
    @Transactional
    public ResponseEntity<Message> updateCoche(Coche coche){
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
            return new ResponseEntity<>(new Message("OK",false,cocheRepository.save(existCoche)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("error",true,null),
                HttpStatus.BAD_REQUEST);
    }









}
