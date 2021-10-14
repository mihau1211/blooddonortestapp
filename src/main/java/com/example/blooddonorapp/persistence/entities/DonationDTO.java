package com.example.blooddonorapp.persistence.entities;

import com.example.blooddonorapp.models.BloodBank;
import com.example.blooddonorapp.models.BloodType;
import com.example.blooddonorapp.models.Donor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class DonationDTO {
    private long donationId;
    private Donor donor;
    private Date donationDate;
    private String bloodType;
    private BloodBank bloodBank;
    private int quantity;
}
