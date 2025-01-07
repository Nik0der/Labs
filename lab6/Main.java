package lab6;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println("Верхний элемент: " + stack.peek()); 
        System.out.println("Удалён элемент: " + stack.pop());   
        System.out.println("Верхний элемент после удаления: " + stack.peek()); 
    }
}
