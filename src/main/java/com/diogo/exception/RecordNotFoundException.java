package com.diogo.exception;

public class RecordNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(Long id){
        super("Registro com id " + id + " nao encontrado.");
    }
}
