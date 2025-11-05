import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Reads a text file and returns its words in a list
public class FileToList {

    public ArrayList<String> readFileToList(String path) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        File text = new File(path);
        Scanner sc = new Scanner(text);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            // Remove punctuation and split into words
            line = line.replaceAll("[^a-zA-Z0-9\\s]", "");
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    list.add(word.toLowerCase());
                }
            }
        }

        sc.close();
        return list;
    }
}
