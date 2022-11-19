package com.resttemplate.client.resttemplatedemo;

import com.resttemplate.client.rest.EntryController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = EntryController.class)
public class RestTemplateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplateDemoApplication.class, args);
	}

}
