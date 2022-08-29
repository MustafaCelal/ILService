package com.mcll.ILService.exception;

public class IlAlreadyExistException extends RuntimeException{
    public IlAlreadyExistException(String mesage){
        super(mesage);
    }
}
