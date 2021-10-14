package com.example.blooddonorapp.persistence.services;

import com.example.blooddonorapp.exception.donation.DonationNotFoundException;
import com.example.blooddonorapp.models.Donation;
import com.example.blooddonorapp.persistence.dao.BloodBankRepository;
import com.example.blooddonorapp.persistence.dao.DonationRepository;
import com.example.blooddonorapp.persistence.dao.DonorRepository;
import com.example.blooddonorapp.persistence.entities.BloodBankDTO;
import com.example.blooddonorapp.persistence.entities.DonationDTO;
import com.example.blooddonorapp.persistence.entities.DonorDTO;
import com.example.blooddonorapp.persistence.services.mappers.BloodBankMapper;
import com.example.blooddonorapp.persistence.services.mappers.DonationMapper;
import com.example.blooddonorapp.persistence.services.mappers.DonorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DonationService {
    DonationRepository donationRepository;
    DonorRepository donorRepository;
    BloodBankRepository bloodBankRepository;
    DonationMapper donationMapper;
    DonorMapper donorMapper;
    BloodBankMapper bloodBankMapper;

    @Autowired
    public DonationService(DonationRepository donationRepository, DonorRepository donorRepository, BloodBankRepository bloodBankRepository, DonationMapper donationMapper, DonorMapper donorMapper, BloodBankMapper bloodBankMapper) {
        this.donationRepository = donationRepository;
        this.donorRepository = donorRepository;
        this.bloodBankRepository = bloodBankRepository;
        this.donationMapper = donationMapper;
        this.donorMapper = donorMapper;
        this.bloodBankMapper = bloodBankMapper;
    }

    private DonationNotFoundException donationNotFoundException(Long id){
        return new DonationNotFoundException(id);
    }

    public DonationDTO save(final DonationDTO donationDTO){
        Donation donation = donationRepository.save(donationMapper.mapToDonation(donationDTO));

        return donationMapper.mapToDonationDTO(donation);
    }

    public Optional<DonationDTO> findById(final Long id){
        Optional<Donation> optionalDonation = donationRepository.findById(id);

        return Optional.of(donationMapper.mapToDonationDTO(optionalDonation.get()));
    }

    public List<DonationDTO> findByBloodType(final String bloodType){
        return donationMapper.mapToDonationDTOList(donationRepository.findByBloodType(bloodType));
    }

    public List<DonationDTO> findByDonor(final DonorDTO donorDTO){
        return donationMapper.mapToDonationDTOList(donationRepository.findByDonor(donorMapper.mapToDonor(donorDTO)));
    }

    public List<DonationDTO> findByBloodBank(final BloodBankDTO bloodBankDTO){
        return donationMapper.mapToDonationDTOList(donationRepository.findByBloodBank(bloodBankMapper.mapToBloodBank(bloodBankDTO)));
    }

    public List<DonationDTO> findByDonationDate(final Date donationDate){
        return donationMapper.mapToDonationDTOList(donationRepository.findByDonationDate(donationDate));
    }
}
