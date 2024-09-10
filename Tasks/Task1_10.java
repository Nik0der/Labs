import java.util.Scanner;

public class Task1_10 {

    //7{
    public static long factorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
    //7}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1
        System.out.print("Количество галлонов: ");
        float gallons = scanner.nextFloat();
        float liters = gallons * 3.78541f;
        System.out.println(gallons + " Галлонов = " + liters + " Литров.");

        //2
        System.out.print("\nКоличество минут: ");
        int minutes = scanner.nextInt();
        System.out.print("Интенсивность тренировки: ");
        int intens = scanner.nextInt();
        int calories = minutes * intens;
        System.out.println("Сожженых калорий: " + calories);

        //3
        System.out.print("\nКоличество коробок: ");
        int boxes = scanner.nextInt();
        int boxes_sum = boxes * 20;
        System.out.print("Количество мешков: ");
        int bags = scanner.nextInt();
        int bags_sum = bags * 50;
        System.out.print("Количество бочек: ");
        int barrels = scanner.nextInt();
        int barrels_sum = barrels * 100;
        int things = boxes_sum + bags_sum + barrels_sum;
        System.out.println("Количество товаров: " + things);

        //4
        System.out.print("\nДлина первой стороны: ");
        int x = scanner.nextInt();
        System.out.print("Длина второй стороны: ");
        int y = scanner.nextInt();
        System.out.print("Длина третьей стороны: ");
        int z = scanner.nextInt();
        if (x <= 0 || y <= 0 || z <= 0 || x + y <= z || x + z <= y || y + z <= x) {
            System.out.println("Это не треугольник");
        } else if (x == y && y == z) {
            System.out.println("Треугольник равносторонний");
        } else if (x == y || x == z || y == z) {
            System.out.println("Треугольник равнобедренный");
        } else {
            System.out.println("Треугольник разносторонний");
        }

        //5
        System.out.print("\nПервое число: ");
        int a = scanner.nextInt();
        System.out.print("Второе число: ");
        int b = scanner.nextInt();
        int more = (a > b) ? a : b;
        System.out.println(more + " больше");
        
        //6
        System.out.print("\nРазмер ткани: ");
        int size = scanner.nextInt();
        System.out.print("Ширина детали: ");
        float w = scanner.nextFloat();
        System.out.print("Длина детали: ");
        float l = scanner.nextFloat();
        int n = (int) (size / (w * l));
        System.out.println(n + " деталей");
        
        //7
        System.out.print("\nВведите число для факториала: ");
        int number = scanner.nextInt();
        long result = factorial(number);
        System.out.println("Факториал равен: " + result);

        //8
        System.out.print("\nПервое число: ");
        int first = scanner.nextInt();
        System.out.print("Второе число: ");
        int second = scanner.nextInt();

        if (first != 0 && second != 0){
            if (first>second) {
                int first2 = (first % second);
                System.out.println(first2);
            }
            else{
                int second2 = (second % first);
                System.out.println(second2);
            }
        }
        else {
            System.out.println("Общий делитель" + first+second);
        }
        //9
        System.out.print("\nКоличество билетов: ");
        int tickets = scanner.nextInt();
        System.out.print("Цена билета: ");
        int price = scanner.nextInt();
        int nds = 20;
        int profit = (tickets * price) - ((tickets*price) * nds/100);
        System.out.println("Выручка состоявляет: " + profit);
        
        //10
        System.out.print("\nКоличество парт: ");
        int desks = scanner.nextInt();
        System.out.print("Количсевто студентов: ");
        int students = scanner.nextInt();
        int desksrequired = (students +1)/2;
        int desksneeded = desksrequired - desks;
        if (desksneeded > 0){
            System.out.println("Нужно еще парт: " + desksneeded);
        }
        else{
        System.out.println("Парт хватает");
        }

        scanner.close();
    }
}