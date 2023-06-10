package com.example.movieticketbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@RestController
public class MovieticketbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieticketbookingApplication.class, args);
	}

}
