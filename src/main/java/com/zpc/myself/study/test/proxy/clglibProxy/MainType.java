package com.zpc.myself.study.test.proxy.clglibProxy;

public class MainType {
    public static void main(String[] args) {
        MainType mainType = new MainType();
        mainType.testOne();

    }

    private void testOne() {
        DoCreate doCreate = new DoCreate();
        DoCreate proxyInstance = (DoCreate)new ProxyFactory(doCreate).getProxyInstance();
        proxyInstance.create();

    }


}

















