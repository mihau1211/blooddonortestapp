package com.example.blooddonorapp.persistence.dao;

import com.example.blooddonorapp.models.BloodBank;
import com.example.blooddonorapp.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BloodBankRepository extends JpaRepository<BloodBank, Long> {
    @Override
    BloodBank save(BloodBank bloodBank);

    @Override
    Optional<BloodBank> findById(Long id);

    @Override
    List<BloodBank> findAll();

    @Override
    void deleteById(Long id);

//    List<BloodBank> findByDonation(Donation donation);
}
