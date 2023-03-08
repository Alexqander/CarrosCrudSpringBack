package com.mx.sda.carroscrudspring.utils;

import java.util.List;

public class Mesage {
    private String message;
    private boolean error;
    private Object data;
    private List<Object> listData;

    public Mesage() {
    }
    public Mesage(String message, boolean error, Object data) {
        this.message = message;
        this.error = error;
        this.data = data;
    }

    public Mesage(String message, boolean error, List<Object> listData) {
        this.message = message;
        this.error = error;
        this.listData = listData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Object> getListData() {
        return listData;
    }

    public void setListData(List<Object> listData) {
        this.listData = listData;
    }
}
