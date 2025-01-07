package Lab3;

public class Order {
    String date;
    String items;
    String status;

    public Order(String date, String items, String status) {
        this.date = date;
        this.items = items;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Дата: " + date + ", Товары: " + items + ", Статус: " + status;
    }
}
