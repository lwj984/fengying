package lwj.demo.entity;

import lwj.demo.intfs.Plant;

public class Flower implements Plant {

    @Override
    public void photosynthesis() {
        System.out.println("Flower photosynthesis");
    }

}
