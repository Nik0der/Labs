public class Task_edited1_10 {

  public static void main(String[]args){

    System.out.println(convert(5));
    System.out.println(convert(3));
    System.out.println(convert(8));
    System.out.println(callories(15, 1));
    System.out.println(callories(24, 2));
    System.out.println(callories(41, 3));
    System.out.println(things(3, 4, 2));
    System.out.println(things(5, 0, 2));
    System.out.println(things(4, 1, 4));
    System.out.println(triangle_type(5, 5, 5));
    System.out.println(triangle_type(5, 4, 5));
    System.out.println(triangle_type(3, 4, 5));
    System.out.println(triangle_type(5, 1, 1));
    System.out.println(most(8, 4));
    System.out.println(most(1, 11));
    System.out.println(most(5, 9));
    System.out.println(details(22, 1.4f, 2));
    System.out.println(details(45, 1.8f, 1.9f));
    System.out.println(details(100, 2, 2));
    System.out.println(factorial(3));
    System.out.println(factorial(5));
    System.out.println(factorial(7));
    System.out.println(divisor(48, 18));
    System.out.println(divisor(52, 8));
    System.out.println(divisor(259, 28));
    System.out.println(profit(70, 1500));
    System.out.println(profit(24, 950));
    System.out.println(profit(53, 1250));
    System.out.println(desksneeded(5, 2));
    System.out.println(desksneeded(31, 20));
    System.out.println(desksneeded(123, 58));
    }
  
  //1
  public static float convert(float litters) {
    return litters  * 3.78541f;
  }

  //2
  public static float callories(int minutes, int intens) {
    return minutes * intens;
  }

  //3
  public static int things(int boxes, int bags, int barrels) {
    return boxes * 20 + bags * 50 + barrels * 100;
  }

  //4
  public static String triangle_type(float x, float y, float z) {
    
    if (x <= 0 || y <= 0 || z <= 0 || x + y <= z || x + z <= y || y + z <= x) {
      return "Not a triangle";
    }
    else if (x == y && y == z) {
      return "isosceles";
    }
    else if (x == y || x == z || y == z){
      return "equilateral";
    }
    else {
      return "different-sided";
    }
  }

  //5
  public static int most(int a, int b) {
    return (a > b) ? a : b;
  }

  //6
  public static int details(float size, float w, float l) {
    return (int) (size / (w * l*l));
  }

  //7
  public static int factorial(int number) {
    if (number == 1) {
      return 1;
    }
    return number * factorial(number - 1);
  }

  //8
  public static int divisor(int first, int second) {
    while (first != 0 && second != 0){
      if (first>second){
        first = first - second;
      }
      else{
        second = second - first;
      }
    }
    return first + second;
  }

  //9
  public static int profit(int tickets, int price) {
    return (int)((tickets * price) * 0.72f);
  }

  //10
  public static int desksneeded(int students, int desks) {
    
    int desksrequired = (students + 1 )/2;
    int desksneeded = desksrequired - desks;
    if (desksneeded > 0){
      return desksneeded;
    }
    else{
        return 0;
    }
  }
}