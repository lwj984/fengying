package lwj.demo;

import java.util.Observable;

public class RealSubject extends Observable {

    public RealSubject() {
        super();
    }

    public void change() {
        setChanged();
        notifyObservers();
    }

}
