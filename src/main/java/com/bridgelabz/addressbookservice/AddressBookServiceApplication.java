package com.bridgelabz.addressbookservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressBookServiceApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(AddressBookServiceApplication.class, args);
		log.info("Address Book App Started");
		log.info("AddressBook App Started in {} Environment",
				context.getEnvironment().getProperty("environment"));
		log.info("Address Book DB user is {} ",
				context.getEnvironment().getProperty("spring.datasource.username"));
	}
}
