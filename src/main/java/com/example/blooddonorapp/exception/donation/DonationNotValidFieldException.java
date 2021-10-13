package com.example.blooddonorapp.exception.donation;

public class DonationNotValidFieldException extends RuntimeException{
    public DonationNotValidFieldException(String message){
        super(message);
    }
}
