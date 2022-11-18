package com.rbc.dowjoneschallenge.stock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(StockRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Stock(1L,"1","AA","1/7/2011","$15.82","$16.72","$15.78","$16.42","239655616","3.79267","","","$16.71","$15.97","-4.42849","26","0.182704")));
            log.info("Preloading " + repository.save(new Stock(2L,"1","AA","1/14/2011","$16.71","$16.71","$15.64","$15.97","242963398","-4.42849","1.380223028","239655616","$16.19","$15.79","-2.47066","19","0.187852")));
            log.info("Preloading " + repository.save(new Stock(3L,"1","AXP","1/7/2011","$43.30","$45.60","$43.11","$44.36","45102042","2.44804","","","$44.20","$46.25","4.63801","89","0.405771")));

        };
    }
}
