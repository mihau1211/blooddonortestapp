package com.example.blooddonorapp.persistence.services;

import com.example.blooddonorapp.exception.bloodbank.BloodBankNotFoundException;
import com.example.blooddonorapp.models.BloodBank;
import com.example.blooddonorapp.models.Donation;
import com.example.blooddonorapp.persistence.dao.BloodBankRepository;
import com.example.blooddonorapp.persistence.dao.DonationRepository;
import com.example.blooddonorapp.persistence.entities.BloodBankDTO;
import com.example.blooddonorapp.persistence.services.mappers.BloodBankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodBankService {
    private BloodBankRepository bloodBankRepository;
    private DonationRepository donationRepository;
    private BloodBankMapper bloodBankMapper;

    @Autowired
    public BloodBankService(BloodBankRepository bloodBankRepository, DonationRepository donationRepository, BloodBankMapper bloodBankMapper) {
        this.bloodBankRepository = bloodBankRepository;
        this.donationRepository = donationRepository;
        this.bloodBankMapper = bloodBankMapper;
    }

    private BloodBankNotFoundException bloodBankNotFoundException(Long id){
        return new BloodBankNotFoundException(id);
    }

    public BloodBankDTO save(final BloodBankDTO bloodBankDTO){
        BloodBank bloodBank = bloodBankRepository.save(bloodBankMapper.mapToBloodBank(bloodBankDTO));

        return bloodBankMapper.mapToBloodBankDTO(bloodBank);
    }

    public Optional<BloodBankDTO> findById(final Long id){
        Optional<BloodBank> optionalBloodBank = bloodBankRepository.findById(id);

        return Optional.of(bloodBankMapper.mapToBloodBankDTO(optionalBloodBank.get()));
    }

    public void deleteById(final Long id){
        try{
            bloodBankRepository.deleteById(id);
        }catch(Exception e){
            throw bloodBankNotFoundException(id);
        }
    }

    public List<BloodBankDTO> findByCity(String city){
        return bloodBankMapper.mapToBloodBankDTOList(bloodBankRepository.findByCity(city));
    }

    public BloodBankDTO findBloodBankByDonationId(final Long donationId){
        Optional<Donation> optionalDonation = donationRepository.findById(donationId);
        Donation donation = optionalDonation.get();

        Optional<BloodBank> optionalBloodBank = bloodBankRepository.getBloodBankByDonationId(donation.getDonationId());

        return bloodBankMapper.mapToBloodBankDTO(optionalBloodBank.get());
    }
}
