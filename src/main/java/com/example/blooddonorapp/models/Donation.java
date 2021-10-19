package com.example.blooddonorapp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Table(name="Donation")
@AllArgsConstructor
@NoArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long donationId;
    @ManyToOne
    @JoinColumn(name = "donorId")
    private Donor donor;
    private Date donationDate;
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;
    @ManyToOne
    @JoinColumn(name = "bloodBankId")
    private BloodBank bloodBank;
    private int quantity;

    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public BloodBank getBloodBank() {
        return bloodBank;
    }

    public void setBloodBank(BloodBank bloodBank) {
        this.bloodBank = bloodBank;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "donationId=" + donationId +
                ", donor=" + donor +
                ", donationDate=" + donationDate +
                ", bloodType=" + bloodType +
                ", bloodBank=" + bloodBank +
                ", quantity=" + quantity +
                '}';
    }
}
