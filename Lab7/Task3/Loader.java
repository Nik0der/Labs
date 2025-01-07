package Task3;

import java.util.Random;

public class Loader extends Thread {
    private String name;
    private Warehouse warehouse; 

    public Loader(String name, Warehouse warehouse) {
        this.name = name;
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            int weight = random.nextInt(50) + 1;
            warehouse.addWeight(weight, name); 

            try {
                Thread.sleep(random.nextInt(1000) + 500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}