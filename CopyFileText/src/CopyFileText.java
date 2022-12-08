import java.io.*;

public class CopyFileText {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(new File("D:\\Java_Codegym\\CopyFileText\\file1.txt"));
            outputStream = new FileOutputStream(new File("D:\\Java_Codegym\\CopyFileText\\file2.txt"));

            int length;
            byte[] buffer = new byte[1024];

            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            System.out.println("File is copied successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            inputStream.close();
            outputStream.close();
        }
    }
}
