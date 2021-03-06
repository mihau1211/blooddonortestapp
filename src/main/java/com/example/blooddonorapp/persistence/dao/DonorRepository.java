package com.example.blooddonorapp.persistence.dao;

import com.example.blooddonorapp.models.BloodType;
import com.example.blooddonorapp.models.Donation;
import com.example.blooddonorapp.models.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
    @Override
    Donor save(Donor donor);

    @Override
    Optional<Donor> findById(Long id);

    @Override
    List<Donor> findAll();

    @Override
    void deleteById(Long id);

    List<Donor> findByName(String name);

    List<Donor> findBySurname(String surname);

    List<Donor> findByGender(String gender);

    List<Donor> findByBloodType(String bloodType);

    List<Donor> findByCity(String city);

    @Query(value = "SELECT * FROM donor WHERE donation_id = :donationId", nativeQuery = true)
    Optional<Donor> getDonorByDonationId(Long donationId);
}
