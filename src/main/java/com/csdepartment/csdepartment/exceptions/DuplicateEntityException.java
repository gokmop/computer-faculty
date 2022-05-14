package com.csdepartment.csdepartment.exceptions;

public class DuplicateEntityException  extends RuntimeException{
    public DuplicateEntityException(String message){
        super(message);
    }
}
