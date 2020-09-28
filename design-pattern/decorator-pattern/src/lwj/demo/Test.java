package lwj.demo;

public class Test {

    public static void main(String[] args) {
        Hero hero = new HeavyHero(new SpeedHero(new RealHero()));
        hero.attack();
    }

}
