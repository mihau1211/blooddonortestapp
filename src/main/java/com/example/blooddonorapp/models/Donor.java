package com.example.blooddonorapp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Table(name="Donor")
@AllArgsConstructor
@NoArgsConstructor
public class Donor extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long donorId;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;
    private String city;
    @OneToMany(
            targetEntity = Donation.class,
            mappedBy = "donationId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Donation> donations;
    @ManyToMany(
            mappedBy = "donors"
    )
    private List<BloodBank> bloodBanks;
    private int numberOfDonations;
    private Date firstDonationDate;
    private Date lastDonationDate;

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public List<BloodBank> getBloodBanks() {
        return bloodBanks;
    }

    public void setBloodBanks(List<BloodBank> bloodBanks) {
        this.bloodBanks = bloodBanks;
    }

    public int getNumberOfDonations() {
        return numberOfDonations;
    }

    public void setNumberOfDonations(int numberOfDonations) {
        this.numberOfDonations = numberOfDonations;
    }

    public Date getFirstDonationDate() {
        return firstDonationDate;
    }

    public void setFirstDonationDate(Date firstDonationDate) {
        this.firstDonationDate = firstDonationDate;
    }

    public Date getLastDonationDate() {
        return lastDonationDate;
    }

    public void setLastDonationDate(Date lastDonationDate) {
        this.lastDonationDate = lastDonationDate;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "donorId=" + donorId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", bloodType=" + bloodType +
                ", city='" + city + '\'' +
                ", donations=" + donations +
                ", bloodBanks=" + bloodBanks +
                ", numberOfDonations=" + numberOfDonations +
                ", firstDonationDate=" + firstDonationDate +
                ", lastDonationDate=" + lastDonationDate +
                '}';
    }
}
