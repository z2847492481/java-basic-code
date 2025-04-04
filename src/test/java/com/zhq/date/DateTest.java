package com.zhq.date;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Slf4j
public class DateTest {

    @Test
    public void getYearAndMonthAndDay() {
        LocalDateTime now = LocalDateTime.now();
        // 获取年份
        int year = now.getYear();
        log.info("year = {}", year);
        // 获取月份
        int month = now.getMonthValue();
        log.info("month = {}", month);
        // 获取日
        int dayOfMonth = now.getDayOfMonth();
        log.info("dayOfMonth = {}", dayOfMonth);
    }

    @Test
    public void testBetweenTwoLocalDateTime() {
        LocalDateTime startDateTime = LocalDateTime.of(2023, 10, 1, 12, 0);
        LocalDateTime endDateTime = LocalDateTime.of(2023, 10, 5, 14, 30);
        // 计算的时候是左闭右开区间
        log.info("between:{}", ChronoUnit.DAYS.between(startDateTime, endDateTime));
    }

    @Test
    public void testTheDayBeforeEndLocalDateTime() {
        LocalDateTime end = LocalDateTime.of(2023, 10, 1, 12, 0);
        LocalDateTime localDateTime = end.minusDays(30L);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        log.info("localDateTime = {}", localDateTime.format(formatter));
    }

    @Test
    public void getFirstDayOfLastMonth() {
        LocalDateTime end = LocalDateTime.of(2023, 10, 20, 12, 0);
        LocalDateTime localDateTime = end.minusMonths(1L).withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        log.info("localDateTime = {}", localDateTime.format(formatter));
    }

    @Test
    public void getLastDayOfLastMonth() {
        LocalDateTime end = LocalDateTime.of(2023, 10, 20, 12, 0);
        YearMonth yearMonth = YearMonth.from(end.minusMonths(1));
        LocalDate localDate = yearMonth.atEndOfMonth();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        log.info("localDate = {}", localDate.format(formatter));
    }

    @Test
    public void getFirstDayOfMonth() {
        LocalDateTime end = LocalDateTime.of(2023, 10, 20, 12, 0);
        LocalDateTime localDateTime = end.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        log.info("localDateTime = {}", localDateTime.format(formatter));
    }
}
