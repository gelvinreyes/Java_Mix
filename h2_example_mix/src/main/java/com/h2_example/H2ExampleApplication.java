package com.h2_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
public class H2ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2ExampleApplication.class, args);
	}



}
