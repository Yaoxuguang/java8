package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.newdate;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

/**
 * java8 新日期 java.time.*
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/14 12:00
 */
@Slf4j
public class JodaTimeDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2019, 3, 18);
        //获取年份
        log.info("年份："+localDate.getYear());
        log.info("年份："+localDate.get(ChronoField.YEAR));

        //获取月份
        log.info("月份："+localDate.getMonth());
        log.info("月份："+localDate.get(ChronoField.MONTH_OF_YEAR));
        //获取天
        log.info("天："+localDate.getDayOfYear());
        log.info("天："+localDate.getDayOfMonth());
        log.info("天："+localDate.getDayOfWeek());
        //从系统中获取当前日期
        log.info(String.valueOf(LocalDate.now()));
    }
}
