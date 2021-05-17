package com.acceldata.acceldatatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.acceldata.acceldatatest.*")
public class AcceldatatestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcceldatatestApplication.class, args);
	}

}
