package com.zpc.myself.study.test.mytest;


import java.util.concurrent.Callable;

public class SyncTest {
    public static void main(String[] args) throws Exception {
        TestOne testOne = new TestOne();

        Thread a = new Thread(() -> {
            try {
                testOne.getOne();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A");

        Thread b = new Thread(() -> {
            try {
                a.join();
                testOne.getTwo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B");

        Thread c = new Thread(() -> {
            try {
                b.join();
                testOne.getTwo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C");
        a.start();
        b.start();
        c.start();

    }
}

class TestOne {
    public synchronized void getOne() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("方法一");
    }

    public void getTwo() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("方法二");
    }

    public synchronized void getThree() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("方法三");
    }
}

/**
 * 实现Runnable接口
 */
class MyThead implements Runnable{

    private TestOne testOne;

    public MyThead() {

    }

    public MyThead(TestOne testOne) {
        this.testOne = testOne;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
        System.out.println("================");
        System.out.println(testOne);
        //TODO
    }
}

class MyThreadTwo extends Thread{
    @Override
    public void run() {
        System.out.println("hello thread");
    }
}

class MyThreadThree implements Callable{


    @Override
    public String call() {
        String s = "hello callable";
        System.out.println(s);
        return s;
    }
}
