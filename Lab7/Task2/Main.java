package Task2;

public class Main {
    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3},
            {7, 34, 6},
            {4, 8, 9}
        };

        int rows = matrix.length;
        RowMaxThread[] threads = new RowMaxThread[rows];

        for (int i = 0; i < rows; i++) {
            threads[i] = new RowMaxThread(matrix[i]);
            threads[i].start(); 
        }

        int globalMax = Integer.MIN_VALUE;
        try {
            for (RowMaxThread thread : threads) {
                thread.join();
                globalMax = Math.max(globalMax, thread.getMax()); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Максимальный элемент в матрице: " + globalMax);
    }
}