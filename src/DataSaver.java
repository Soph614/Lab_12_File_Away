import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class DataSaver {
    public static void main(String[] args) throws IOException {
        final int FIELDS_LENGTH = 5;
        String firstName, lastName, idNumber, eMail, yearOfBirth;
        File file1 = new File("userData.txt");
        FileWriter fileWriter = new FileWriter(file1);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        Scanner pipe = new Scanner(System.in);
        boolean done = false;
        ArrayList<String> dataList = new ArrayList<>();
        int timesGoneThrough = 0;
        do {
            firstName = SafeInput.getNonZeroLenString(pipe, "Your first name: ");
            printWriter.write(firstName + ", ");
            lastName = SafeInput.getNonZeroLenString(pipe, "Your last name: ");
            printWriter.write(lastName + ", ");
            idNumber = SafeInput.getRegExString(pipe, "Enter your ID number: ", "[1-9]");
            idNumber = 0 + idNumber;
            idNumber = 0 + idNumber;
            idNumber = 0 + idNumber;
            idNumber = 0 + idNumber;
            idNumber = 0 + idNumber;
            printWriter.write(idNumber + ", ");
            eMail = SafeInput.getRegExString(pipe, "Enter your e-mail: ", "[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\.]+");
            printWriter.write(eMail + ", ");
            yearOfBirth = SafeInput.getRegExString(pipe, "Enter your year of birth: ", "^\\d{4}$");
            printWriter.write(yearOfBirth);
            printWriter.println();
            timesGoneThrough++;
            done = SafeInput.getYNConfirm(pipe, "Are you done?");
        } while (!done);
        printWriter.close();
        Path file = file1.toPath();

        InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        ArrayList<String> lines = new ArrayList<>();
        int line = 0;
        String rec = "";
        while(reader.ready()) {
            rec = reader.readLine();
            lines.add(rec);
            line++;
            System.out.printf("\nLine %4d %-60s ", line, rec);
        }
        reader.close();
        System.out.println("\n\nData file read!");

        String[] fields;
        String display1 = "FIRST";
        String display2 = "LAST";
        String display3 = "ID_NUM";
        String display4 = "E-MAIL";
        String display5 = "YOB";
        System.out.printf("\n%-25s%-25s%-8s%-20s%6s", display1, display2, display3, display4, display5);
        for(String l : lines) {
            fields = l.split(",");
            if(fields.length == FIELDS_LENGTH) {
                idNumber    = fields[0].trim();
                firstName   = fields[1].trim();
                lastName    = fields[2].trim();
                eMail       = fields[3].trim();
                yearOfBirth = fields[4].trim();
                System.out.printf("\n%-25s%-25s%-8s%-20s%6s", idNumber, firstName, lastName, eMail, yearOfBirth);
            }
            else {
                System.out.println("Found a record that may be corrupt: ");
                System.out.println(1);
            }
        }
    }
}
