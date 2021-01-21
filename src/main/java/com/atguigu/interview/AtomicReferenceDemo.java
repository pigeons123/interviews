package com.atguigu.interview;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Rain
 * @version 1.0
 * @date 2021/1/21 12:37
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<User> userAtomicReference=new AtomicReference<>();
        User z3 = new User("z3", 22);
        User l4 = new User("l4", 25);
        userAtomicReference.set(z3);
        userAtomicReference.compareAndSet(z3,l4);
        userAtomicReference.compareAndSet(z3,l4);
        System.out.println(userAtomicReference.get());
    }
}
class User{
    String username;
    int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
