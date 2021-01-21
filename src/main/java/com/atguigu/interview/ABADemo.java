package com.atguigu.interview;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Rain
 * @version 1.0
 * @date 2021/1/21 13:04
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference=new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
      /*  new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);

        },"t1").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                atomicReference.compareAndSet(100,2019);
                System.out.println(atomicReference.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t2").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("******************************************");*/
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+":"+stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
                atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
                atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"t3").start();
        new Thread(()->{
            try {
                int stamp = atomicStampedReference.getStamp();
                System.out.println(Thread.currentThread().getName()+":"+stamp);
                TimeUnit.SECONDS.sleep(3);
                atomicStampedReference.compareAndSet(100,2019,stamp,stamp+1);
                System.out.println(atomicStampedReference.getStamp());
            } catch (Exception e) {
                e.printStackTrace();
            }

        },"t4").start();
    }
}
