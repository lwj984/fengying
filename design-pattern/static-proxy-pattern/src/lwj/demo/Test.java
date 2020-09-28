package lwj.demo;

/**
 * 静态代理
 *
 * @author liuweijia
 * @date 2018年7月13日 下午4:02:44 
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Person m = new Man();
        PersonProxy proxy = new PersonProxy(m);

        proxy.sayHello();
        proxy.saySomething("hello world");
    }

}
