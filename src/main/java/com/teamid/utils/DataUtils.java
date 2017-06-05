package com.teamid.utils;

import com.teamid.entity.*;
import com.teamid.repository.CinemaRepository;
import com.teamid.repository.MovieRepository;
import com.teamid.repository.ScheduleRepository;
import com.teamid.repository.TicketRepository;

import java.time.LocalDateTime;

/**
 * Created by Skye on 2017/6/5.
 */
public class DataUtils {

    private static final long SCHEDULE_NUM = 9;
    private static final int POSX_NUM = 6;
    private static final int POSY_NUM = 19;

    public static void addTestData(CinemaRepository cinemaRepository,
                                   MovieRepository movieRepository,
                                   ScheduleRepository scheduleRepository,
                                   TicketRepository ticketRepository) {
        /*cinemaRepository.save(new Cinema("金逸珠江国际影城(大学城店)",
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

        for (long scheduleId = 1L; scheduleId <= SCHEDULE_NUM; scheduleId++) {
            for (int posX = 1; posX <= POSX_NUM; posX++) {
                for (int posY = 1; posY <= POSY_NUM; posY++) {
                    ticketRepository.save(new Ticket(scheduleId, posX, posY));
                }
            }
        }*/

        cinemaRepository.save(new Cinema("万达影城(万胜围万达影城店)",
                "海珠区新港东路1236号万胜广场五层",
                7.5f));
        cinemaRepository.save(new Cinema("烽禾影城(南村剑桥郡店)",
                "番禺区雅居乐剑桥郡国际文化中心4楼（近剑桥郡小区）",
                5.9f));
        cinemaRepository.save(new Cinema("映联万和影城",
                "海珠区新港东路618号南丰汇广场3楼",
                9.6f));
        cinemaRepository.save(new Cinema("星河电影院(番禺区店)",
                "番禺区番禺南村兴业大道之一人人佳购物广场2楼",
                6.3f));
        cinemaRepository.save(new Cinema("东圃摩登电影城(东圃大马路店)",
                "天河区东圃大马路14号东圃摩登城3楼（近红十字医院）",
                9.0f));
        cinemaRepository.save(new Cinema("喜洋时代影城(东圃四季荟店)",
                "天河区东圃大马路4号（近东圃购物中心）",
                9.2f));
        cinemaRepository.save(new Cinema("车陂国际影城",
                "天河区中山大道87号苏宁生活广场3楼（靠近车陂地铁站D出口，车陂BRT站）",
                8.1f));
        cinemaRepository.save(new Cinema("大地影院(员村店)",
                "天河区员村二横路2号员村工人文化宫内（黄埔大道口）",
                9.7f));
        cinemaRepository.save(new Cinema("中影JAJ24小时咖啡影院(科宝商城店)",
                "番禺区大石街朝阳东路186号A栋2楼",
                6.5f));

        movieRepository.save(new Movie("迷失Z城",
                "The Lost City of Z",
                MovieType.ACTION | MovieType.ADVENTURE,
                "美国",
                "104",
                "2017-06-02",
                "1925年,英国上校福赛特（查理·汉纳姆 饰）深入亚马逊丛林寻找失落的古老文明,希望找到历史上最重大的发现。几个世纪以来,欧洲人一直坚信亚马逊这个世界上最大的丛林里掩藏着一个黄金国,然而,成干上万闯入丛林探险的人都丧身其中,这使得很多科学家认为亚马逊是人类无法进入的。但福赛特上校却三次深入丛林探险,他下定决心要证明给世人,这个被他称为“Z城”的古老文明是真实存在过的。",
                5.8f,
                "mszc.jpg",
                0L));
        movieRepository.save(new Movie("异形：契约",
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

        for (long scheduleId = 1L; scheduleId <= SCHEDULE_NUM; scheduleId++) {
            for (int posX = 1; posX <= POSX_NUM; posX++) {
                for (int posY = 1; posY <= POSY_NUM; posY++) {
                    ticketRepository.save(new Ticket(scheduleId, posX, posY));
                }
            }
        }
    }

}
