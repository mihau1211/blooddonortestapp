package com.example.blooddonorapp.controllers;

import com.example.blooddonorapp.exception.donor.DonorNotValidFieldException;
import com.example.blooddonorapp.persistence.entities.DonorDTO;
import com.example.blooddonorapp.persistence.services.DonorService;
import com.example.blooddonorapp.security.validator.DonorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/donors")
public class DonorController {
    private DonorService donorService;
    private DonorValidator donorValidator;

    @Autowired
    public DonorController(DonorService donorService, DonorValidator donorValidator) {
        this.donorService = donorService;
        this.donorValidator = donorValidator;
    }

    private DonorNotValidFieldException donorNotValidFieldException(String msg){
        return new DonorNotValidFieldException(msg);
    }

    @PostMapping
    @Validated(DonorValidator.class)
    public ResponseEntity<DonorDTO> save(@RequestBody DonorDTO donorDTO, BindingResult result){
        donorValidator.validate(donorDTO, result);
        return new ResponseEntity<>(donorService.save(donorDTO), HttpStatus.CREATED);
    }

    @PutMapping
    @Validated(DonorValidator.class)
    public ResponseEntity<DonorDTO> update(@RequestBody DonorDTO donorDTO, BindingResult result){
        donorValidator.validate(donorDTO, result);

        return new ResponseEntity<>(donorService.update(donorDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DonorDTO> findById(@PathVariable @Min(1) Long id){
        return new ResponseEntity<>(donorService.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DonorDTO>> findAll() {
        return new ResponseEntity<>(donorService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable @Min(1) Long id){
        donorService.deleteById(id);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<DonorDTO>> findByName(@PathVariable String name){
        return new ResponseEntity<>(donorService.findByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/surname/{surname}")
    public ResponseEntity<List<DonorDTO>> findBySurname(@PathVariable String surname){
        return new ResponseEntity<>(donorService.findBySurname(surname), HttpStatus.OK);
    }

    @GetMapping(value = "/gender/{gender}")
    public ResponseEntity<List<DonorDTO>> findByGender(@PathVariable String gender){
        return new ResponseEntity<>(donorService.findByGender(gender), HttpStatus.OK);
    }

    @GetMapping(value = "/bloodType/{bloodType}")
    public ResponseEntity<List<DonorDTO>> findByBloodType(@PathVariable String bloodType){
        return new ResponseEntity<>(donorService.findByBloodType(bloodType), HttpStatus.OK);
    }

    @GetMapping(value = "/city/{city}")
    public ResponseEntity<List<DonorDTO>> findByCity(@PathVariable String city){
        return new ResponseEntity<>(donorService.findByCity(city), HttpStatus.OK);
    }

    @GetMapping(value = "/donation/{id}")
    public ResponseEntity<DonorDTO> findByDonationId(@PathVariable @Min(1) Long id){
        return new ResponseEntity<>(donorService.findDonorByDonationId(id), HttpStatus.OK);
    }
}
