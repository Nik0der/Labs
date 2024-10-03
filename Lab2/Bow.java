package Lab2;

public class Bow extends Weapon {
    private int criticalDamage; 

    public Bow(String name, int damage, int criticalDamage) {
        super(name, damage);
        this.criticalDamage = criticalDamage;
    }

    public int getCriticalDamage() {
        return criticalDamage;
    }

    public void setCriticalDamage(int criticalDamage) {
        this.criticalDamage = criticalDamage;
    }

    @Override
    public void attack() {
        System.out.println(getName() + " выпускает выстрел с уроном " + getDamage() + " и критическим уроном " + criticalDamage + "!");
    }
}