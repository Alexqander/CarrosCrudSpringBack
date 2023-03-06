package com.mx.sda.carroscrudspring.services;

import org.aspectj.bridge.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CocheService {



    @Transactional
    public ResponseEntity<Message>findAll(){

    }
}
