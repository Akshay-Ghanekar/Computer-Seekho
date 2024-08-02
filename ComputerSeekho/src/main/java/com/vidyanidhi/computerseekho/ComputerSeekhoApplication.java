package com.vidyanidhi.computerseekho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.computerseekho")
@EntityScan(basePackages = "com.computerseekho")
@EnableJpaRepositories(basePackages = "com.computerseekho")
public class ComputerSeekhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerSeekhoApplication.class, args);
	}

}
