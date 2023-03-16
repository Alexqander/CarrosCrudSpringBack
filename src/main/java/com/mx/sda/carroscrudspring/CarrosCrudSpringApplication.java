package com.mx.sda.carroscrudspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class CarrosCrudSpringApplication {

    private static final Logger logger = LogManager.getLogger(CarrosCrudSpringApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CarrosCrudSpringApplication.class, args);
        // Inicializar Log4j2
        logger.info("Log4j2 iniciado correctamente.");
        // Resto del código
    }

}
