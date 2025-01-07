package Task3;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        Loader loader1 = new Loader("Грузчик 1", warehouse);
        Loader loader2 = new Loader("Грузчик 2", warehouse);
        Loader loader3 = new Loader("Грузчик 3", warehouse);

        loader1.start();
        loader2.start();
        loader3.start();
    }
}