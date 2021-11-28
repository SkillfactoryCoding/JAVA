import java.util.Scanner;

public class ConsoleReader {

    private static Scanner scanner = new Scanner(System.in);

    public static String askYesNo() {
        System.out.println("Enter y/n: ");
        boolean isCorrected = false;
        String choice;
        do {
            choice = scanner.nextLine();
            if (choice.equals("y") || choice.equals("n")) {
                isCorrected = true;
            } else {
                System.out.println("Error: incorrect character. Try again.");
            }
        } while (!isCorrected);
        return choice;
    }

    public static String askName() {
        System.out.println("Enter user`s name: ");
        StringBuilder name = new StringBuilder();
        do {
            if (name.length() > 1) {
                name.delete(0, name.length() - 1);
            }
            name.append(formatName(scanner.nextLine()));
            if (name.toString().equals("")) {
                System.out.println("Name is incorrect. Try again.");
            }
        } while (name.toString().equals(""));
        return name.toString();
    }

    private static String formatName(String name) {
        if (name.split(" ").length != 3) {
            name = "";
            System.out.println("Name is incorrect.");
        }
        return name;
    }

    public static String askNumber() {
        System.out.println("Enter user`s number: ");
        StringBuilder number = new StringBuilder();
        do {
            if (number.length() > 0) {
                number.delete(0, number.length() - 1);
            }
            number.append(formatNumber(scanner.nextLine()));
            if (number.toString().equals("")) {
                System.out.println("Number is incorrect. Try again.");
            }
        } while (number.toString().equals(""));
        return number.toString();
    }

    private static String formatNumber(String number) {
        StringBuilder formattedNumber = new StringBuilder();
        formattedNumber.append(number.replaceAll("[^0-9]", ""));
        if (formattedNumber.length() == 11) {
            formattedNumber.insert(9, " ")
                    .insert(7, " ")
                    .insert(4, " ")
                    .insert(1, " ")
                    .insert(0, "+")
                    .replace(1, 2, "7");
        } else {
            System.out.println("Number is incorrect.");
            if (formattedNumber.length() > 0) {
                formattedNumber.delete(0, formattedNumber.length() - 1);
            }
        }
        return formattedNumber.toString();
    }
}


/*
* removed duplicated return statement;
change while -> do{} while() where first iteration always must be done
change switch -> if in yesNoReader
add break point in cycle in run method
* */