package lwj.demo;

public class SpeedHero implements Hero {

    private Hero hero;

    public SpeedHero(Hero hero) {
        super();
        this.hero = hero;
    }

    @Override
    public void attack() {
        System.out.println("速度很快的");
        hero.attack();
    }

}
