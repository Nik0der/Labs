import java.io.FileWriter;
import java.io.IOException;

class CustomEmptyStackException extends RuntimeException {
    public CustomEmptyStackException(String message) {
        super(message);
    }
}

class CustomStack {
    private int[] stack = new int[5];
    private int top = -1;

    public void push(int value) {
        if (top < stack.length - 1) {
            stack[++top] = value;
        } else {
            System.out.println("Стек переполнен!");
        }
    }

    public int pop() {
        if (top == -1) {
            throw new CustomEmptyStackException("Ошибка: попытка извлечь элемент из пустого стека");
        }
        return stack[top--];
    }
}

class ExceptionLogger {
    private static final String LOG_FILE = "exceptions_log.txt";

    public static void logException(Exception e) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write("Исключение: " + e.toString() + "\n");
            writer.write("Сообщение: " + e.getMessage() + "\n");
            writer.write("------------\n");
            writer.flush();
        } catch (IOException ioException) {
            System.out.println("Ошибка записи в лог файл: " + ioException.getMessage());
        }
    }
}

public class Third {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        
        try {
            stack.pop();
        } catch (CustomEmptyStackException e) {
            System.out.println(e.getMessage());
            ExceptionLogger.logException(e);
        }
    }
}