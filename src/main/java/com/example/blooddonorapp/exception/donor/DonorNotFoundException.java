package com.example.blooddonorapp.exception.donor;

public class DonorNotFoundException extends RuntimeException{
    public DonorNotFoundException(Long id){
        super("Not found donor with id: "+id);
    }
}