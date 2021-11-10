import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class FileController {
    private Scanner scanner;
    private File file;
    private String path = "data/data.txt";
    private ArrayList<String> data;

    public FileController() {

    }

    public ArrayList<String> readData() {
        data = new ArrayList<>();
        file = new File(path);
        String nextWord;
        int i = 0;
        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                nextWord = scanner.nextLine();
                data.add(nextWord);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getCause());
        }
        return data;
    }

    public void saveData(String data) {


    }
}
