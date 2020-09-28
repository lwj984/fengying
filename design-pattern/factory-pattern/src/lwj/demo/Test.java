package lwj.demo;

public class Test {

    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();

        Animal cat = factory.getAnimal("cat");
        Animal dog = factory.getAnimal("dog");

        cat.move();
        dog.move();
    }

}
