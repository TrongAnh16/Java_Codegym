import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        fan fan1 = new fan(3, true, "yellow", 10);
        fan fan2 = new fan(2, false, "blue", 5);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());

        File folder1 = new File("D:\\Java_Codegym\\OOP_Fan");
        File folder2 = new File("D:\\Java_Codegym\\OOP_Rectangle");

        System.out.println("Kiem tra folder1 co ton tai hay khong: "+folder1.exists());
        System.out.println("Kiem tra folder2 co ton tai hay khong: "+folder2.exists());

        File d1 = new File("D:\\Java_Codegym\\OOP_Fan\\Directory_1");
        d1.mkdir();

        File d2 = new File("D:\\Java_Codegym\\OOP_Fan\\Directory_2\\Directory_3");
        d2.mkdirs();

        File file1 = new File("D:\\Java_Codegym\\OOP_Fan\\Directory_1\\Vidu1.txt");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
