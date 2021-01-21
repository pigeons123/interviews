package com.atguigu.interview;

/**
 * @author Rain
 * @version 1.0
 * @date 2021/1/21 0:41
 */

public class VolatileDemo {
    public static void main(String[] args) {
        Mydate mydate = new Mydate();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                Thread.sleep(3000);
                mydate.addt060();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        while (mydate.number==0){

        }
        System.out.println(Thread.currentThread().getName()+"\t come in");
    }
}
class Mydate{
    volatile int number=0;
    public void addt060(){
        this.number=60;
    }
}

