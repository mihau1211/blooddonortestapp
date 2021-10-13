package com.example.blooddonorapp.exception.donation;

public class DonationNotFoundException extends RuntimeException{
    public DonationNotFoundException(Long id){
        super("Not found donation with id: "+id);
    }
}
