import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;

public class Untested {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> lines = new ArrayList<>();

        final int FIELDS_LENGTH = 5;

        String id, firstName, lastName, title;
        int yob;

        try {

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


















        ArrayList<String>listItems = new ArrayList<>();
        listItems.add("Sample data for our file writing example.");
        listItems.add("Sample data Line 2.");
        listItems.add("Sample data Line 3.");
        listItems.add("Sample data Line 4.");
        listItems.add("Sample data Line 5.");

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String listItem : listItems) {
                writer.write(listItem, 0, listItem.length());
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

