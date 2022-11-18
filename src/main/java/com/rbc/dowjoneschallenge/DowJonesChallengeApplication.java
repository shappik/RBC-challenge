package com.rbc.dowjoneschallenge;

import com.rbc.dowjoneschallenge.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class DowJonesChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DowJonesChallengeApplication.class, args);
	}

}
