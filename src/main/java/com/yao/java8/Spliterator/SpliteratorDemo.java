package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.Spliterator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java8 并行流 慎重选择
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/6 18:18
 */
@Slf4j
public class SpliteratorDemo {
    public static void main(String[] args) {
        List<Friut> friuts = buildFriutList();
        //java8 并行执行
        List<String> collect = friuts.stream().map(Friut::getName).parallel().collect(Collectors.toList());
        log.info(String.valueOf(collect));
        double sum = friuts.stream().mapToDouble(Friut::getWeight).parallel().sum();
        log.info(String.valueOf(sum));
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
