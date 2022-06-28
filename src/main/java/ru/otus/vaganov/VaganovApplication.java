package ru.otus.vaganov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.otus.vaganov.service.QuestionService;




@SpringBootApplication
public class VaganovApplication  {

	public static void main(String[] args) {
		SpringApplication.run(VaganovApplication.class, args);
	}


}


