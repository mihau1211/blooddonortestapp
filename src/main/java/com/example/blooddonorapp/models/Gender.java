package com.example.blooddonorapp.models;

public enum Gender {MALE, FEMALE;

    public static boolean contains(String value) {
        for (Gender index : Gender.values()) {
            if (index.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
