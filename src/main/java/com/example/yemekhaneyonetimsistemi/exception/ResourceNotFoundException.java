package com.example.yemekhaneyonetimsistemi.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceName,Integer id){
        super(resourceName + " ID'si " + id + " olan kayıt bulunamadı.");
    }
}
