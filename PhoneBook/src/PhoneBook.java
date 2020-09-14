import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        public static void main (String[]args){
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

                for (int r = 0; r < book.length; r++) {
                    if (name.equals(book[r][0])) {
                        System.out.println(book[r][0] + ":" + " " + book[r][1]);
                        mark = false;
                        break;
                    }
                }
                while (mark) {
                    number = printPhoneNumber(number);
                    book = add(book, name, number, i);
                    i++;
                    mark = false;
                }
            }
        }

        public static String printPhoneNumber (String number){
            System.out.println("Введите номер");
            Scanner scanner = new Scanner(System.in);
            boolean isCorrectNumber = false;
            while (!isCorrectNumber) {
                number = scanner.nextLine(); //Считывает строку из System.in
                isCorrectNumber = checkPhoneNumber(number);
                if (!isCorrectNumber) {
                    System.out.println("Введите корректный номер!");
                } else {
                    number = formatPhoneNumber(number);
                }
            }
            return number;
        }

        public static boolean checkPhoneNumber (String number){
            String check = number.replaceAll("[^0-9]", "");
            return check.length() == 11;

        }

        public static boolean checkName(String name) {
            String[] check = name.split(" ");
            return check.length == 3;

        }

        public static String formatName(String name) {
            String[] format = name.split(" ");
            return (format[0].substring(0, 1).toUpperCase() + format[0].substring(1) + " " + format[1].substring(0, 1).toUpperCase()
                    + format[1].substring(1) + " " + format[2].substring(0, 1).toUpperCase() + format[2].substring(1));


        }

        public static String formatPhoneNumber(String number) {
            String format = number.replaceAll("[^0-9]", "");

            return ("+7" + " " + format.substring(1, 4) + " " + format.substring(4, 7) + " " + format.substring(7, 9) + " " + format.substring(9));
        }

        public static void add (String[][]book, String name, String number){
            //add logic
        }

        public static void list (String[][]book){
            //print phone book
        }
    }
