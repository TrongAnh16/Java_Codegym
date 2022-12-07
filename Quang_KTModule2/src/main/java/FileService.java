import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileService {
    public void writeData(String path, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : list) {
                bufferedWriter.write(line + "\n");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
