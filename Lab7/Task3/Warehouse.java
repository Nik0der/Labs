package Task3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Warehouse {
    private final int MAX_WEIGHT = 150;
    private int currentWeight = 0;
    private Lock lock = new ReentrantLock();
    private Condition canLoad = lock.newCondition();

    public void addWeight(int weight, String loaderName) {
        lock.lock(); 
        try {
            while (currentWeight + weight > MAX_WEIGHT) {
                System.out.println(loaderName + " ждёт, пока освободится место.");
                canLoad.await();
            }

            currentWeight += weight; 
            System.out.println(loaderName + " добавил " + weight + " кг. Текущий вес: " + currentWeight);

            if (currentWeight == MAX_WEIGHT) {
                unload();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void unload() {
        System.out.println("Тележка заполнена. Разгружаем...");
        currentWeight = 0; 
        canLoad.signalAll(); 
    }
}