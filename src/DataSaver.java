import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        boolean done = false;

        ArrayList<String> dataList = new ArrayList<>();
        do {
            String firstName = SafeInput.getNonZeroLenString(pipe, "Your first name: ");
            dataList.add(firstName);
            String lastName = SafeInput.getNonZeroLenString(pipe, "Your last name: ");
            dataList.add(lastName);
            String idNumber = SafeInput.getRegExString(pipe, "Enter your ID number: ", "[1-9]");
            idNumber = 0 + idNumber;
            idNumber = 0 + idNumber;
            idNumber = 0 + idNumber;
            idNumber = 0 + idNumber;
            idNumber = 0 + idNumber;
            String.valueOf(idNumber);
            dataList.add(idNumber);
            String eMail = SafeInput.getRegExString(pipe, "Enter your e-mail: ", "[a-zA-Z0-9\\.]+@[a-zA-Z0-9\\.]+");
            dataList.add(eMail);
            String yearOfBirth = SafeInput.getRegExString(pipe, "Enter your year of birth: ", "^\\d{4}$");
            dataList.add(yearOfBirth);

            for (int num = 0; num < dataList.size(); num++) {
                System.out.println(dataList.get(num));
            }





            done = SafeInput.getYNConfirm(pipe, "Are you done?");
        } while (!done);
    }
}