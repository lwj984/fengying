package lwj.demo;

public class Test {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Man proxy = (Man) cglibProxy.getProxy(Man.class);

        // 执行代理对象的方法
        proxy.sayHello();
        proxy.saySomething("hello world");
    }

}
