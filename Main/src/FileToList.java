import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//class that takes a filepath as an input and converts it into a word by word arraylist to be used in the processor

public class FileToList {

    public ArrayList<String> readFileToList(String path) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        File text = new File(path);
        Scanner sc = new Scanner(text);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            //removes punctuation and then splits each line into separate words
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
