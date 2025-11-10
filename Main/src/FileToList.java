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
    //this is more directed towards the specific lexicon file for values
    public HashMap<String, Double> readFileToHashMap(String path) throws IOException {
        HashMap<String, Double> map = new HashMap<>();
        File file = new File(path);

        //
        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) continue;

                //splits on white spaces
                String[] parts = line.split("\\s+");


                // first word of each line turned to lowercase and saved as key, then takes the value and saves it as a string
                //the string value is then turned into a double and both the key and value is added
                String key = parts[0].toLowerCase().replace("\uFEFF", "");
                String valueStr = parts[parts.length - 1];
                double value = Double.parseDouble(valueStr);
                map.put(key, value);

            }
        }
        return map;
    }
}
