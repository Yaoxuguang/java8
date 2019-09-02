package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.lambda_methodreference;

import java.util.ArrayList;
import java.util.List;

/**
 * Lamdba表达式的例子
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/7/24 10:02
 */
public class LambdaFirstDemo {
    public static void main(String[] args) {
    // (int x) -> x + 1;

        List<Apple> apples = new ArrayList<>(5000);
//        Apple apple1 = new Apple("ap1",12.2);
//        Apple apple2 = new Apple("ap2",14.3);
        for (int i = 0; i < 5000; i++) {
            Apple apple = new Apple("ap"+i,i*1.00);
            apples.add(apple);
        }
        long beginTime = System.currentTimeMillis();
        apples.forEach(apple -> {
            apple.setName("test");
            apple.setWeight(10.0);
        });
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时:"+(endTime - beginTime));
    }

    static class Apple{
        private String name;
        private double weight;

        public Apple(String name, double weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
    }
}
