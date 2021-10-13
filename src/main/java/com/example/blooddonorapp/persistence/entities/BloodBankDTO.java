package com.example.blooddonorapp.persistence.entities;

import com.example.blooddonorapp.models.Donation;
import com.example.blooddonorapp.models.Donor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class BloodBankDTO {
    private long bloodBankId;
    private List<Donation> donations;
    private List<Donor> donors;
}
