package com.example.blooddonorapp.exception.bloodbank;

public class BloodBankNotFoundException extends RuntimeException{
    public BloodBankNotFoundException(Long id){
        super("Not found bloodbank with id: "+id);
    }
}
