package lwj.demo.drools.entity;

import lombok.Data;

@Data
public class Person {

    private String name;

    private String age;

    public Person(String name, String age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person() {
        super();
    }
}
