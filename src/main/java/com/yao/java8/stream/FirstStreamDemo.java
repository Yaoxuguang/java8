package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.stream;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/2 14:28
 */
public class FirstStreamDemo {
    public static void main(String[] args) {
        List<String> list = Collections.emptyList();
        list.stream().filter(String::isEmpty).map(String::length).collect(Collectors.toList());
    }
}
