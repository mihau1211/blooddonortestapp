package com.example.blooddonorapp.persistence.services.mappers;

import com.example.blooddonorapp.models.Donation;
import com.example.blooddonorapp.persistence.entities.DonationDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DonationMapper {
    public Donation mapToDonation(final DonationDTO donationDTO){
        return Donation.builder()
                .donationId(donationDTO.getDonationId())
                .donor(donationDTO.getDonor())
                .donationDate(donationDTO.getDonationDate())
                .bloodType(donationDTO.getBloodType())
                .bloodBank(donationDTO.getBloodBank())
                .quantity(donationDTO.getQuantity())
                .build();
    }

    public DonationDTO mapToDonationDTO(final Donation donation){
        return DonationDTO.builder()
                .donationId(donation.getDonationId())
                .donor(donation.getDonor())
                .donationDate(donation.getDonationDate())
                .bloodType(donation.getBloodType())
                .bloodBank(donation.getBloodBank())
                .quantity(donation.getQuantity())
                .build();
    }

    public List<DonationDTO> mapToDonationListDTO(final List<Donation> list) {
        return list.stream()
                .map(this::mapToDonationDTO)
                .collect(Collectors.toList());
    }

    public List<Donation> mapToDonationList(final List<DonationDTO> list) {
        return list.stream()
                .map(this::mapToDonation)
                .collect(Collectors.toList());
    }
}
