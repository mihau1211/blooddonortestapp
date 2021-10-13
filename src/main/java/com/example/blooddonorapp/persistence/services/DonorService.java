package com.example.blooddonorapp.persistence.services;

import com.example.blooddonorapp.exception.donor.DonorNotFoundException;
import com.example.blooddonorapp.models.Donor;
import com.example.blooddonorapp.persistence.dao.BloodBankRepository;
import com.example.blooddonorapp.persistence.dao.DonationRepository;
import com.example.blooddonorapp.persistence.dao.DonorRepository;
import com.example.blooddonorapp.persistence.entities.DonorDTO;
import com.example.blooddonorapp.persistence.services.mappers.BloodBankMapper;
import com.example.blooddonorapp.persistence.services.mappers.DonationMapper;
import com.example.blooddonorapp.persistence.services.mappers.DonorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorService {
    private DonorRepository donorRepository;
    private DonationRepository donationRepository;
    private BloodBankRepository bloodBankRepository;
    private DonorMapper donorMapper;
    private DonationMapper donationMapper;
    private BloodBankMapper bloodBankMapper;

    @Autowired
    public DonorService(DonorRepository donorRepository, DonationRepository donationRepository, BloodBankRepository bloodBankRepository, DonorMapper donorMapper, DonationMapper donationMapper, BloodBankMapper bloodBankMapper){
        this.donorRepository = donorRepository;
        this.donationRepository = donationRepository;
        this.bloodBankRepository = bloodBankRepository;
        this.donorMapper = donorMapper;
        this.donationMapper = donationMapper;
        this.bloodBankMapper = bloodBankMapper;
    }

    private DonorNotFoundException notFoundException(Long id){
        return new DonorNotFoundException(id);
    }

    public DonorDTO save(final DonorDTO donorDTO){
        Donor donor = donorRepository.save(donorMapper.mapToDonor(donorDTO));

        return donorMapper.mapToDonorDTO(donor);
    }
}