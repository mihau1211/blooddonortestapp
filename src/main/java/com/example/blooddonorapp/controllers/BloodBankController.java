package com.example.blooddonorapp.controllers;

import com.example.blooddonorapp.persistence.entities.BloodBankDTO;
import com.example.blooddonorapp.persistence.services.BloodBankService;
import com.example.blooddonorapp.security.validator.BloodBankValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/bloodBanks")
public class BloodBankController {
    private BloodBankService bloodBankService;
    private BloodBankValidator bloodBankValidator;

    @Autowired
    public BloodBankController(BloodBankService bloodBankService, BloodBankValidator bloodBankValidator) {
        this.bloodBankService = bloodBankService;
        this.bloodBankValidator = bloodBankValidator;
    }

    @PostMapping
    @Validated(BloodBankValidator.class)
    public ResponseEntity<BloodBankDTO> save(@RequestBody BloodBankDTO bloodBankDTO, BindingResult result){
//        System.out.println(bloodBankDTO);
        bloodBankValidator.validate(bloodBankDTO, result);
//        System.out.println(bloodBankDTO);
        return new ResponseEntity<>(bloodBankService.save(bloodBankDTO), HttpStatus.CREATED);
    }

    @PutMapping
    @Validated(BloodBankValidator.class)
    public ResponseEntity<BloodBankDTO> update(@RequestBody BloodBankDTO bloodBankDTO, BindingResult result){
        bloodBankValidator.validate(bloodBankDTO, result);
        return new ResponseEntity<>(bloodBankService.update(bloodBankDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BloodBankDTO> findById(@PathVariable @Min(1) Long id){
        return new ResponseEntity<>(bloodBankService.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BloodBankDTO>> findAll(){
        return new ResponseEntity<>(bloodBankService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable @Min(1) Long id){
        bloodBankService.deleteById(id);
    }

    @GetMapping(value = "/city/{city}")
    public ResponseEntity<List<BloodBankDTO>> findByCity(@PathVariable String city){
        return new ResponseEntity<>(bloodBankService.findByCity(city), HttpStatus.OK);
    }

    @GetMapping(value = "/donation/{id}")
    public ResponseEntity<BloodBankDTO> findBloodBankByDonationId(@PathVariable @Min(1) Long id){
        return new ResponseEntity<>(bloodBankService.findBloodBankByDonationId(id), HttpStatus.OK);
    }
}
