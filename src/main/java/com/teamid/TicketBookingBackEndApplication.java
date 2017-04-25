package com.teamid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketBookingBackEndApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TicketBookingBackEndApplication.class);
		app.setWebEnvironment(true);
		app.run(args);
	}
}
