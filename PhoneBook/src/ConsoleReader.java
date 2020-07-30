import java.util.Scanner;

public class ConsoleReader {

    public static String yesNoReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter y/n: ");
        boolean correctChoice = false;
        String choice = scanner.nextLine();
        while (!correctChoice) {
            switch (choice) {
                case "y":
                case "n":
                    correctChoice = true;
                    break;
                default:
                    System.out.println("Error: incorrect character. Try again.");
                    System.out.println("Enter y/n: ");
                    choice = scanner.nextLine();
            }
        }
        return choice;
    }

    public static String nameReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user`s name: ");
        String name = formatName(scanner.nextLine());
        while (name == null) {
            System.out.println("Name is incorrect. Try again.");
            System.out.println("Enter user`s name: ");
            name = formatName(scanner.nextLine());
        }
        return name;
    }

    private static String formatName(String name) {
        if (name.split(" ").length == 3) {
            return name;
        }
        System.out.println("Name is incorrect.");
        return null;
    }

    public static String numberReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user`s number: ");
        String number = formatNumber(scanner.nextLine());
        while (number == null) {
            System.out.println("Number is incorrect. Try again.");
            System.out.println("Enter user`s number: ");
            number = formatNumber(scanner.nextLine());
        }
        return number;
    }

    private static String formatNumber(String number) {
        StringBuffer formattedNumber = new StringBuffer();
        formattedNumber.append(number.replaceAll("[^0-9]", ""));
        if (formattedNumber.length() == 11) {
            formattedNumber.insert(9, " ")
                    .insert(7, " ")
                    .insert(4, " ")
                    .insert(1, " ")
                    .insert(0, "+")
                    .replace(1, 2, "7");
            return formattedNumber.toString();
        }
        System.out.println("Number is incorrect.");
        return null;
    }
}
