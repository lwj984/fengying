package lwj.demo.factory;

import lwj.demo.intfs.Animal;
import lwj.demo.intfs.Plant;

public abstract class BiologyFactory {

    public abstract Animal getAnimal(String type);

    public abstract Plant getPlant(String type);
}
