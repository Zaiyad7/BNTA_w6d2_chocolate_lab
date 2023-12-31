package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {
    @Autowired
    ChocolateService chocolateService;

    // INDEX

//    @GetMapping
//    public ResponseEntity<List<Chocolate>> getAllChocolates(){
//        List<Chocolate> chocolates;
//        chocolates = chocolateService.getAllChocolates();
//        return new ResponseEntity<>(chocolates, HttpStatus.OK);
//    }

    // SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Chocolate>> getChocolate(@PathVariable Long id){
        Chocolate foundChocolate = chocolateService.findChocolate(id);
        return new ResponseEntity(foundChocolate, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolatesAndFilters(@RequestParam(required = false,
    name = "cocoaPercentage") Integer cocoaPercentage) {
        if(cocoaPercentage != null){
            return new ResponseEntity<>(chocolateService.findAllChocolatesOverCocoaPercentage(cocoaPercentage),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(chocolateService.findAllChocolates(), HttpStatus.OK);
    }




}
