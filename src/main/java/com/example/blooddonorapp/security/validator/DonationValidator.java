package com.example.blooddonorapp.security.validator;

import com.example.blooddonorapp.exception.donation.DonationNotValidFieldException;
import com.example.blooddonorapp.persistence.entities.DonationDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DonationValidator implements Validator {
    private static final String DONATION_FIELD_DONATION_ID = "donationId";
    private static final String DONATION_FIELD_DONOR = "donor";
    private static final String DONATION_FIELD_BLOOD_BANK = "bloodBank";
    private static final String DONATION_FIELD_QUANTITY = "quantity";
    private static final String DONATION_FIELD_BLOOD_TYPE = "bloodType";


    @Override
    public boolean supports(Class<?> clazz) {
        return DonationDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DonationDTO donationDTO = (DonationDTO) target;

        if (donationDTO.getDonationId()<1){
            String msg = String.format("Invalid input for field: %s", DONATION_FIELD_DONATION_ID);
            throw new DonationNotValidFieldException(msg);
        } else if (donationDTO.getDonor().getDonorId() < 1){
            String msg = String.format("Invalid input for field: %s", DONATION_FIELD_DONOR);
            throw new DonationNotValidFieldException(msg);
        } else if (donationDTO.getBloodBank().getBloodBankId() < 1){
            String msg = String.format("Invalid input for field: %s", DONATION_FIELD_BLOOD_BANK);
            throw new DonationNotValidFieldException(msg);
        } else if (donationDTO.getQuantity()<0){
            String msg = String.format("Invalid input for field: %s", DONATION_FIELD_QUANTITY);
            throw new DonationNotValidFieldException(msg);
        } else if (donationDTO.getBloodType().toString() != "A" ||
                donationDTO.getBloodType().toString() != "B" ||
                donationDTO.getBloodType().toString() != "AB" ||
                donationDTO.getBloodType().toString() != "ZERO"){
            String msg = String.format("Invalid input for field: %s", DONATION_FIELD_BLOOD_TYPE);
            throw new DonationNotValidFieldException(msg);
        }
    }
}
