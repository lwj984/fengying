package lwj.demo.entity;

import lwj.demo.intfs.Plant;

public class Tree implements Plant {

    @Override
    public void photosynthesis() {
        System.out.println("Tree photosynthesis");
    }

}
