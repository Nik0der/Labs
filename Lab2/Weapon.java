package Lab2;

public abstract class Weapon {
    private String name;
    private int damage;
    private static int weaponCount = 0;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
        weaponCount++;
    }
    
    public Weapon() {
        this("Unknown Weapon", 0);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public static int getWeaponCount() {
        return weaponCount;
    }

    public abstract void attack();
}