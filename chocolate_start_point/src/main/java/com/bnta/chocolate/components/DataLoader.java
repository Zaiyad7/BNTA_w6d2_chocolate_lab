package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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

        Estate estate2 = new Estate ("Cadbury", "UK");
        estateRepository.save(estate2);

        Estate estate3 = new Estate ("Hershey's", "USA");
        estateRepository.save(estate3);

        // There is a shortcut to save it.
        //estateRepository.saveAll(List<>


        
        Chocolate chocolate1 = new Chocolate("Mars", 50, estate1);
        chocolateRepository.save(chocolate1);

        Chocolate chocolate2 = new Chocolate("Bouncy", 20, estate1);
        chocolateRepository.save(chocolate2);

        Chocolate chocolate3 = new Chocolate("Kiss", 10, estate2);
        chocolateRepository.save(chocolate3);

        Chocolate chocolate4 = new Chocolate("Bourneille", 70, estate3);
        chocolateRepository.save(chocolate4);


//        chocolateRepository.saveAll(Arrays.asList(chocolate1,chocolate2));

    }
    
}
