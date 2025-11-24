import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TestCode {
    public static void main(String[] args) throws IOException {
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
            printWriter.write(firstName);
            lastName = SafeInput.getNonZeroLenString(pipe, "Your last name: ");
            printWriter.write(lastName);
            idNumber = SafeInput.getRegExString(pipe, "Enter your ID number: ", "[1-9]");
            idNumber = 0 + idNumber;
            idNumber = 0 + idNumber;
            idNumber = 0 + idNumber;
            idNumber = 0 + idNumber;
            idNumber = 0 + idNumber;
            printWriter.write(idNumber);
            eMail = SafeInput.getRegExString(pipe, "Enter your e-mail: ", "[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\.]+");
            printWriter.write(eMail);
            yearOfBirth = SafeInput.getRegExString(pipe, "Enter your year of birth: ", "^\\d{4}$");
            printWriter.write(yearOfBirth);
            printWriter.close();
            timesGoneThrough++;
            done = SafeInput.getYNConfirm(pipe, "Are you done?");
        } while (!done);
    }
}
