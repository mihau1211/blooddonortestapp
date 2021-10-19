package com.example.blooddonorapp.models;

public enum BloodType {
    A, B, AB, ZERO;

    public static boolean contains(String value) {
        for (BloodType index : BloodType.values()) {
            if (index.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
