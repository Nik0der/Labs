package Lab5;

import java.util.regex.*;

public class NumberFinder {
        public static void main(String[] args) {
            String text = "Цена товара $19.99, скидка 20%";
            Matcher matcher = Pattern.compile("-?\\d+(\\.\\d+)?").matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }
    }