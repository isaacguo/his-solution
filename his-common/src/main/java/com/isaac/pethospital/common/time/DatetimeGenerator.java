package com.isaac.pethospital.common.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatetimeGenerator {

    public DateTimeFormatter getGeneralDateTimeFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public LocalDateTime getNowLocalDateTime()
    {
        return LocalDateTime.now();
    }
}
