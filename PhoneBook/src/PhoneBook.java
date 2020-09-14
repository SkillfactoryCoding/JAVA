import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        int i = 0;
        String[][] book = new String[20][2];
        while (true) {
            String name = "";
            boolean mark = true;
            String number = "";
            System.out.println("Введите ФИО");
            Scanner scanner = new Scanner(System.in);
            boolean isCorrectName = false;
            while (!isCorrectName) {
                name = scanner.nextLine(); //Считывает строку из System.in
                isCorrectName = checkName(name);
                if (!isCorrectName) {
                    System.out.println("Введите корректное ФИО!");
                } else {
                    name = formatName(name);
                }
            }



    public static boolean checkPhoneNumber(String phoneNumber) {
        return true;
    }

    public static boolean checkName(String name) {
        return true;
    }

    public static String formatName(String name) {
        return "";
    }

    public static String formatPhoneNumber(String number) {
        return "";
    }

    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
        //print phone book
    }
}
