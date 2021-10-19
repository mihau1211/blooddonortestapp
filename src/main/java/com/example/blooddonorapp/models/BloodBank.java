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
    private String city;
    @OneToMany(
            targetEntity = Donation.class,
            mappedBy = "donationId",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Donation> donations;
    @ManyToMany( cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Donor> donors;

    public Long getBloodBankId() {
        return bloodBankId;
    }

    public void setBloodBankId(Long bloodBankId) {
        this.bloodBankId = bloodBankId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "BloodBank{" +
                "bloodBankId=" + bloodBankId +
                ", city='" + city + '\'' +
                ", donations=" + donations +
                ", donors=" + donors +
                '}';
    }
}
