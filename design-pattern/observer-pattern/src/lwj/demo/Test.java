package lwj.demo;

import java.util.Observer;

public class Test {

    public static void main(String[] args) {
        RealSubject subject = new RealSubject();

        Observer o1 = new RealObserver("观察者1", subject);
        Observer o2 = new RealObserver("观察者2", subject);
        Observer o3 = new RealObserver("观察者3", subject);

        subject.deleteObserver(o2);

        subject.change();
    }

}
