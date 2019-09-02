package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.newdate;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * java8 时间对象Period
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/14 17:13
 */
@Slf4j
public class PeriodDemo {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2019, 10, 1);
        //获取两个时间之间的年数、月数、天数
        Period between = Period.between(LocalDate.now(), localDate);
        log.info(String.valueOf(between.getYears()));
        log.info(String.valueOf(between.getMonths()));
        log.info(String.valueOf(between.getDays()));
        localDate.with(TemporalAdjusters.lastDayOfMonth());
    }
}
