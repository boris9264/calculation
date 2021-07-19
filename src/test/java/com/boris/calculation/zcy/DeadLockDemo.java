package com.boris.calculation.zcy;

/**
 * @author boris
 * @description DeadLockDemo
 * @date Created on 2021/6/28
 */
public class DeadLockDemo implements Runnable{
    Object lockA;
    Object lockB;

    public DeadLockDemo(Object lockA, Object lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "获得锁" + lockA + " 试图获得锁" + lockB);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "获得锁" + lockA + " 获得锁" + lockB);
            }
        }
    }

    public static void main(String[] args) {
        Object lockA = "lockA";
        Object lockB = "lockB";
        DeadLockDemo deadLockDemo1 = new DeadLockDemo(lockA, lockB);
        DeadLockDemo deadLockDemo2 = new DeadLockDemo(lockB, lockA);

        new Thread(deadLockDemo1, "t1").start();
        new Thread(deadLockDemo2, "t2").start();
    }
}
