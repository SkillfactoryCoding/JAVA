import java.util.ArrayList;
import java.util.Collections;

public class PhoneBook {

    private ArrayList<PhoneBookNote> phoneBookNotes;

    public PhoneBook() {
        this.phoneBookNotes = new ArrayList<>();
    }

    public boolean isPhoneNumberInBook(String phoneNumber) {
        for (PhoneBookNote book : this.phoneBookNotes) {
            if (book.isNumberInList(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNameInBook(String name) {
        for (PhoneBookNote note : phoneBookNotes) {
            if (note.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private PhoneBookNote getPhoneBookNoteByName(String name) {
        for (PhoneBookNote phoneBookNote : this.phoneBookNotes) {
            if (phoneBookNote.getUserName().equals(name)) {
                return phoneBookNote;
            }
        }
        return null;
    }

    public void addNumberByName(String name, String number) {
        if (this.isNameInBook(name)) {
            if (!this.getPhoneBookNoteByName(name).isNumberInList(number)) {
                this.getPhoneBookNoteByName(name).addNumber(number);
            } else {
                System.out.println("Number in list.");
            }
        } else {
            System.out.println("User`s name not found.");
        }
    }

    public void addUserByNumber(String number) {
        String name = ConsoleReader.nameReader();
        if (!this.isNameInBook(name)) {
            PhoneBookNote phoneBookNote = new PhoneBookNote(name, new ArrayList<>());
            phoneBookNote.addNumber(number);
            this.phoneBookNotes.add(phoneBookNote);
        } else {
            System.out.println("Such name is already exist. Number add to this name.");
            this.addNumberByName(name, number);
        }
    }

    private PhoneBookNote getPhoneBookNoteByNumber(String number) {
        for (PhoneBookNote note : this.phoneBookNotes) {
            if (note.isNumberInList(number)) {
                return note;
            }
        }
        return null;
    }

    public void add(String name, String number) {
        PhoneBookNote phoneBookNote = new PhoneBookNote(name, new ArrayList<>());
        phoneBookNote.addNumber(number);
        phoneBookNotes.add(phoneBookNote);
    }

    public void printPhoneBookNotes() {
        for (PhoneBookNote note : this.phoneBookNotes) {
            note.printNote();
        }
    }

    public void printPhoneBookNotesSortedByName() {
        Collections.sort(this.phoneBookNotes, new UserNameCompare());
        for (PhoneBookNote note : this.phoneBookNotes) {
            note.printNote();
        }
    }


    public static void run(PhoneBook book) {
        while (true) {
            System.out.println("Find note by name?");
            String choice = ConsoleReader.yesNoReader();
            if (choice.equals("y")) {
                String name = ConsoleReader.nameReader();
                if (book.isNameInBook(name)) {
                    book.getPhoneBookNoteByName(name).printNote();
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
        }
    }
}
