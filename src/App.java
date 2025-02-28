import java.util.ArrayList;

class MyHero {
    String name;
    private double health;
    public int magicPower;
    private int armor;

    protected Weapon weapon;

    public MyHero(String name, double health, int magicPower, int armor) {
        this.name = name;
        this.health = health;
        this.magicPower = magicPower;
        this.armor = armor;
        this.weapon = null;
    }

    // Setter untuk menambahkan weapon
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public String getRank() {
        if (this.getMagicPower() > 100) {
            return "Hero Rank S";
        } else if (this.getMagicPower() >= 50) {
            return "Hero Rank B";
        } else if (this.getMagicPower() >= 30) {
            return "Hero Rank C";
        } else {
            return "Hero Rank D";
        }
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("magicPower: " + magicPower);
        System.out.println("Armor: " + armor);

        if (weapon != null) {
            System.out.println("Weapon: " + weapon.getName());
            System.out.println("Weapon Attack Power: " + weapon.getAttackPower());
        } else {
            System.out.println("Weapon: None");
        }
    }

}

class Weapon {
    private double attackPower;
    private String name;

    Weapon(String name, double attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public String getName() {
        return name;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Attack Power: " + attackPower);
    }
}

public class App {
    public static void main(String[] args) {

        ArrayList<MyHero> heroList = new ArrayList<MyHero>();

        // Object untuk Hero
        MyHero hero1 = new MyHero("Hunter Jinwo", 100, 100, 10);
        MyHero hero2 = new MyHero("Hunter Cha", 100, 30, 1);

        // Obeject Untuk Weapon
        Weapon sword = new Weapon("The Sword of Light", 50);
        Weapon dagger = new Weapon("Demon King's Daggers", 30);

        hero1.setWeapon(sword);
        hero2.setWeapon(dagger);

        // Setter
        hero1.setHealth(200);

        hero1.getHealth();

        heroList.add(hero1);
        heroList.add(hero2);

        for (MyHero hero : heroList) {

            System.out.println();
            System.out.println(hero.getRank());

            hero.display();
            System.out.println();
        }

    }
}
