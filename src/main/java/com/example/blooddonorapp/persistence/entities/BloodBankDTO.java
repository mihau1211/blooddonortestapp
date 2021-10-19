package com.example.blooddonorapp.persistence.entities;

import com.example.blooddonorapp.models.Donation;
import com.example.blooddonorapp.models.Donor;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BloodBankDTO {
    private long bloodBankId;
    private String city;
}
