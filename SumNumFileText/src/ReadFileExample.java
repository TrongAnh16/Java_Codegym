import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void readTextFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line.trim());
            }
            br.close();
            System.out.println("Sum = "+sum);
        } catch (Exception e) {
            System.err.println("File khong ton tai or noi dung co loi");
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhap duong  dan file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readFileEx = new ReadFileExample();
        readFileEx.readTextFile(path);
    }
}
