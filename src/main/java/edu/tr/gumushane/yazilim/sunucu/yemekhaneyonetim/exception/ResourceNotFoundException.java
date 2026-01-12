package edu.tr.gumushane.yazilim.sunucu.yemekhaneyonetim.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resourceName,Integer id){
        super(resourceName + " ID'si " + id + " olan kayıt bulunamadı.");
    }
}
