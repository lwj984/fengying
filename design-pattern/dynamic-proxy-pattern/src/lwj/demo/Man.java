package lwj.demo;

public class Man implements Person {

    @Override
    public String sayHello() {
        String s = "hello";
        System.out.println(s);
        return s;
    }

    @Override
    public String saySomething(String s) {
        System.out.println(s);
        return s;
    }

}
