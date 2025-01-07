package Lab5;

public class Lowercase {
    public static void main(String[] args) {
        String text = "asdqBqwe cdfDd eacFwq";
        String result = text.replaceAll("(?<=[a-z])[A-Z]", "!$0!");
        System.out.println(result);
    }
}