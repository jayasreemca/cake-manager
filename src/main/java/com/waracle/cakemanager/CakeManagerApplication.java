package com.waracle.cakemanager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemanager.domain.Cake;
import com.waracle.cakemanager.service.CakeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class CakeManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CakeManagerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CakeService cakeService){
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Cake>> typeReference = new TypeReference<List<Cake>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/cakes.json");
			try {
				List<Cake> cakes = mapper.readValue(inputStream,typeReference);
				cakeService.save(cakes);
				System.out.println("Cakes Saved to DB!");
			} catch (IOException e){
				System.out.println("Unable to save cakes: " + e.getMessage());
			}
		};
	}
}
