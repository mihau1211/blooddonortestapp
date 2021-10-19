package com.example.blooddonorapp.security.validator;

import com.example.blooddonorapp.exception.donor.DonorNotValidFieldException;
import com.example.blooddonorapp.models.BloodType;
import com.example.blooddonorapp.models.Gender;
import com.example.blooddonorapp.persistence.entities.DonorDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

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
        System.out.println(donorDTO);

//        if (donorDTO.getDonorId()<1){
//            String msg = String.format("Invalid input for field: %s", DONOR_FIELD_DONOR_ID);
//            throw new DonorNotValidFieldException(msg);
//        } else
            if (!Gender.contains(donorDTO.getGender())){
            String msg = String.format("Invalid input for field: %s", DONOR_FIELD_GENDER);
            throw new DonorNotValidFieldException(msg);
        } else if (!BloodType.contains(donorDTO.getBloodType())){
            String msg = String.format("Invalid input for field: %s", DONOR_FIELD_BLOOD_TYPE);
            throw new DonorNotValidFieldException(msg);
        }
//            else if (donorDTO.getLastDonationDate().after(donorDTO.getFirstDonationDate())){
//            String msg = String.format("Invalid input for field: %s", DONOR_FIELD_LAST_DONATION_DATE);
//        }
    }
}
