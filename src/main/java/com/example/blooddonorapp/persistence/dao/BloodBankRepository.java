package com.example.blooddonorapp.persistence.dao;

import com.example.blooddonorapp.models.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    List<BloodBank> findByCity(String city);

    @Query(value = "SELECT * FROM blood_bank WHERE donation_id = :donationId", nativeQuery = true)
    Optional<BloodBank> getBloodBankByDonationId(Long donationId);
}
