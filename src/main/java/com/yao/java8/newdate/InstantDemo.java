package com.yaoxuguang.springbootjavawebtechnologyinsider.java8.newdate;

import java.time.Instant;

/**
 * java8 机器的日期和时间格式
 * @author: <a href="yaoxuguagn_china@126.com">yaoxuguang</a>
 * @createDate: Created in 2019/8/14 16:57
 */
public class InstantDemo {
    public static void main(String[] args) {
        //3秒
        Instant.ofEpochSecond(3);
        //3秒
        Instant.ofEpochSecond(3,0);
        //2秒后的1秒
        Instant.ofEpochSecond(2,1_000_000);
        //4秒前的1秒
        Instant.ofEpochSecond(4,-1_000_000);

    }
}
