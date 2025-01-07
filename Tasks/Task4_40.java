import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;

public class Task4_40 {

    // Задание 1
    public static String nonRepeat(String s) {
        s = s.toLowerCase();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    count++;
                }
            }
            if (count <= 3) {
                result += s.charAt(i);
            }
        }
        return result;
    }

    // Задание 2
    public static String[] bruteForce(int n, int k) {
        if (n > k || k > 5) {
            return new String[0];
        }
        List<String> result = new ArrayList<>();
        char[] letters = new char[k];
        for (int i = 0; i < k; i++) {
            letters[i] = (char) ('0' + i);
        }
        permute(letters, n, "", result);
        return result.toArray(new String[0]);
    }

    private static void permute(char[] letters, int n, String prefix, List<String> result) {
        if (prefix.length() == n) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < letters.length; i++) {
            if (prefix.indexOf(letters[i]) == -1) {
                permute(letters, n, prefix + letters[i], result);
            }
        }
    }

    // Задание 3
    public static int[] decode(String message, String key) {
        int[] result = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            char mChar = message.charAt(i);
            char kChar = key.charAt(i % key.length());
            result[i] = mChar ^ kChar;
        }
        return result;
    }

    public static String encode(int[] numbers, String key) {
        String result = "";
        for (int i = 0; i < numbers.length; i++) {
            char kChar = key.charAt(i % key.length());
            char mChar = (char) (numbers[i] ^ kChar);
            result += mChar;
        }
        return result;
    }

    // Задание 4
    public static List<String> split(String s) {
        List<String> result = new ArrayList<>();
        int balance = 0;
        String cluster = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cluster += c;
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance == 0) {
                result.add(cluster);
                cluster = "";
            }
        }
        return result;
    }

    // Задание 5
    public static String shortHand(String s) {
        if (s.isEmpty()) {
            return "";
        }
        String result = "";
        int count = 1;
        char prevChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prevChar) {
                count++;
            } else {
                result += prevChar;
                if (count > 1) {
                    result += "*" + count;
                }
                prevChar = c;
                count = 1;
            }
        }
        result += prevChar;
        if (count > 1) {
            result += "*" + count;
        }
        return result;
    }

    // Задание 6
    public static String convertToRome(int num) {
        int[] val = {1000, 900, 500, 400,
                     100, 90, 50, 40,
                     10, 9, 5, 4,
                     1};
        String[] syms = {"M", "CM", "D", "CD",
                         "C", "XC", "L", "XL",
                         "X", "IX", "V", "IV",
                         "I"};
        String result = "";
        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                num -= val[i];
                result += syms[i];
            }
        }
        return result;
    }

    // Задание 7
    public static String uniqueSubstring(String s) {
        Map<Character, Integer> evenCounts = new HashMap<>();
        Map<Character, Integer> oddCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i % 2 == 0) {
                evenCounts.put(c, evenCounts.getOrDefault(c, 0) + 1);
            } else {
                oddCounts.put(c, oddCounts.getOrDefault(c, 0) + 1);
            }
        }
        int evenMax = Collections.max(evenCounts.values());
        int oddMax = Collections.max(oddCounts.values());
        if (evenMax > oddMax) {
            return "чет";
        } else if (oddMax > evenMax) {
            return "нечет";
        } else {
            char firstChar = s.charAt(0);
            return evenCounts.containsKey(firstChar) ? "чет" : "нечет";
        }
    }

    // Задание 8
    public static Object[] labirint(int[][] matrix) {
        int n = matrix.length;
        if (matrix[n - 1][n - 1] < 0 || matrix[0][0] < 0) {
            return new Object[]{"Прохода нет"};
        }
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[n - 1][n - 1] = matrix[n - 1][n - 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] < 0) {
                    continue;
                }
                if (i + 1 < n && matrix[i + 1][j] >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + matrix[i][j]);
                }
                if (j + 1 < n && matrix[i][j + 1] >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + matrix[i][j]);
                }
            }
        }
        if (dp[0][0] == Integer.MAX_VALUE) {
            return new Object[]{"Прохода нет"};
        }
        String path = "" + matrix[0][0];
        int i = 0, j = 0;
        while (i != n - 1 || j != n - 1) {
            if (i + 1 < n && dp[i][j] == dp[i + 1][j] + matrix[i][j]) {
                i++;
            } else if (j + 1 < n && dp[i][j] == dp[i][j + 1] + matrix[i][j]) {
                j++;
            } else {
                break;
            }
            path += "-" + matrix[i][j];
        }
        return new Object[]{path, Integer.toString(dp[0][0])};
    }

    // Задание 9
    public static String numericOrder(String s) {
        String[] words = s.split(" ");
        Map<Integer, String> wordPositions = new TreeMap<>();
        for (String word : words) {
            String position = "";
            String wordClean = "";
            for (char c : word.toCharArray()) {
                if (Character.isDigit(c)) {
                    position += c;
                } else {
                    wordClean += c;
                }
            }
            if (!position.isEmpty()) {
                int pos = Integer.parseInt(position);
                wordPositions.put(pos, wordClean);
            }
        }
        String result = "";
        for (String wordOrdered : wordPositions.values()) {
            result += " " + wordOrdered;
        }
        return result;
    }

    // Задание 10
    public static boolean fibString(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        List<Integer> countsValues = new ArrayList<>(counts.values());
        Collections.sort(countsValues);
        List<Integer> fibNumbers = new ArrayList<>();
        fibNumbers.add(0);
        fibNumbers.add(1);
        while (fibNumbers.get(fibNumbers.size() - 1) < countsValues.get(countsValues.size() - 1)) {
            int nextFib = fibNumbers.get(fibNumbers.size() - 1) + fibNumbers.get(fibNumbers.size() - 2);
            fibNumbers.add(nextFib);
        }
        Set<Integer> fibSet = new HashSet<>(fibNumbers);
        for (int count : countsValues) {
            if (!fibSet.contains(count)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Задание 1
        System.out.println(nonRepeat("abracadabra")); 
        System.out.println(nonRepeat("abababcac"));   

        // Задание 2
        System.out.println(Arrays.toString(bruteForce(1,5))); 
        System.out.println(Arrays.toString(bruteForce(2,2))); 
        System.out.println(Arrays.toString(bruteForce(5,3)));

        // Задание 3
        System.out.println(encode(new int[]{0, 31, 28, 10, 29}, "MKIIT")); 
        System.out.println(Arrays.toString(decode("MTUCI", "MKIIT"))); 

        // Задание 4
        System.out.println(split("()()()")); 
        System.out.println(split("((()))")); 
        System.out.println(split("((()))(())()()(()())"));
        System.out.println(split("((())())(()(()()))"));

        // Задание 5
        System.out.println(shortHand("abbccc")); 
        System.out.println(shortHand("vvvvaajaaaaa")); 

        // Задание 6
        System.out.println(convertToRome(8)); 
        System.out.println(convertToRome(1234)); 
        System.out.println(convertToRome(52)); 

        // Задание 7
        System.out.println(uniqueSubstring("31312131"));
        System.out.println(uniqueSubstring("1111111"));  
        System.out.println(uniqueSubstring("12223234333")); 

        // Задание 8
        System.out.println(Arrays.toString(labirint(new int[][]{
            {1, 3, 1},
            {1, -1, 1},
            {4, 2, 1}
        }))); 
        System.out.println(Arrays.toString(labirint(new int[][]{
            {2, -7, 3},
            {-4, -1, 8},
            {4, 5, 9}
        })));

        // Задание 9
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        // Задание 10
        System.out.println(fibString("CCCABDD")); 
        System.out.println(fibString("ABC")); 
    }
}
