import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class WriterCustom {

    CustomManager csm = new CustomManager();
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public void writerCustomCSV(String fileName, Map<Integer, Customer> map) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        try {
           fw = new FileWriter(fileName);
            for (Map.Entry<Integer, Customer> entry : map.entrySet()) {
                fw.append(String.valueOf(entry.getKey()));
                fw.append(COMMA_DELIMITER);
                fw.append(entry.getValue().getName());
                fw.append(COMMA_DELIMITER);
                fw.append(String.valueOf(entry.getValue().getAge()));
                fw.append(COMMA_DELIMITER);
                fw.append(entry.getValue().getAddress());
                fw.append(COMMA_DELIMITER);
                fw.append(entry.getValue().getId());
                fw.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Tao CSV thanh cong!");
        } catch (Exception e) {
            System.out.println("Error in CSVFileWriter!!!");
            e.getStackTrace();
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (IOException e) {
                System.out.println("Loi khi xa va dong fileCSV");
                e.getStackTrace();
            }
        }
    }


}
