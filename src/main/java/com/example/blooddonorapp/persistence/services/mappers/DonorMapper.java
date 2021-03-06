package com.example.blooddonorapp.persistence.services.mappers;

import com.example.blooddonorapp.models.BloodType;
import com.example.blooddonorapp.models.Donation;
import com.example.blooddonorapp.models.Donor;
import com.example.blooddonorapp.models.Gender;
import com.example.blooddonorapp.persistence.entities.DonorDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DonorMapper {
    public Donor mapToDonor(final DonorDTO donorDTO){
        return Donor.builder()
                .donorId(donorDTO.getDonorId())
                .name(donorDTO.getName())
                .surname(donorDTO.getSurname())
                .bloodType(BloodType.valueOf(donorDTO.getBloodType()))
                .city(donorDTO.getCity())
                .gender(Gender.valueOf(donorDTO.getGender()))
//                .numberOfDonations(donorDTO.getNumberOfDonations())
//                .firstDonationDate(donorDTO.getFirstDonationDate())
//                .lastDonationDate(donorDTO.getLastDonationDate())
                .build();
    }

    public DonorDTO mapToDonorDTO(final Donor donor){
        return DonorDTO.builder()
                .donorId(donor.getDonorId())
                .name(donor.getName())
                .surname(donor.getSurname())
                .bloodType(donor.getBloodType().toString())
                .city(donor.getCity())
                .gender(String.valueOf(donor.getGender()))
//                .numberOfDonations(donor.getNumberOfDonations())
//                .firstDonationDate(donor.getFirstDonationDate())
//                .lastDonationDate(donor.getLastDonationDate())
                .build();
    }

    public List<DonorDTO> mapToDonorDTOList(final List<Donor> list){
        return list.stream()
                .map(this::mapToDonorDTO)
                .collect(Collectors.toList());
    }
}
