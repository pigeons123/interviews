package com.atguigu.interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Rain
 * @version 1.0
 * @date 2021/1/21 11:58
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);
        atomicInteger.compareAndSet(6,7);
        System.out.println(atomicInteger.get());
    }
}
