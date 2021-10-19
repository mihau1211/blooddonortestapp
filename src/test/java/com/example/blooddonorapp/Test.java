package com.example.blooddonorapp;

import com.example.blooddonorapp.models.Gender;

public class Test {
    public static void main(String[] args) {
        Gender g1 = Gender.FEMALE;

        if(Gender.contains(g1.name())){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
