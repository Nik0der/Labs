public class Task3_30 {
        public static void main(String[] args) {
            // 1
            System.out.println(isStrangePair("ratio", "orator"));
            System.out.println(isStrangePair("sparkling", "groups"));
            System.out.println(isStrangePair("bush", "hubris"));
            System.out.println(isStrangePair("", ""));
    
            // 2
            Object[][] items = {
                {"Laptop", 124200},
                {"Phone", 51450},
                {"Headphones", 13800}
            };
            Object[][] discountedItems = sale(items, 25);
            for (Object[] item : discountedItems) {
                System.out.println(item[0] + ": " + item[1]);
            }
    
            // 3
            System.out.println(successShoot(0, 0, 5, 2, 2));
            System.out.println(successShoot(-2, -3, 4, 5, -6));
    
            // 4
            System.out.println(parityAnalysis(243));
            System.out.println(parityAnalysis(12));
            System.out.println(parityAnalysis(3));
    
            // 5
            System.out.println(rps("rock", "paper"));
            System.out.println(rps("paper", "rock"));
            System.out.println(rps("paper", "scissors"));
            System.out.println(rps("scissors", "scissors"));
            System.out.println(rps("scissors", "paper"));
    
            // 6
            System.out.println(bugger(39));
            System.out.println(bugger(999));
            System.out.println(bugger(4));
    
            // 7
            String[][] inventory = {
                {"Скакалка", "550", "8"},
                {"Шлем", "3750", "4"},
                {"Мяч", "2900", "10"}
            };
            System.out.println(mostExpensive(inventory));
            // 8
            System.out.println(longestUnique("abcba"));
            System.out.println(longestUnique("bbb"));
            // 9
            System.out.println(isPrefix("automation", "auto-"));
            System.out.println(isSuffix("arachnophobia", "-phobia"));
            System.out.println(isPrefix("retrospect", "sub-"));
            System.out.println(isSuffix("vocation", "-logy"));
    
            // 10
            System.out.println(doesBrickFit(1, 1, 1, 1, 1));
            System.out.println(doesBrickFit(1, 2, 1, 1, 1));
            System.out.println(doesBrickFit(1, 2, 2, 1, 1));
        }
    
        // 1 Задание.
        public static boolean isStrangePair(String word1, String word2) {
            return word1.length() > 0 && word2.length() > 0 && 
            word1.charAt(0) == word2.charAt(word2.length() - 1) && 
            word1.charAt(word1.length() - 1) == word2.charAt(0);
        }
    
        // 2 Задание.
        public static Object[][] sale(Object[][] item, int discount) {
            for (int i = 0; i < item.length; i++) {
                int price = (int) item[i][1];
                item[i][1] = Math.max(1, Math.round(price * (1 - discount / 100.0f))); // Применяем скидку
            }
            return item;
        }
    
        // 3 Задание.
        public static boolean successShoot(int x, int y, int z, int n, int m) {
            return (n - x) * (n - x) + (m - y) * (m - y) <= z * z;
        }
    
        // 4 Задание.
        public static boolean parityAnalysis(int number) {
            int sum = 0;
            int originalNumber = number;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return (sum % 2) == (originalNumber % 2);
        }
    
        // 5 Задание.
        public static String rps(String player1, String player2) {
            if (player1.equals(player2)) return "Tie";
            if ((player1.equals("rock") && player2.equals("scissors")) || 
                (player1.equals("scissors") && player2.equals("paper")) || 
                (player1.equals("paper") && player2.equals("rock"))) {
                return "Player 1 win";
            }
            return "Player 2 win";
        }
    
        // 6 Задание.
        public static int bugger(int number) {
            int count = 0;
            while (number >= 10) {
                int product = 1;
                while (number > 0) {
                    product *= number % 10;
                    number /= 10;
                }
                number = product;
                count++;
            }
            return count;
        }
    
        // 7 Задание.
        public static String mostExpensive(String[][] things) {
            int maxValue = 0;
            String maxThing = "";
            for (String[] thing : things) {
                int value = Integer.parseInt(thing[1]) * Integer.parseInt(thing[2]);
                if (value > maxValue) {
                    maxValue = value;
                    maxThing = thing[0];
                }
            }
            return "Наиб. общ. стоимость у предмета " + maxThing + " - " + maxValue;
        }
    
        // 8 Задание.
        public static String longestUnique(String string) {
            String longest = "";
            for (int i = 0; i < string.length(); i++) {
                for (int j = i + 1; j <= string.length(); j++) {
                    String sub = string.substring(i, j);
                    if (sub.length() == new java.util.HashSet<>(java.util.Arrays.asList(sub.split(""))).size() && sub.length() > longest.length()) {
                        longest = sub;
                    }
                }
            }
            return longest;
        }
    
        // 9 Задание.
        public static boolean isPrefix(String word, String prefix) {
            return word.startsWith(prefix.replace("-", ""));
        }
    
        public static boolean isSuffix(String word, String suffix) {
            return word.endsWith(suffix.replace("-", ""));
        }
    
        // 10 Задание.
        public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
            return (a <= w && b <= h) || (a <= h && b <= w) || (a <= w && c <= h) || (a <= h && c <= w) || (b <= w && c <= h) || (b <= h && c <= w);
        }
    }