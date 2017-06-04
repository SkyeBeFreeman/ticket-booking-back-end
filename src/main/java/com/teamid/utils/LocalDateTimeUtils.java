package com.teamid.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by Skye on 2017/6/4.
 */
public class LocalDateTimeUtils {

    public static long getDifference(LocalDateTime sourceTime, LocalDateTime targetTime) {
        return targetTime.until(sourceTime, ChronoUnit.MINUTES);
    }

}
