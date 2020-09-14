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

        public static boolean checkPhoneNumber (String phoneNumber){
            return true;
        }

        public static boolean checkName (String name){
            return true;
        }

        public static String formatName (String name){
            return "";
        }

        public static String formatPhoneNumber (String number){
            return "";
        }

        public static void add (String[][]book, String name, String number){
            //add logic
        }

        public static void list (String[][]book){
            //print phone book
        }
    }
