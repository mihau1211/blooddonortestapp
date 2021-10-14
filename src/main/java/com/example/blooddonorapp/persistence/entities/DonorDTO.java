package com.example.blooddonorapp.persistence.entities;

import com.example.blooddonorapp.models.BloodType;
import com.example.blooddonorapp.models.Donation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class DonorDTO {
    private long donorId;
    private String name;
    private String surname;
    private String bloodType;
    private String city;
    private List<Donation> donations;
    private int numberOfDonations;
    private Date firstDonationDate;
    private Date lastDonationDate;
}
