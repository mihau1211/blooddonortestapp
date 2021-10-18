package com.example.blooddonorapp.persistence.services;

import com.example.blooddonorapp.exception.bloodbank.BloodBankNotFoundException;
import com.example.blooddonorapp.exception.donation.DonationNotFoundException;
import com.example.blooddonorapp.exception.donor.DonorNotFoundException;
import com.example.blooddonorapp.models.BloodBank;
import com.example.blooddonorapp.models.Donation;
import com.example.blooddonorapp.models.Donor;
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
    private DonorNotFoundException donorNotFoundException(Long id) {
        return new DonorNotFoundException(id);
    }
    private BloodBankNotFoundException bloodBankNotFoundException(Long id){
        return new BloodBankNotFoundException(id);
    }

    public DonationDTO save(final DonationDTO donationDTO){
        Donation donation = donationRepository.save(donationMapper.mapToDonation(donationDTO));

        return donationMapper.mapToDonationDTO(donation);
    }

    public DonationDTO update(final DonationDTO donationDTO){
        Donation donation = donationRepository.findById(donationDTO.getDonationId()).orElseThrow(() -> new DonationNotFoundException(donationDTO.getDonationId()));

        return donationMapper.mapToDonationDTO(donationRepository.save(donation));
    }

    public Optional<DonationDTO> findById(final Long id){
        Optional<Donation> optionalDonation = donationRepository.findById(id);

        return Optional.of(donationMapper.mapToDonationDTO(optionalDonation.get()));
    }

    public List<DonationDTO> findAll(){
        return donationMapper.mapToDonationDTOList(donationRepository.findAll());
    }

    public void deleteById(final Long id){
        try{
            donationRepository.deleteById(id);
        }catch(Exception e){
            throw donationNotFoundException(id);
        }
    }

    public List<DonationDTO> findByBloodType(final String bloodType){
        return donationMapper.mapToDonationDTOList(donationRepository.findByBloodType(bloodType));
    }

    public List<DonationDTO> findByDonor(final DonorDTO donorDTO){
        Optional<Donor> optionalDonor = donorRepository.findById(donorDTO.getDonorId());
        if(optionalDonor.isPresent()){
            return donationMapper.mapToDonationDTOList(donationRepository.findByDonor(donorMapper.mapToDonor(donorDTO)));
        }else{
            throw donorNotFoundException(donorDTO.getDonorId());
        }
    }

    public List<DonationDTO> findByBloodBank(final BloodBankDTO bloodBankDTO){
        Optional<BloodBank> optionalBloodBank = bloodBankRepository.findById(bloodBankDTO.getBloodBankId());
        if(optionalBloodBank.isPresent()) {
            return donationMapper.mapToDonationDTOList(donationRepository.findByBloodBank(bloodBankMapper.mapToBloodBank(bloodBankDTO)));
        }else {
            throw bloodBankNotFoundException(bloodBankDTO.getBloodBankId());
        }
    }

    public List<DonationDTO> findByDonationDate(final Date donationDate){
        return donationMapper.mapToDonationDTOList(donationRepository.findByDonationDate(donationDate));
    }
}
