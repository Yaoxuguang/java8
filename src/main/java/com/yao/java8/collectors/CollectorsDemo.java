package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * java8 归约和汇总操作
 *
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/6 14:19
 */
@Slf4j
public class CollectorsDemo {
    public static void main(String[] args) {
        //计数
        List<Friut> friutList = buildFriutList();
        Long count = friutList.stream().collect(Collectors.counting());
        log.info(String.valueOf(count));
        long count1 = friutList.stream().count();
        log.info(String.valueOf(count1));

        //最大值、最小值
        Comparator<Friut> comparator = Comparator.comparing(Friut::getWeight);
        Optional<Friut> collect = friutList.stream().collect(Collectors.maxBy(comparator));
        log.info(collect.get().toString());

        //汇总
        Double collect1 = friutList.stream().collect(Collectors.summingDouble(Friut::getWeight));
        log.info(String.valueOf(collect1));

        Double collect2 = friutList.stream().collect(Collectors.reducing(0.00, Friut::getWeight, (i, j) -> i + j));
        log.info(String.valueOf(collect2));
    }
    @Data
    @AllArgsConstructor
    static class Friut {
        private String name;
        private double weight;
    }

    private static List<Friut> buildFriutList() {
        List<Friut> friutList = new ArrayList<>();
        Friut friut1 = new Friut("apple",10.01);
        Friut friut2 = new Friut("banana",9.99);
        Friut friut3 = new Friut("orange",6.25);
        Friut friut4 = new Friut("shuimitao",10.02);
        friutList.add(friut1);
        friutList.add(friut2);
        friutList.add(friut3);
        friutList.add(friut4);
        return friutList;
    }
}
