import java.util.Arrays;

public class Task2_20 {

    public static void main(String[]args){
        // Задание 1
        System.out.println(duplicateChars("Barack", "Obama"));

        // Задание 2
        int[] arr1 = {3, 12, 7, 81, 52};
        System.out.println(dividedByThree(arr1));
        
        // Задание 3
        System.out.println(getInitials("simonov sergei evgenievich"));
        System.out.println(getInitials("kozhevnikova tatiana vitalevna"));
        
        // Задание 4
        double[] arr2 = {3.5, 7.0, 1.5, 9.0, 5.5};
        double[] arr3 = {10.0, 10.0, 10.0, 10.0};
        
        System.out.println(Arrays.toString(normalizator(arr2)));
        System.out.println(Arrays.toString(normalizator(arr3)));

        // Задание 5
        double[] arr4 = {1.6, 0, 212.3, 34.8, 0, 27.5};
        System.out.println(Arrays.toString(compressedNums(arr4))); 

        // Задание 6
        System.out.println(camelToSnake("helloWorld")); 
        
        // Задание 7
        int[] arr5 = {3, 5, 8, 1, 2, 4};
        System.out.println(secondBiggest(arr5)); // 5
        
        // Задание 8
        System.out.println(localReverse("baobab", 'b'));
        System.out.println(localReverse("Hello, I’m under the water, please help me", 'e'));
        
        // Задание 9
        System.out.println(equal(8, 1, 8));
        System.out.println(equal(5, 5, 5));
        System.out.println(equal(4, 9, 6));
        
        // Задание 10:
        System.out.println(isAnagram("LISTEN", "silent"));
        System.out.println(isAnagram("Eleven plus two?", "Twelve plus one!"));
        System.out.println(isAnagram("hello", "world"));
    }

    // Задание 1
    public static String duplicateChars(String word1, String word2) {
        String resultat = "";
        String lowerWord2 = word2.toLowerCase();
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            if (lowerWord2.indexOf(Character.toLowerCase(c)) == -1) {
                resultat += c;
            }
        }
        return resultat;
    }

    // Задание 2
    public static int dividedByThree(int[] massiv) {
        int count = 0;
        for (int number : massiv) {
            if (number % 2 != 0 && number % 3 == 0) {
                count++;
            }
        }
        return count;
    }

    // Задание 3
    public static String getInitials(String FIO) {
        String[] parts = FIO.trim().split("\\s+");
        String lastName = parts[0];
        String resultat = "";
        for (int i = 1; i < parts.length; i++) {
            resultat += parts[i].substring(0, 1).toUpperCase() + ".";
        }
        resultat += lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        return resultat;
    }

    // Задание 4
    public static double[] normalizator(double[] arr) {
        double min = arr[0];
        double max = arr[0];
        
        for (double num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        double[] resultat = new double[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            if (max == min) {
                resultat[i] = 0.0; // Если все элементы одинаковые
            } else {
                resultat[i] = (arr[i] - min) / (max - min);
                resultat[i] = Math.round(resultat[i] * 10000.0) / 10000.0; // Округление до 4 знаков после запятой
            }
        }
        
        return resultat;
    }


    // Задание 5
    public static int[] compressedNums(double[] arr) {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
        for (double num : arr) {
            if (num != 0) {
                int intNum = (int) num;
                list.add(intNum);
            }
        }
        java.util.Collections.sort(list);
        int[] resultat = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultat[i] = list.get(i);
        }
        return resultat;
    }

    // Задание 6
    public static String camelToSnake(String camelToSnake) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < camelToSnake.length(); i++) {
            char c = camelToSnake.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append('_');
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Задание 7
    public static int secondBiggest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        return secondMax;
    }

    // Задание 8
    public static String localReverse(String words, char letter) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < words.length()) {
            if (words.charAt(i) == letter) {
                sb.append(letter);
                int start = i + 1;
                int end = words.indexOf(letter, start);
                if (end == -1) {
                    sb.append(words.substring(start));
                    break;
                }
                String toReverse = words.substring(start, end);
                sb.append(new StringBuilder(toReverse).reverse().toString());
                sb.append(letter);
                i = end + 1;
            } else {
                sb.append(words.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    //Задание 9
    public static int equal(int a, int b, int c) {
        if (a == b && b == c) {
            return 3;
        } else if (a == b || b == c || a == c) {
            return 2;
        } else {
            return 0;
        }
    }

    //Задание 10
    public static boolean isAnagram(String word1, String word2) {
        word1 = word1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        word2 = word2.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        if (word1.length() != word2.length()) {
            return false;
        }

        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);

        return java.util.Arrays.equals(arr1, arr2);
    }
}