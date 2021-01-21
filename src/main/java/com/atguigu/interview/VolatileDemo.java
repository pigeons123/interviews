package com.atguigu.interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Rain
 * @version 1.0
 * @date 2021/1/21 0:41
 */

public class VolatileDemo {
    public static void main(String[] args) {
        Mydate mydate = new Mydate();
        for (int i=0;i<20;i++){
            new Thread(()->{
                for (int j=1;j<=1000;j++){
                    mydate.addPlusPlus();
                    mydate.addAtomic();
                }
            },String.valueOf(i)).start();
        }
       /* try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
       while (Thread.activeCount()>2){
           Thread.yield();
       }
        System.out.println(mydate.number);
        System.out.println(mydate.atomicInteger);
    }

    private static void seekByVolatile() {
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
    AtomicInteger atomicInteger=new AtomicInteger();
    public void addt060(){
        this.number=60;
    }
    public void addPlusPlus(){
        number++;
    }
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}

