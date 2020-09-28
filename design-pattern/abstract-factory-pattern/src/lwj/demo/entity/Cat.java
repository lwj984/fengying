package lwj.demo.entity;

import lwj.demo.intfs.Animal;

public class Cat implements Animal {

    @Override
    public String move() {
        System.out.println("cat move");
        return null;
    }

}
