import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

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

    //takes score files and turns it into a hashmap
    public HashMap<String, Double> readFileToHashMap(String path) throws IOException {
        HashMap<String, Double> list = new HashMap<>();

        File text = new File(path);
        try (Scanner sc = new Scanner(text)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;            // skip blanks

                // Split on any whitespace (tabs or spaces)
                String[] parts = line.split("\\s+");
                if (parts.length < 2) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                String key = parts[0].toLowerCase();
                String rawNumber = parts[1];             // e.g., "-1.9"

                try {
                    double value = Double.parseDouble(rawNumber);
                    list.put(key, value);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number on line: " + line);
                }
            }
        }

        return list;
    }

}
