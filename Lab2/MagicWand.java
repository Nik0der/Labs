package Lab2;

public class MagicWand extends Weapon {
    private int manaCost;

    public MagicWand(String name, int damage, int manaCost) {
        super(name, damage);
        this.manaCost = manaCost;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    @Override
    public void attack() {
        System.out.println(getName() + " выпускает магическую волну с уроном " + getDamage() + " за " + manaCost + " маны!");
    }
}