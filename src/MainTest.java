import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        WriterCustom writer = new WriterCustom();
        CustomManager manager = new CustomManager();
        writer.writerCustomCSV("D:\\Demo\\writeFile.csv",manager.getMap());
    }
}
