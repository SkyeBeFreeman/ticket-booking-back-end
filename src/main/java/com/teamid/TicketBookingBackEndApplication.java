package com.teamid;

import com.teamid.entity.Cinema;
import com.teamid.entity.Movie;
import com.teamid.entity.Schedule;
import com.teamid.repository.CinemaRepository;
import com.teamid.repository.MovieRepository;
import com.teamid.repository.ScheduleRepository;
import com.teamid.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.time.LocalDateTime;

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
	public CommandLineRunner init(CinemaRepository cinemaRepository,
								  MovieRepository movieRepository,
								  ScheduleRepository scheduleRepository,
								  TicketRepository ticketRepository) {
		return args -> {

			cinemaRepository.save(new Cinema("金逸珠江国际影城(大学城店)",
                                             "番禺区小谷围街贝岗村中二横路1号高高新天地商业广场B2B001铺",
                                             8.8f));
			cinemaRepository.save(new Cinema("广东科学中心IMAX巨幕影院",
                                             "番禺区大学城科普路168号（近小谷围岛）",
                                             6.0f));
			cinemaRepository.save(new Cinema("UA IMAX花城汇电影城",
                                             "天河区珠江新城花城广场花城汇B1楼1130铺（花城广场入口靠近黄埔大道）",
                                             10.0f));

			movieRepository.save(new Movie("神奇女侠",
                                           "Wonder Woman",
                                           3,
                                           "美国",
                                           "142",
                                           "2017-06-02",
                                           "故事讲述亚马逊公主戴安娜·普林斯（盖尔·加朵 饰），经过在家乡天堂岛的训练，取得上帝赐予的武器与装备，化身神奇女侠，与空军上尉史蒂夫·特雷弗（克里斯·派恩 饰）一同来到人类世界，一起捍卫和平、拯救世界，在一战期间上演了震撼人心的史诗传奇。",
                                           8.6f,
                                           "scqx.jpg",
                                           0L));
            movieRepository.save(new Movie("加勒比海盗5：死无对证",
                                           "Pirates of the Caribbean: Dead Men Tell No Tales",
                                           5,
                                           "美国",
                                           "129",
                                           "2017-05-26",
                                           "令人闻风丧胆的“海上屠夫”萨拉查船长 （哈维尔·巴登 饰）竟率领着一众夺命亡灵水手逃出了百慕大三角区。他们扬言要杀尽世上所有的海盗，头号目标就是杰克船长（约翰尼·德普 饰）。要想改写命运，杰克船长唯一的希望就是找到传说中海神波塞冬的三叉戟，拥有它就能拥有统治整个海洋的力量！为了寻获这件神器，杰克船长和聪明美丽的天文学家卡琳娜·史密斯（卡雅·斯考达里奥 饰）以及固执的年轻皇家海军亨利（布兰顿·思怀兹 饰）联手出击。航行着他那破破烂烂的“死海鸥号”，杰克船长不但决心要改变自己的厄运，同时也力求能从史上最狠毒可怕的敌人那里捡回一条命。",
                                           8.9f,
                                           "jlbhd.png",
                                           0L));
            movieRepository.save(new Movie("新木乃伊",
                                           "The Mummy",
                                           3,
                                           "美国",
                                           "106",
                                           "2017-06-09",
                                           "一位古埃及公主因以魔法谋朝不遂而被擒，并被扎成为一具木乃伊生生活埋在大漠底下，千年过后一次机缘巧合她得以重回人间，因为曾遭极刑，她怀着满腔怨恨，在复活之后，她决定利用自己可以呼唤沙尘暴的黑暗力量重新打造整个世界，并要重新建立属于自己的王朝",
                                           6.5f,
                                           "xmny.png",
                                           0L));


			scheduleRepository.save(new Schedule(1, 1, 3,
                    LocalDateTime.of(2017, 6, 4, 0, 05), "02:27", 50f));
            scheduleRepository.save(new Schedule(1, 2, 2,
                    LocalDateTime.of(2017, 5, 28, 11, 22), "13:31", 48.8f));
            scheduleRepository.save(new Schedule(1, 3, 1,
                    LocalDateTime.of(2017, 6, 10, 9, 44), "11:30", 35f));
            scheduleRepository.save(new Schedule(2, 1, 3,
                    LocalDateTime.of(2017, 6, 6, 9, 24), "11:46", 43.5f));
            scheduleRepository.save(new Schedule(2, 2, 2,
                    LocalDateTime.of(2017, 6, 1, 13, 30), "15:39", 43.5f));
            scheduleRepository.save(new Schedule(2, 3, 1,
                    LocalDateTime.of(2017, 6, 14, 19, 0), "20:46", 43.5f));
            scheduleRepository.save(new Schedule(3, 1, 3,
                    LocalDateTime.of(2017, 6, 8, 20, 0), "22:22", 68));
            scheduleRepository.save(new Schedule(3, 2, 2,
                    LocalDateTime.of(2017, 5, 27, 11, 30), "13:39", 59.8f));
            scheduleRepository.save(new Schedule(3, 3, 1,
                    LocalDateTime.of(2017, 6, 15, 22, 0), "23:46", 75f));

        };
	}

}
