public class Task2 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++){
            String s = args[i];
            if (isPalindrome(s)) System.out.println(s + " is palindrome");
            else System.out.println(s + " is not palindrome");
        }
    }
    public static String reverseString(String s){
        int len = s.length();
        String newString = "";
        for (int i = len - 1; i >= 0; i--){
            newString += s.charAt(i);

        }
        return newString;
    }
    public static boolean isPalindrome(String s){
        return s.equals(reverseString(s));
    }
}
