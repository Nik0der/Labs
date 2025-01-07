package Task1;

public class Main {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 44, 7, 8, 9, 10};

        int middle = array.length / 2;
        int[] firstHalf = new int[middle];
        int[] secondHalf = new int[array.length - middle];

        System.arraycopy(array, 0, firstHalf, 0, middle);
        System.arraycopy(array, middle, secondHalf, 0, array.length - middle);

        ArraySumThread thread1 = new ArraySumThread(firstHalf);
        ArraySumThread thread2 = new ArraySumThread(secondHalf);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = thread1.getSum() + thread2.getSum();

        System.out.println("Сумма элементов массива: " + totalSum);
    }
}