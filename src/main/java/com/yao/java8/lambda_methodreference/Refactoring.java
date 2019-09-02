package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.lambda_methodreference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 重构案例：原始实现方式 -> 匿名内部类实现方式 -> 使用lambda表达式 -> 使用方式引用
 *
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/7/31 18:35
 */
@Slf4j
public class Refactoring {
    /**
     * 定义一个实体类
     */
    @Data
    @AllArgsConstructor
    static class Apple {
        /**
         * 颜色
         */
        private String color;
        /**
         * 重量
         */
        private Double weight;
    }

    public static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }

    public static void main(String[] args) {
        List<Apple> appleList = buildAppleList();
        log.info("排序前："+appleList.toString());
        //对苹果集合进行排序-原始的实现方式
//        sortByCommon(appleList);

        //对苹果集合进行排序-内部类的实现方式
//        sortByInnerClass(appleList);

        //对苹果集合进行排序-lambda的实现方式
//        sortByLambda(appleList);

        //对苹果集合进行排序-方法引用的实现方式
        sortByMethodReference(appleList);
        log.info("排序后："+appleList.toString());
    }

    /**
     * 构建数据
     * @author <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
     * @date 2019/8/1 10:07
     * @return java.util.List<com.yaoxuguang.springbootjavawebtechnologyinsider.java8.lambda_methodreference.Refactoring.Apple>
     */
    private static List<Apple> buildAppleList(){
        List<Apple> appleList = new ArrayList<>(10);
        Apple app1 = new Apple("red",6.60);
        Apple app2 = new Apple("green",8.60);
        Apple app3 = new Apple("yellow",10.60);
        appleList.add(app1);
        appleList.add(app3);
        appleList.add(app2);
        return appleList;
    }

    /**
     * 普通方式排序
     * @author <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
     * @date 2019/8/1 10:49
     * @param appleList 数据集
     * @return void
     */
    private static void sortByCommon(List<Apple> appleList){
        appleList.sort(new AppleComparator());
    }
    /**
     * 内部类的方式排序
     * @author <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
     * @date 2019/8/1 10:53
     * @param appleList 数据集
     * @return void
     */
    private static void sortByInnerClass(List<Apple> appleList){
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
    }
    /**
     * lambda方式排序
     * @author <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
     * @date 2019/8/1 15:29
     * @param appleList 数据集
     * @return void
     */
    private static void sortByLambda(List<Apple> appleList){
//        appleList.sort((Apple a1,Apple a2)-> a1.getWeight().compareTo(a2.getWeight()));

//        appleList.sort((a1,a2)-> a1.getWeight().compareTo(a2.getWeight()));

      /*  Comparator<Apple> comparing = Comparator.comparing((Apple a) -> a.getWeight());
        appleList.sort(comparing);*/

        appleList.sort(Comparator.comparing(apple -> apple.getWeight()));

    }
    /**
     * 方法引用的方式排序
     * @author <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
     * @date 2019/8/1 15:29
     * @param appleList 数据集
     * @return void
     */
    private static void sortByMethodReference(List<Apple> appleList){
        appleList.sort(Comparator.comparing(Apple::getWeight));
    }
}
