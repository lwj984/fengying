package lwj.demo;

import lwj.demo.factory.BiologyFactory;
import lwj.demo.factory.FactoryProducer;
import lwj.demo.intfs.Animal;
import lwj.demo.intfs.Plant;

public class Test {

    public static void main(String[] args) {
        BiologyFactory factory = FactoryProducer.getFactory("animal");

        Animal cat = factory.getAnimal("cat");
        Animal dog = factory.getAnimal("dog");

        cat.move();
        dog.move();

        factory = FactoryProducer.getFactory("plant");

        Plant flower = factory.getPlant("flower");
        Plant tree = factory.getPlant("tree");

        flower.photosynthesis();
        tree.photosynthesis();
    }

}
