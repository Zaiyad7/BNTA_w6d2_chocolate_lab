package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    EstateRepository estateRepository;
    @Autowired
    ChocolateRepository chocolateRepository;
    
    public DataLoader(){
        
    }
    
    public void run(ApplicationArguments args){
        Estate estate1 = new Estate("chocolateFarm","Mexico");
        estateRepository.save(estate1);

        Estate estate2 = new Estate("chocolateHouse","Belgium");
        estateRepository.save(estate2);
        
        Chocolate chocolate1 = new Chocolate("Mars", 50, estate1);
        chocolateRepository.save(chocolate1);

        Chocolate chocolate2 = new Chocolate("Galaxy", 50, estate2);
        chocolateRepository.save(chocolate2);
    }
    
}
