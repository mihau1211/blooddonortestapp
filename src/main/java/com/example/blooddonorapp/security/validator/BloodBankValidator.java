package com.example.blooddonorapp.security.validator;

import com.example.blooddonorapp.exception.donor.DonorNotValidFieldException;
import com.example.blooddonorapp.persistence.entities.BloodBankDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BloodBankValidator implements Validator {
    private static final String BLOOD_BANK_FIELD_BLOOD_BANK_ID = "bloodBankId";

    @Override
    public boolean supports(Class<?> clazz) {
        return BloodBankDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BloodBankDTO bloodBankDTO = (BloodBankDTO) target;
        if (bloodBankDTO.getBloodBankId() < 1){
            String msg = String.format("Invalid input for field: %s", BLOOD_BANK_FIELD_BLOOD_BANK_ID);
            throw new DonorNotValidFieldException(msg);
        }
    }
}
