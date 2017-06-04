package com.teamid;

import com.teamid.repository.ScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class TicketBookingBackEndApplication {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TicketBookingBackEndApplication.class);
		app.setWebEnvironment(true);
		app.run(args);
	}

	@Bean
	public CommandLineRunner init(ScheduleRepository scheduleRepository) {
		return args -> {
//			scheduleRepository.save(new Schedule(1, 2, 3,
//                    LocalDateTime.of(2017, 6, 4, 11, 33), "yeyeye", 500));
//            scheduleRepository.save(new Schedule(1, 2, 3,
//                    LocalDateTime.of(2016, 6, 4, 11, 22), "yeyeye", 500));
//            scheduleRepository.save(new Schedule(1, 2, 3,
//                    LocalDateTime.of(2018, 6, 4, 11, 44), "yeyeye", 500));
//            Schedule temp1 = scheduleRepository.findOne(1L);
//            Schedule temp2 = scheduleRepository.findOne(2L);
//            Schedule temp3 = scheduleRepository.findOne(3L);
//            logger.info(LocalDateTimeUtils.getDifference(temp1.getStartTime(), temp2.getStartTime()) + "");
//            logger.info(LocalDateTimeUtils.getDifference(temp1.getStartTime(), temp3.getStartTime()) + "");

        };
	}

}
