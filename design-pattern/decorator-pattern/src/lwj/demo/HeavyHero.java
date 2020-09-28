package lwj.demo;

public class HeavyHero implements Hero {

    private Hero hero;

    public HeavyHero(Hero hero) {
        super();
        this.hero = hero;
    }

    @Override
    public void attack() {
        System.out.println("力量很大的");
        hero.attack();
    }

}
