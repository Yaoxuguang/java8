package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.lambda_methodreference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * java8-lambda表达式
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/7/19 17:32
 */
public class FirstDemo {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>(10);
        //按苹果的重量对集合元素进行排序
        /*
          jdk8之前的写法
         */
        Collections.sort(appleList, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        /*
          jdk8的写法
         */
        appleList.sort(comparing(Apple::getWeight));
    }
    static class Apple{
        private String id;
        private Double weight;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }
    }
}
