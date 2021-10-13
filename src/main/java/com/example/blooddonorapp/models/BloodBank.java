package com.example.blooddonorapp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Table(name="BloodBank")
@AllArgsConstructor
@NoArgsConstructor
public class BloodBank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bloodBankId;
    @OneToMany(mappedBy = "bloodBank", fetch = FetchType.LAZY)
    private List<Donation> donations;
    @ManyToMany
    @JoinTable(
            name = "bloodBankDonors",
            joinColumns = @JoinColumn(name = "bloodBankId"),
            inverseJoinColumns = @JoinColumn(name = "donorId")
    )
    private List<Donor> donors;

    public Long getBloodBankId() {
        return bloodBankId;
    }

    public void setBloodBankId(Long bloodBankId) {
        this.bloodBankId = bloodBankId;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public List<Donor> getDonors() {
        return donors;
    }

    public void setDonors(List<Donor> donors) {
        this.donors = donors;
    }
}
