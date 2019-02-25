package com.infoshare.test;

import com.infoshare.test.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestApplication {

	@Autowired
    MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {
		System.out.println(movieRepository.findAllByYear(2018));
	}  */
}