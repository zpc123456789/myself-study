package com.zpc.myself.study.test.proxy.staticProxy;

public class MainType {
    public static void main(String[] args) {
        MainType mainType = new MainType();
        mainType.testTwo();
    }

    private void testOne() {
        DoCreate doCreate = new DoCreate();
        ProxyManager proxyManager = new ProxyManager(doCreate);
        proxyManager.create();
    }

    private void testTwo() {
        ProxyManager proxyManager = new ProxyManager();
        proxyManager.test();
    }
}
