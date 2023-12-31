package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estates")
public class EstateController {
    
    @Autowired
    EstateService estateService;

    // INDEX
    
    @GetMapping
    public ResponseEntity<List<Estate>> getAllEstates(){
        List<Estate> estates = estateService.getAllEstates();
        return new ResponseEntity<>(estates, HttpStatus.OK);
        
    }

    // SHOW

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Estate>> getEstate(@PathVariable Long id){
        return new ResponseEntity(estateService.findEstate(id), HttpStatus.OK);
    }


    
    
}
