package com.zpc.myself.study.test.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Condition condition = lock.newCondition();


    }
}
class TestWay{
    public void testOne() {
        System.out.println("test one");
    }
    public void testTwo() {
        System.out.println("test two");
    }
    public void testThree() {
        System.out.println("test three");
    }
}

