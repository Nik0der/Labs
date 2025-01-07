package Lab2;

public class Sword extends Weapon {
    private int sharpness;

    public Sword(String name, int damage, int sharpness) {
        super(name, damage);
        this.sharpness = sharpness;
    }

    public Sword(String name) {
        super(name,0);
    }

    public int getSharpness() {
        return sharpness;
    }

    public void setSharpness(int sharpness) {
        this.sharpness = sharpness;
    }

    @Override
    public void attack() {
        System.out.println(getName() + " наносит удар с уроном " + getDamage() + " и остротой " + sharpness + "!");
    }
}