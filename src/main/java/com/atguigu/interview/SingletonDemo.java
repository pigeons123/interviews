package com.atguigu.interview;

/**
 * @author Rain
 * @version 1.0
 * @date 2021/1/21 11:42
 */
public class SingletonDemo {
    private  static volatile SingletonDemo singletonDemo=null;
    private SingletonDemo(){
        System.out.println("我是构造方法");
    }
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
    public static  SingletonDemo getInstance(){
        if (singletonDemo==null){
            synchronized (SingletonDemo.class){
                if (singletonDemo==null){
                    singletonDemo=new SingletonDemo();
                }

            }
        }
        return singletonDemo;
    }
}
