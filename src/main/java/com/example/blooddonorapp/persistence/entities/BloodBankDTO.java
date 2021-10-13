package com.example.blooddonorapp.persistence.entities;

import com.example.blooddonorapp.models.Donation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class BloodBankDTO {
    private long bloodBankId;
    private Set<Donation> donations;
}
