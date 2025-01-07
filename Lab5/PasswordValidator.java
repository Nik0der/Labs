package Lab5;

public class PasswordValidator {
    public static void main(String[] args) {
        String password = "hfdDinm6ik";  
        try {
            if (password == null || password.isEmpty()) {
                throw new IllegalArgumentException("Пароль не должен быть пустым!");
            }
            boolean valid = password.matches("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{3,5}$");
            System.out.println(valid ? "Пароль корректен!" : "Пароль некорректен!");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}