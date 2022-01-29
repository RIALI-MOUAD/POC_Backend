package com.example.Agenda_C;

import com.example.Agenda_C.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class AgendaCApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaCApplication.class, args);
	}

}