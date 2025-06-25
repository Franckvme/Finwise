package com.finwise;

import org.springframework.boot.SpringApplication;

public class TestFinWiseBackendApplication {

	public static void main(String[] args) {
		SpringApplication.from(FinWiseBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
