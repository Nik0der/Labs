package Lab3;

public class Main {
    public static void main(String[] args) {

        HashTable<Integer, Order> orders = new HashTable<>(5);

        orders.put(1, new Order("2024-12-28", "Телефон, Наушники", "Обрабатывается"));
        orders.put(2, new Order("2024-12-29", "Ноутбук", "Ожидает оплаты"));
        orders.put(3, new Order("2024-12-30", "Чехол", "Доставлен"));

        System.out.println("После добавления заказов:");
        orders.printTable();

        System.out.println("\nПолучение заказа 2:");
        System.out.println(orders.get(2));

        System.out.println("\nУдаление заказа 3:");
        orders.remove(3);

        System.out.println("После удаления заказа:");
        orders.printTable();
    }
}
