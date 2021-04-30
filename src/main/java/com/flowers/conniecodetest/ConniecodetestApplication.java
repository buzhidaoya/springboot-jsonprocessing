package com.flowers.conniecodetest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;


@SpringBootApplication
public class ConniecodetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConniecodetestApplication.class, args);
	}
}

