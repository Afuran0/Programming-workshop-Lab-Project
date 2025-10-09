import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\article1.txt";

        Processor p1 = new Processor(filename);

        // Print processed article
        System.out.println("Processed article (stopwords removed):");
        p1.printArticle();

        // Calculate and display statistics
        Statistics stats = new Statistics(p1.getArticleWords());
        stats.printStats();
    }
}
