public class Task1 {

  public static void main(String[] args) {
   
    System.out.println("Prime numbers between 2 and 100:");

    // Перебор чисел
    for (int x = 2; x < 100; x++) {
      if (isPrime(x)) {
        System.out.println(x);
      }
    }
  }

  // Проверка простые ли числа
  public static boolean isPrime(int y) {
    if (y <= 1) return false;
    for (int x = 2; x * x <= y; x++) {
      if (y % x == 0) {
        return false;
      }
    }
    return true;
  }
}