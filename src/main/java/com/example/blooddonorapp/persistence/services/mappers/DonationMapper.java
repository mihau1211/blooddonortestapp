package com.example.blooddonorapp.persistence.services.mappers;

import com.example.blooddonorapp.models.BloodBank;
import com.example.blooddonorapp.models.BloodType;
import com.example.blooddonorapp.models.Donation;
import com.example.blooddonorapp.models.Donor;
import com.example.blooddonorapp.persistence.entities.DonationDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DonationMapper {
    public Donation mapToDonation(final DonationDTO donationDTO, final Donor donor, final BloodBank bloodBank){
        return Donation.builder()
                .donationId(donationDTO.getDonationId())
                .donor(donor)
                .donationDate(donationDTO.getDonationDate())
                .bloodType(BloodType.valueOf(donationDTO.getBloodType()))
                .bloodBank(bloodBank)
                .quantity(donationDTO.getQuantity())
                .build();
    }

    public DonationDTO mapToDonationDTO(final Donation donation){
        return DonationDTO.builder()
                .donationId(donation.getDonationId())
                .donorId(donation.getDonor().getDonorId())
                .donationDate(donation.getDonationDate())
                .bloodType(donation.getBloodType().toString())
                .bloodBankId(donation.getBloodBank().getBloodBankId())
                .quantity(donation.getQuantity())
                .build();
    }

    public List<DonationDTO> mapToDonationDTOList(final List<Donation> list) {
        return list.stream()
                .map(this::mapToDonationDTO)
                .collect(Collectors.toList());
    }

//    public List<Donation> mapToDonationList(final List<DonationDTO> list) {
//        return list.stream()
//                .map(this::mapToDonation)
//                .collect(Collectors.toList());
//    }
}
