package com.mx.sda.carroscrudspring.utils;

import com.mx.sda.carroscrudspring.CarrosCrudSpringApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LoggerClass {
    private static final Logger logger = LogManager.getLogger(CarrosCrudSpringApplication.class);
    private Object data;
    private List<Object>objectList;

    public LoggerClass(List<Object> objectList) {
        this.objectList = objectList;
    }

    public LoggerClass(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void info() {
        logger.info(data);
    }

    public void debug() {
        // Registrar un mensaje de información

        logger.debug(data);
    }
    public void warn() {
        // Registrar un mensaje de información
        logger.warn(data);

    }

}
