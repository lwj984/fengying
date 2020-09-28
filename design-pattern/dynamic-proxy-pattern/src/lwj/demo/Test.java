package lwj.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author liuweijia
 * @date 2018年7月13日 下午4:02:44 
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Class<?>[] infs = new Class[] { Person.class };
        InvocationHandler h = new ProxyHandler(new Man());
        Person proxy = (Person) Proxy.newProxyInstance(Man.class.getClassLoader(), infs, h);

        proxy.sayHello();
        proxy.saySomething("hello world");
    }

}
