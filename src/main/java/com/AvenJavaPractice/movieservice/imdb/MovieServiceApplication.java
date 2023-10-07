package com.AvenJavaPractice.movieservice.imdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.AvenJavaPractice.movieservice.imdb")
public class MovieServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(MovieServiceApplication.class, args);
	}

}
