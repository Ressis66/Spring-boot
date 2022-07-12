package ru.otus.vaganov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import ru.otus.vaganov.domain.Question;
import ru.otus.vaganov.domain.User;
import ru.otus.vaganov.service.QuestionService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class VaganovApplication implements CommandLineRunner {

	@Autowired
 	QuestionService service;

	public static void main(String[] args) {
		SpringApplication.run(VaganovApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 service.initTestingService();
	}
}


