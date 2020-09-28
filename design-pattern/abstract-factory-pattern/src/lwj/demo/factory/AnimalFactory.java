package lwj.demo.factory;

import lwj.demo.entity.Cat;
import lwj.demo.entity.Dog;
import lwj.demo.intfs.Animal;
import lwj.demo.intfs.Plant;

public class AnimalFactory extends BiologyFactory {

    @Override
    public Animal getAnimal(String type) {
        switch (type) {
            case "cat":
                return new Cat();
            case "dog":
                return new Dog();
            default:
                return null;
        }
    }

    @Override
    public Plant getPlant(String type) {
        // TODO Auto-generated method stub
        return null;
    }

}
