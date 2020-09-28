package lwj.demo.factory;

public class FactoryProducer {

    public static BiologyFactory getFactory(String type) {
        switch (type) {
            case "animal":
                return new AnimalFactory();
            case "plant":
                return new PlantFactory();
            default:
                return null;
        }
    }

}
