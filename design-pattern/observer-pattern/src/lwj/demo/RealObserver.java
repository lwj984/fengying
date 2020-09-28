package lwj.demo;

import java.util.Observable;
import java.util.Observer;

public class RealObserver implements Observer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealObserver(String name, Observable observable) {
        super();
        this.name = name;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println(name + "收到通知");
    }
}
