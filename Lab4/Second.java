import java.io.*;

public class Second {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("input.txt");
            FileWriter fw = new FileWriter("output.txt");
            
            int character;
            while ((character = fr.read()) != -1) {
                fw.write(character);
            }
            fr.close();
            fw.close();
            System.out.println("Копирование завершено");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файла");
        }
    }
}