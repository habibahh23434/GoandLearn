package com.gl.go_and_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GoAndLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoAndLearnApplication.class, args);
	}

}
