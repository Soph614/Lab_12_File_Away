import java.io.*;
import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String counter = "";
        ArrayList<String> lines = new ArrayList<>();
        String[] numberOfWords;
        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream inStream = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
                int lineCount = 0;
                int words = 0;
                int numberOfCharacters = 0;
                while (reader.ready()) {
                    counter = reader.readLine().trim();
                    lines.add(counter);
                    lineCount++;
                    System.out.printf("\nLine %4d %-60s ", lineCount, counter);
                    numberOfWords = counter.split(" ");
                    words += numberOfWords.length;

                    for(String word: numberOfWords) {
                        numberOfCharacters = numberOfCharacters + word.length();
                    }
                }
                reader.close();
                String[] characters = new String[0];
                for (String c : characters) {
                    characters = c.split("");
                    numberOfCharacters += characters.length;
                }

                System.out.println("\nThe file you selected is" + selectedFile);
                System.out.println("There are " + lineCount + " lines in the file.");
                System.out.println("There are " + words + " words in the file.");
                System.out.println("There are " + numberOfCharacters + " characters in the file.");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
