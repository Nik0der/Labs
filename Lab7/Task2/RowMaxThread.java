package Task2;

public class RowMaxThread extends Thread {
    private int[] row; 
    private int max;

    public RowMaxThread(int[] row) {
        this.row = row;
        this.max = Integer.MIN_VALUE;
    }

    @Override
    public void run() {

        for (int value : row) {
            max = Math.max(max, value);
        }
    }

    public int getMax() {
        return max;
    }
}

