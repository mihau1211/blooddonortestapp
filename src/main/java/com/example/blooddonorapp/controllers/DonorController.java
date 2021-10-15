package com.example.blooddonorapp.controllers;

import com.example.blooddonorapp.persistence.services.DonorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donors")
public class DonorController {
    private DonorService donorService;

}
