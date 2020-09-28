package lwj.demo;

public class Sun {

    private long id;

    private static Sun sun;

    private Sun() {
        this.id = System.currentTimeMillis();
        System.out.println("create a sun");
    }

    public static Sun getInstance() {
        if (sun == null) {
            sun = new Sun();
        }
        return sun;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
