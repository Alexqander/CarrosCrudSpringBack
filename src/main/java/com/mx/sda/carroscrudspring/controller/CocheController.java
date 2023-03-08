package com.mx.sda.carroscrudspring.controller;

import com.mx.sda.carroscrudspring.services.CocheService;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sda/coche")
@CrossOrigin(origins = {"*"})
public class CocheController {

    @Autowired
    CocheService cocheService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){return cocheService.findAll();}
    @GetMapping("/{id}")
    public ResponseEntity<Message>getByDni(@PathVariable("id") long id){
        return cocheService.findCoche(id);
    }




}
