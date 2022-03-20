package com.zpc.myself.study.test.proxy.staticProxy;

import com.zpc.myself.study.test.rsp.BookRsp;
import lombok.Data;

/**
 * 静态代理，无法实现多样化
 *
 */
@Data
public class ProxyManager implements ProxyFactory{

    private DoCreate doCreate;

    private BookRsp bookRsp1;

    public ProxyManager() {}


    public ProxyManager(DoCreate doCreate) {
        this.doCreate = doCreate;
    }

    @Override
    public void create() {

        System.out.println("如果你需要找人搬砖，请找我。。");
        doCreate.create();
        System.out.println("干活结束，请把工资付清");
    }

    public void test() {
        BookRsp bookRsp2 = new BookRsp();

        System.out.println(bookRsp1);
        System.out.println(bookRsp2);

    }
}
