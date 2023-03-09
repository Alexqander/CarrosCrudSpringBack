package com.mx.sda.carroscrudspring.utils;

import com.mx.sda.carroscrudspring.CarrosCrudSpringApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoggerClass {
    private static final Logger logger = LogManager.getLogger(CarrosCrudSpringApplication.class);
    private Object data;

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
