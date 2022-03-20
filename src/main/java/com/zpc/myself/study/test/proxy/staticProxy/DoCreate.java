package com.zpc.myself.study.test.proxy.staticProxy;

public class DoCreate implements ProxyFactory {
    @Override
    public void create() {
        System.out.println("我是一个无情的编码机器");
    }
}
