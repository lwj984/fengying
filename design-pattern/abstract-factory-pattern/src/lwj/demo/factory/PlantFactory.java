package lwj.demo.factory;

import lwj.demo.entity.Flower;
import lwj.demo.entity.Tree;
import lwj.demo.intfs.Animal;
import lwj.demo.intfs.Plant;

public class PlantFactory extends BiologyFactory {

    @Override
    public Animal getAnimal(String type) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Plant getPlant(String type) {
        switch (type) {
            case "flower":
                return new Flower();
            case "tree":
                return new Tree();
            default:
                return null;
        }
    }

}
