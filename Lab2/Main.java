package Lab2;

public class Main {
    public static void main(String[] args) {

        Sword sword = new Sword("Молот Рока", 150000, 200);
        Bow bow = new Bow("Лук Банши", 100000, 250000);
        MagicWand wand = new MagicWand("Посох Кадгара", 200000, 75000);

        sword.attack();
        bow.attack();
        wand.attack();

        System.out.println("Всего создано оружия: " + Weapon.getWeaponCount());
    }
}