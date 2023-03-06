package com.mx.sda.carroscrudspring.controller;

import org.aspectj.bridge.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sda/coche")
@CrossOrigin(origins = {"*"})
public class CocheController {


    @GetMapping("/")
    public ResponseEntity<Message>getAll(){
        
    }
}
