import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileToList {

    // Reads a file and returns an ArrayList of lowercase words and punctuation
    public ArrayList<String> readFileToList(String path) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        File text = new File(path);
        Scanner scan = new Scanner(text);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            line = line.replaceAll("[^a-zA-Z0-9\\s]", ""); // remove punctuation
            String[] words = line.split("\\s+"); // split by spaces
            for (String word : words) {
                if (!word.isEmpty()) {
                    list.add(word.toLowerCase());
                }
            }
        }

        scan.close();
        return list;
    }
}
