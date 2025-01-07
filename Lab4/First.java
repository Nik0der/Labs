public class First {
    public static void main(String[] args) {

        String[] arr = {"10", "20", "30", "40", "50", "60"}; 
        
        int sum = 0;
        int count = 0;
        
        try {
            for (int i = 0; i <= arr.length; i++) {  
                sum += Integer.parseInt(arr[i]); 
                count++;
            }
            System.out.println("Среднее арифметическое: " + (sum / count));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: элемент массива не является числом");
        }
    }
}