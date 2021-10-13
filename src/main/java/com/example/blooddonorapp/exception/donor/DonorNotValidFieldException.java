package com.example.blooddonorapp.exception.donor;

public class DonorNotValidFieldException extends RuntimeException {
    public DonorNotValidFieldException(String message){
        super(message);
    }
}
