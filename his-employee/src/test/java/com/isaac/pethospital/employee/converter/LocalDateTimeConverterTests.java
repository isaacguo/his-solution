package com.isaac.pethospital.employee.converter;

import org.apache.tomcat.jni.Local;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LocalDateTimeConverterTests {

    LocalDateTimeConverter converter = new LocalDateTimeConverter();

    @Test
    public void givenLocalDateTimeWhenConverterToTimestampThenShouldBeOK() {
        LocalDateTime time = LocalDateTime.of(2018, 2, 2, 10, 20);
        Timestamp timestamp = converter.convertToDatabaseColumn(time);
        assertThat(timestamp.toString()).isEqualToIgnoringCase("2018-02-02 10:20:00.0");
        assertThat(timestamp.toLocalDateTime()).isEqualByComparingTo(time);
    }

    @Test
    public void givenTimestampWhenConverterToLocalDateTimeThenShouldBeOK() {
        Timestamp timestamp = new Timestamp(1517538000000L);
        LocalDateTime localDateTime = converter.convertToEntityAttribute(timestamp);
        assertThat(localDateTime.getYear()).isEqualTo(2018);
        assertThat(localDateTime.getMonthValue()).isEqualTo(2);
        assertThat(localDateTime.getDayOfMonth()).isEqualTo(2);
        assertThat(localDateTime.getHour()).isEqualTo(10);
    }


}
