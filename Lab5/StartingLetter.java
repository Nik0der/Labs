package Lab5;
import java.util.regex.*;

public class StartingLetter {
    public static void main(String[] args) {
        String text = "Apple and Ant are amazing.";
        String letter = "a";

        if (letter == null || letter.isEmpty() || !letter.matches("[A-Za-zА-Яа-я]")) {
            System.out.println("Ошибка: Введите одну букву (латинскую или кириллицу)!");
            return;
        }
        Matcher matcher = Pattern.compile("\\b" + Pattern.quote(letter) + "\\w*", Pattern.CASE_INSENSITIVE).matcher(text);
        System.out.println("Слова начинающиеся с буквы \"" + letter + "\":");
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("Не найдено ни одного слова начинающегося с буквы \"" + letter + "\".");
        }
    }
}