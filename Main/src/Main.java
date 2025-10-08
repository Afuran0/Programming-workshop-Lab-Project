import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        String filename = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\article1.txt";

        Processor p1 = new Processor(filename);
        p1.printArticle();
    }
}