package lwj.demo;

public class PersonProxy implements Person {

    private Person man;

    public PersonProxy(Person man) {
        this.man = man;
    }

    @Override
    public String sayHello() {
        System.out.println("proxy before action");
        man.sayHello();
        System.out.println("proxy after action");
        return null;
    }

    @Override
    public String saySomething(String s) {
        System.out.println("proxy before action");
        man.saySomething(s);
        System.out.println("proxy after action");
        return null;
    }

}
