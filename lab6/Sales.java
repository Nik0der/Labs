package lab6;

import java.util.*;

public class Sales {
    public static void main(String[] args) {

        Map<String, Integer> salesMap = new HashMap<>();
        
        salesMap.put("Товар1", 5);
        salesMap.put("Товар2", 3);
        salesMap.put("Товар3", 7);
        
        System.out.println("Продажи товаров: ");
        for (Map.Entry<String, Integer> entry : salesMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
