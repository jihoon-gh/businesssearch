package com.businesssearch;

import org.springframework.boot.SpringApplication;

public class TestBusinesssearchApplication {

	public static void main(String[] args) {
		SpringApplication.from(BusinesssearchApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
