package com.zpc.myself.study.test.mytest;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReLockTest {
    public static void main(String[] args) {

        ReentrantLockTest lockTest = new ReentrantLockTest();
//        ReentrantLockTestTwo lockTest = new ReentrantLockTestTwo();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    lockTest.testOne();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "a").start();

            new Thread(() -> {
                try {
                    lockTest.testTwo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "b").start();

            new Thread(() -> {
                try {
                    lockTest.testThree();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "c").start();
        }

    }
}


// 防止线程虚假唤醒 使用while 做条件判断，而不是使用 if 条件判断（重要）
class ReentrantLockTest {

    private Lock lock = new ReentrantLock();
    private Condition ca = lock.newCondition();
    private int flag = 0;

    public void testOne() {
        lock.lock();
        try {
            while (flag == 0) {
                System.out.println(Thread.currentThread().getName() + "-" + flag);
                flag = 1;
            }
            ca.await();
            ca.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void testTwo() {
        lock.lock();
        try {
            while (flag == 1) {
                System.out.println(Thread.currentThread().getName() + "-" + flag);
                flag = 2;
            }
            ca.await();
            ca.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void testThree() {
        lock.lock();
        try {
            while (flag == 2) {
                System.out.println(Thread.currentThread().getName() + "-" + flag);
                flag = 0;
            }
            ca.await();
            ca.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

class ReentrantLockTestTwo {

    private Lock lock = new ReentrantLock();
    private Condition ca = lock.newCondition();


    private int flag = 0;

    public synchronized void testOne() {

        try {
            if (flag == 0) {
                System.out.println(Thread.currentThread().getName() + "-" + flag);
                flag = 1;
            } else {
                ca.await();
                ca.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void testTwo() {

        try {
            if (flag == 1) {
                System.out.println(Thread.currentThread().getName() + "-" + flag);
                flag = 2;
            } else {
                ca.await();
                ca.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void testThree() {

        try {
            if (flag == 2) {
                System.out.println(Thread.currentThread().getName() + "-" + flag);
                flag = 0;
            } else {
                ca.await();
                ca.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
