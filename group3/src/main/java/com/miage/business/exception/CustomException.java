package com.miage.business.exception;

import java.util.Date;

public class CustomException extends RuntimeException {
	private static final long serialVersionUID = 5991998170182040917L;
	private Date date;
    private String message;
     
    public CustomException(String message) {
        super();
        this.date = new Date();
        this.message = message;
    }
 
    public Date getDate() {
        return date;
    }
 
    public String getMessage() {
        return message;
    }
 
    @Override
    public String toString() {
        return "CustomException [date=" + date + ", message=" + message + "]";
    }
}