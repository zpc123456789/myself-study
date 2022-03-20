package com.zpc.myself.study.test.proxy.clglibProxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理
 *
 * 目标对象只是一个单独的对象,并没有实现任何的接口,这个时候就可以使用以目标对象子类的方式类实现代理,这种方法就叫做:Cglib代理
 *
 * Cglib代理,也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展.
 *
 * JDK的动态代理有一个限制,就是使用动态代理的对象必须实现一个或多个接口,如果想代理没有实现接口的类,就可以使用Cglib实现.
 * Cglib是一个强大的高性能的代码生成包,它可以在运行期扩展java类与实现java接口.它广泛的被许多AOP的框架使用,例如Spring AOP和synaop,为他们提供方法的interception(拦截)
 * Cglib包的底层是通过使用一个小而块的字节码处理框架ASM来转换字节码并生成新的类.不鼓励直接使用ASM,因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉.
 * Cglib子类代理实现方法:
 * 1.需要引入cglib的jar文件,但是Spring的核心包中已经包括了Cglib功能,所以直接引入pring-core-3.2.5.jar即可.
 * 2.引入功能包后,就可以在内存中动态构建子类
 * 3.代理的类不能为final,否则报错
 * 4.目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.
 *
 */
public class ProxyFactory implements MethodInterceptor {

    private Object object;

    public ProxyFactory(Object object){
        this.object = object;
    }

    public Object getProxyInstance() {
        // 工具类
        Enhancer enhancer = new Enhancer();
        // 通过反射设置父类
        enhancer.setSuperclass(object.getClass());
        // 设置回调函数
        enhancer.setCallback(this);
        // 创建子类（代理对象）
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("想找搬砖的人请找我。。。。明白吗？？");
        // 执行代理的方法
        Object invoke = method.invoke(object, objects);
        System.out.println("活干完了快点给钱，别想赖账。");
        return invoke;
    }
}

// jdk 动态代理

//JDK中生成代理对象的API
//代理类所在包:java.lang.reflect.Proxy
//JDK实现代理只需要使用newProxyInstance方法,但是该方法需要接收三个参数,完整的写法是:
//
//static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
//注意该方法是在Proxy类中是静态方法,且接收的三个参数依次为:
//
//ClassLoader loader,:指定当前目标对象使用类加载器,获取加载器的方法是固定的
//Class<?>[] interfaces,:目标对象实现的接口的类型,使用泛型方式确认类型
//InvocationHandler h:事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
//代码示例:
//接口类IUserDao.java以及接口实现类,目标对象UserDao是一样的,没有做修改.在这个基础上,增加一个代理工厂类(ProxyFactory.java),将代理类写在这个地方,然后在测试类(需要使用到代理的代码)中先建立目标对象和代理对象的联系,然后代用代理对象的中同名方法
//
//代理工厂类:ProxyFactory.java
//
//
///**
// * 创建动态代理对象
// * 动态代理不需要实现接口,但是需要指定接口类型
// */
//public class ProxyFactory{
//
//    //维护一个目标对象
//    private Object target;
//    public ProxyFactory(Object target){
//        this.target=target;
//    }
//
//   //给目标对象生成代理对象
//    public Object getProxyInstance(){
//        return Proxy.newProxyInstance(
//                target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("开始事务2");
//                        //执行目标对象方法
//                        Object returnValue = method.invoke(target, args);
//                        System.out.println("提交事务2");
//                        return returnValue;
//                    }
//                }
//        );
//    }
//
//}
//
//测试类:App.java
//
//
///**
// * 测试类
// */
//public class App {
//    public static void main(String[] args) {
//        // 目标对象
//        IUserDao target = new UserDao();
//        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
//        System.out.println(target.getClass());
//
//        // 给目标对象，创建代理对象
//        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
//        // class $Proxy0   内存中动态生成的代理对象
//        System.out.println(proxy.getClass());
//
//        // 执行方法   【代理对象】
//        proxy.save();
//    }
//}















