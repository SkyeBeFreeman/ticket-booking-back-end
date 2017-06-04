package com.teamid;

import com.teamid.repository.ScheduleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class TicketBookingBackEndApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TicketBookingBackEndApplication.class);
		app.setWebEnvironment(true);
		app.run(args);
	}

	@Bean
	public CommandLineRunner init(ScheduleRepository scheduleRepository) {
		return args -> {

		};
	}

}
