package com.example.MTIT_IT19132938;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.MTIT_IT19132938.repository.cartRepository;

@SpringBootApplication
public class MtitApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MtitApplication.class, args);
	}

	@Autowired
	private cartRepository cartRepository;

	@Override
	public void run(String... args) throws Exception {

	}
}
