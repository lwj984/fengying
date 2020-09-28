package lwj.demo.entity;

import lwj.demo.intfs.Animal;

public class Dog implements Animal {

    @Override
    public String move() {
        System.out.println("dog move");
        return null;
    }

}
