package com.example.blooddonorapp.security.validator;

import com.example.blooddonorapp.exception.donor.DonorNotValidFieldException;
import com.example.blooddonorapp.persistence.entities.DonorDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DonorValidator implements Validator {
    private static final String DONOR_FIELD_DONOR_ID = "donorId";
    private static final String DONOR_FIELD_GENDER = "gender";
    private static final String DONOR_FIELD_BLOOD_TYPE = "bloodType";
    private static final String DONOR_FIELD_NUMBER_OF_DONATIONS = "numberOfDonations";
    private static final String DONOR_FIELD_LAST_DONATION_DATE = "lastDonationDate";

    @Override
    public boolean supports(Class<?> clazz) {
        return DonorDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        DonorDTO donorDTO = (DonorDTO) target;

        if (donorDTO.getDonorId()<1){
            String msg = String.format("Invalid input for field: %s", DONOR_FIELD_DONOR_ID);
            throw new DonorNotValidFieldException(msg);
        } else if (donorDTO.getGender().toString() != "MALE" ||
                donorDTO.getGender().toString() != "FEMALE"){
            String msg = String.format("Invalid input for field: %s", DONOR_FIELD_GENDER);
            throw new DonorNotValidFieldException(msg);
        } else if (donorDTO.getBloodType().toString() != "A" ||
                donorDTO.getBloodType().toString() != "B" ||
                donorDTO.getBloodType().toString() != "AB" ||
                donorDTO.getBloodType().toString() != "ZERO"){
            String msg = String.format("Invalid input for field: %s", DONOR_FIELD_BLOOD_TYPE);
            throw new DonorNotValidFieldException(msg);
        } else if (donorDTO.getNumberOfDonations()<0){
            String msg = String.format("Invalid input for field: %s", DONOR_FIELD_NUMBER_OF_DONATIONS);
            throw new DonorNotValidFieldException(msg);
        } else if (donorDTO.getLastDonationDate().after(donorDTO.getFirstDonationDate())){
            String msg = String.format("Invalid input for field: %s", DONOR_FIELD_LAST_DONATION_DATE);
        }
    }
}
