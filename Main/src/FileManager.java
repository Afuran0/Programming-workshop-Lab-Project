import java.io.IOException;
import java.nio.file.*;
public class FileManager {
     public static void AddFile(String filename, String foldername) {

         Path sourcePath = Paths.get(filename);

         // Target directory path
         Path targetDirectory = Paths.get(foldername);

         // Ensure the target directory exists
         try {
             if (!Files.exists(targetDirectory)) {
                 Files.createDirectories(targetDirectory); // create the folder
             }

             // Move the file
             Files.move(sourcePath, targetDirectory.resolve(sourcePath.getFileName()));
             System.out.println("File moved successfully!");
         } catch (IOException e) {
             System.err.println("An error occurred while moving the file: " + e.getMessage());
         }
    }
}
