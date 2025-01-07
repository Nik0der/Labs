package Lab5;

public class IPAdress {
    public static void main(String[] args) {
        String ip = "255.255.255.255";
        try {
            if (ip == null || ip.isEmpty()) {
                throw new IllegalArgumentException("IP-адрес не должен быть пустым!");
            }

            boolean valid = ip.matches("^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$");

            System.out.println(valid ? "IP-адрес корректен!" : "IP-адрес некорректен!");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}