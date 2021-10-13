package com.example.blooddonorapp.persistence.dao;

import com.example.blooddonorapp.models.BloodBank;
import com.example.blooddonorapp.models.Donation;
import com.example.blooddonorapp.models.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DonationRepository extends JpaRepository<Donation, Long> {
    @Override
    Donation save(Donation donation);

    @Override
    Optional<Donation> findById(Long id);

    @Override
    List<Donation> findAll();

    @Override
    void deleteById(Long id);

    List<Donation> findByBloodType(String bloodType);

    List<Donation> findByDonor(Donor donor);

    List<Donation> findByBloodBank(BloodBank bloodBank);

    List<Donation> findByDonationDate(Date donationDate);
}
