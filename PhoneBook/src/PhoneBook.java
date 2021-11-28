import java.util.*;

public class PhoneBook {

    private HashMap<String, HashSet<String>> contacts;

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    private boolean containsName(String name){
        boolean nameInBook = false;
        if (this.contacts.containsKey(name)){
            nameInBook = true;
        }
        return nameInBook;
    }

    private boolean containsNumber(String number){
        boolean numberInBook = false;
        for (String name : this.contacts.keySet()) {
            if (this.contacts.get(name).contains(number)){
                numberInBook = true;
            }
        }
        return numberInBook;
    }

    private HashSet<String> findContactByName(String name){
        HashSet<String> numbers = null;
        if (this.containsName(name)){
            numbers = this.contacts.get(name);
        }
        return numbers;
    }

    private String findContactByNumber(String number) {
        String findName = null;
        for (String name : this.contacts.keySet()) {
            if (this.contacts.get(name).contains(number)){
                findName = name;
            }
        }
        return findName;
    }

    private void printOneContact(String name, HashSet<String> numbers){
        System.out.println(name + ":");
        for (String number : numbers) {
            System.out.println("\t" + number);
        }
    }

    private void add(String name, String number) {
        if (this.containsName(name)){
            HashSet<String> numbers = this.findContactByName(name);
            numbers.add(number);
        } else {
            HashSet<String> numbers = new HashSet<>();
            numbers.add(number);
            this.contacts.put(name, numbers);
        }
    }

    public static void run(PhoneBook book){
        boolean isContinue = true;
        String choiceToContinue;
        do {
            System.out.println("Find note by name?");
            String choice = ConsoleReader.askYesNo();
            if (choice.equals("y")) {
                String name = ConsoleReader.askName();
                HashSet<String> numbers = book.findContactByName(name);
                if (numbers != null){
                    book.printOneContact(name, numbers);
                } else {
                    System.out.println("Name not found.");
                    String number = ConsoleReader.askNumber();
                    if (book.containsNumber(number)){
                        System.out.println("Number was found.");
                        String foundName = book.findContactByNumber(number);
                        book.printOneContact(foundName, book.findContactByName(foundName));
                    } else {
                      book.add(name, number);
                    }
                }
            } else {
                System.out.println("Finding note by number.");
                String number = ConsoleReader.askNumber();
                if (book.containsNumber(number)) {
                    String name = book.findContactByNumber(number);
                    HashSet<String> numbers = new HashSet<>();
                    numbers.add(number);
                    book.printOneContact(name, numbers);
                } else {
                    System.out.println("Number not found. Adding by number.");
                    String name = ConsoleReader.askName();
                    book.add(name, number);
                }
            }

            System.out.println("unsorted list");
            book.printContacts();
            System.out.println("\nSorted list");
            book.printAllBookSortedByName();
            
            System.out.println("Do you want continue session?");
            choiceToContinue = ConsoleReader.askYesNo();
            if (choiceToContinue.equals("n")) {
                isContinue = false;
            }
        } while (isContinue);
        System.out.println("Program was finished");
    }

    private void printAllBookSortedByName() {
        List<String> nameListForSort = new ArrayList<>(this.contacts.keySet());
        Collections.sort(nameListForSort);
        for (String name : nameListForSort) {
            this.printOneContact(name, this.contacts.get(name));
        }
    }

    private void printContacts() {
        for (String name : this.contacts.keySet()) {
            this.printOneContact(name, this.contacts.get(name));
        }
    }








    /*public static void run(PhoneBook book) {
        boolean isContinue = true;
        String choiceToContinue;
        do {
            System.out.println("Find note by name?");
            String choice = ConsoleReader.yesNoReader();
            if (choice.equals("y")) {
                String name = ConsoleReader.nameReader();
                if (book.isNameInBook(name)) {
                    book.printNote(name);
                } else {
                    System.out.println("Name not found.");
                    String number = ConsoleReader.numberReader();
                    if (!book.isPhoneNumberInBook(number)) {
                        book.add(name, number);
                    } else {
                        System.out.println("Number was found.");
                        book.getPhoneBookNoteByNumber(number).printNote();
                    }
                }
            } else {
                System.out.println("Finding note by number.");
                String number = ConsoleReader.numberReader();
                if (book.isPhoneNumberInBook(number)) {
                    book.getPhoneBookNoteByNumber(number).printNote();
                } else {
                    System.out.println("Number not found. Adding by number.");
                    book.addUserByNumber(number);
                }
            }
            System.out.println("unsorted list");
            book.printPhoneBookNotes();
            System.out.println("\nSorted list");
            book.printPhoneBookNotesSortedByName();
            System.out.println("Do you want continue session?");
            choiceToContinue = ConsoleReader.yesNoReader();
            if (choiceToContinue.equals("n")) {
                isContinue = false;
            }
        } while (isContinue);
        System.out.println("Program was finished");
    }*/
}
