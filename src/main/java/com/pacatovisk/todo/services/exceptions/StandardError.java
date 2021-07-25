package com.pacatovisk.todo.services.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long timesstamp;
    private Integer status;
    private String message;

    public StandardError() {
    }

    public StandardError(Long timesstamp, Integer status, String message) {
        this.timesstamp = timesstamp;
        this.status = status;
        this.message = message;
    }

    public Long getTimesstamp() {
        return timesstamp;
    }

    public void setTimesstamp(Long timesstamp) {
        this.timesstamp = timesstamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
