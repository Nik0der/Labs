package Task1;

public class ArraySumThread extends Thread {
    private int[] array;
    private int sum; 

    public ArraySumThread(int[] array) {
        this.array = array;
        this.sum = 0;
    }

    @Override
    public void run() {
        for (int value : array) {
            sum += value;
        }
    }

    public int getSum() {
        return sum;
    }
}
