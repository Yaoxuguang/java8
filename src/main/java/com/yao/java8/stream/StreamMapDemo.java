package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/5 15:58
 */
@Slf4j
public class StreamMapDemo {
    public static void main(String[] args) {
        List<Friut> friutList = buildFriutList();
        //对集合中每个元素进行操作
        List<String> collect = friutList.stream().map(Friut::getName).collect(Collectors.toList());
        log.info(collect.toString());
        List<Integer> collect1 = friutList.stream().map(Friut::getName).map(String::length).collect(Collectors.toList());
        log.info(collect1.toString());

        //流的扁平化
        List<String> stringList = Arrays.asList("String","Buffer");
        List<String[]> collect2 = stringList.stream().map(str -> str.split("")).distinct().collect(Collectors.toList());
        log.info(collect2.toString());
        List<Stream<String>> collect3 = stringList.stream().map(str -> str.split("")).map(Arrays::stream).distinct().collect(Collectors.toList());
        log.info(collect3.toString());
        List<String> collect4 = stringList.stream().map(str -> str.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        log.info(collect4.toString());

        //匹配
        boolean isOranger = friutList.stream().anyMatch(friut -> "oranger".equals(friut.getName()));
        log.info(String.valueOf(isOranger));
        //查找
        friutList.stream().filter(friut -> "apple".equals(friut.getName())).findAny().ifPresent(fr -> System.out.println(fr.toString()));

        //求和，最大值，最小值
        //暗含装箱的成本（double->Double）
        double weightMax = friutList.stream().map(Friut::getWeight).reduce(Double::max).orElse(0.00);
        log.info(String.valueOf(weightMax));

        //数值流，原始类型流特化
        double weightMin = friutList.stream().mapToDouble(Friut::getWeight).reduce(Double::min).orElse(0.00);
        log.info(String.valueOf(weightMin));

        //由值创建流
        Stream<String> stream = Stream.of("CAD","TCO","OTO","ABC");
        stream.map(String::toLowerCase).forEach(System.out::println);

        //由数组创建流
        int [] numbers = {2,4,66,1,7,23};
        int sum = Arrays.stream(numbers).sum();
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
