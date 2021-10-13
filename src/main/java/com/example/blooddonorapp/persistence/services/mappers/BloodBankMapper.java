package com.example.blooddonorapp.persistence.services.mappers;

import com.example.blooddonorapp.models.BloodBank;
import com.example.blooddonorapp.persistence.entities.BloodBankDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BloodBankMapper {
    public BloodBank mapToBloodBank(final BloodBankDTO bloodBankDTO){
        return BloodBank.builder()
                .bloodBankId(bloodBankDTO.getBloodBankId())
                .donations(bloodBankDTO.getDonations())
                .donors(bloodBankDTO.getDonors())
                .build();
    }

    public BloodBankDTO mapToBloodBankDTO(final BloodBank bloodBank){
        return BloodBankDTO.builder()
                .bloodBankId(bloodBank.getBloodBankId())
                .donations(bloodBank.getDonations())
                .donors(bloodBank.getDonors())
                .build();
    }

    public List<BloodBankDTO> mapToBloodBankDTOList(final List<BloodBank> list){
        return list.stream()
                .map(this::mapToBloodBankDTO)
                .collect(Collectors.toList());
    }

    public List<BloodBank> mapToBloodBankList(final List<BloodBankDTO> list){
        return list.stream()
                .map(this::mapToBloodBank)
                .collect(Collectors.toList());
    }

}
