package com.app.web;

import com.app.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.app.dao"})
@EntityScan(basePackages = {"com.app.model"})
public class HowtocookApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowtocookApplication.class, args);
	}
}
