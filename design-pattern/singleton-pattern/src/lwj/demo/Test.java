package lwj.demo;

public class Test {

    public static void main(String[] args) {
        Sun s1 = Sun.getInstance();
        Sun s2 = Sun.getInstance();
        System.out.println(s1.getId());
        System.out.println(s2.getId());
    }

}
