import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReaderCustom {

    private static final String COMMA_DELIMITER = ",";

    public Map readerCustom(String path) {
        Map<Integer,Customer> newMap =  new HashMap<>();
        FileReader fw = null;
        BufferedReader br = null;
        try {
            fw = new FileReader(path);
            br = new BufferedReader(fw);
            String line = null;

            while((line=br.readLine())!=null){
                String[]list = line.split(COMMA_DELIMITER);
                for (int i = 0; i < list.length; i++) {
                    newMap.put((Integer.parseInt(list[0])),new Customer(list[1],Integer.parseInt(list[2]),list[3],list[4]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newMap;
    }
}
