package com.atguigu.interview;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Rain
 * @version 1.0
 * @date 2021/1/21 13:28
 */
/*
    对于ArrayList的线程不安全问题来如何解决？
    1.可以用Vector
    2.可以用Collections.synchronized(new ArrayList<>());
    3.CopyOnRightArrayList
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        // List<String> list = new Vector <>();
        // List<String> list  = Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
