package com.example.blooddonorapp.persistence.services;

import com.example.blooddonorapp.exception.donor.DonorNotFoundException;
import com.example.blooddonorapp.models.BloodType;
import com.example.blooddonorapp.models.Donation;
import com.example.blooddonorapp.models.Donor;
import com.example.blooddonorapp.persistence.dao.DonationRepository;
import com.example.blooddonorapp.persistence.dao.DonorRepository;
import com.example.blooddonorapp.persistence.entities.DonorDTO;
import com.example.blooddonorapp.persistence.services.mappers.DonorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorService {
    private DonorRepository donorRepository;
    private DonationRepository donationRepository;
    private DonorMapper donorMapper;

    @Autowired
    public DonorService(DonorRepository donorRepository, DonationRepository donationRepository,  DonorMapper donorMapper){
        this.donorRepository = donorRepository;
        this.donationRepository = donationRepository;
        this.donorMapper = donorMapper;
    }

    private DonorNotFoundException donorNotFoundException(Long id){
        return new DonorNotFoundException(id);
    }

    public DonorDTO save(final DonorDTO donorDTO){
        Donor donor = donorRepository.save(donorMapper.mapToDonor(donorDTO));

        return donorMapper.mapToDonorDTO(donor);
    }

    public DonorDTO update(final DonorDTO donorDTO){
        Donor donor = donorRepository.findById(donorDTO.getDonorId()).orElseThrow(() -> new DonorNotFoundException(donorDTO.getDonorId()));

        return donorMapper.mapToDonorDTO(donorRepository.save(donor));
    }

    public Optional<DonorDTO> findById(final Long id){
        Optional<Donor> optionalDonor = donorRepository.findById(id);

        return Optional.of(donorMapper.mapToDonorDTO(optionalDonor.get()));
    }

    public List<DonorDTO> findAll(){
        return donorMapper.mapToDonorDTOList(donorRepository.findAll());
    }

    public void deleteById(final Long id){
        try{
            donorRepository.deleteById(id);
        }catch (Exception e){
            throw donorNotFoundException(id);
        }
    }

    public List<DonorDTO> findByName(final String name){
        return donorMapper.mapToDonorDTOList(donorRepository.findByName(name));
    }

    public List<DonorDTO> findBySurname(final String surname){
        return donorMapper.mapToDonorDTOList(donorRepository.findBySurname(surname));
    }

    public List<DonorDTO> findByGender(final String gender){
        return donorMapper.mapToDonorDTOList(donorRepository.findByGender(gender));
    }

    public List<DonorDTO> findByBloodType(final String bloodType){
        return donorMapper.mapToDonorDTOList(donorRepository.findByBloodType(bloodType));
    }

    public List<DonorDTO> findByCity(final String city){
        return donorMapper.mapToDonorDTOList(donorRepository.findByCity(city));
    }

    public DonorDTO findDonorByDonationId(final Long donationId){
        Optional<Donation> optionalDonation = donationRepository.findById(donationId);
        Donation donation = optionalDonation.get();

        Optional<Donor> optionalDonor = donorRepository.getDonorByDonationId(donation.getDonationId());

        return donorMapper.mapToDonorDTO(optionalDonor.get());
    }
}