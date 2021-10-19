package com.example.blooddonorapp.controllers;

import com.example.blooddonorapp.exception.donation.DonationNotValidFieldException;
import com.example.blooddonorapp.persistence.entities.BloodBankDTO;
import com.example.blooddonorapp.persistence.entities.DonationDTO;
import com.example.blooddonorapp.persistence.entities.DonorDTO;
import com.example.blooddonorapp.persistence.services.DonationService;
import com.example.blooddonorapp.security.validator.DonationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/donations")
public class DonationController {
    private DonationService donationService;
    private DonationValidator donationValidator;

    @Autowired
    public DonationController(DonationService donationService, DonationValidator donationValidator) {
        this.donationService = donationService;
        this.donationValidator = donationValidator;
    }

    private DonationNotValidFieldException donationNotValidFieldException(String msg){
        return new DonationNotValidFieldException(msg);
    }

    @PostMapping
    @Validated(DonationValidator.class)
    public ResponseEntity<DonationDTO> save(@RequestBody DonationDTO donationDTO, BindingResult result){
        donationValidator.validate(donationDTO, result);
        return new ResponseEntity<>(donationService.save(donationDTO), HttpStatus.CREATED);
    }

    @PutMapping
    @Validated(DonationValidator.class)
    public ResponseEntity<DonationDTO> update(@RequestBody DonationDTO donationDTO, BindingResult result){
        donationValidator.validate(donationDTO, result);
        return new ResponseEntity<>(donationService.update(donationDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DonationDTO> findById(@PathVariable @Min(1) Long id){
        return new ResponseEntity<>(donationService.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DonationDTO>> findAll(){
        return new ResponseEntity<>(donationService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable @Min(1) Long id){
        donationService.deleteById(id);
    }

    @GetMapping(value = "/bloodType/{bloodType}")
    public ResponseEntity<List<DonationDTO>> findByBloodType(@PathVariable String bloodType){
        return new ResponseEntity<>(donationService.findByBloodType(bloodType), HttpStatus.OK);
    }

    @GetMapping(value = "/donor/{donorId}")
    public ResponseEntity<List<DonationDTO>> findByDonorId(@PathVariable Long donorId){
        return new ResponseEntity<>(donationService.findByDonorId(donorId), HttpStatus.OK);
    }

    @GetMapping(value = "/bloodBank/{bloodBank}")
    public ResponseEntity<List<DonationDTO>> findByBloodBank(@PathVariable BloodBankDTO bloodBankDTO){
        return new ResponseEntity<>(donationService.findByBloodBank(bloodBankDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/date/{date}")
    public ResponseEntity<List<DonationDTO>> findByBloodType(@PathVariable Date date){
        return new ResponseEntity<>(donationService.findByDonationDate(date), HttpStatus.OK);
    }
}
