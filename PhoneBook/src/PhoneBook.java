import java.util.ArrayList;
import java.util.Collections;

public class PhoneBook {

    private ArrayList<PhoneBookNote> phoneBookNotes;

    public PhoneBook() {
        this.phoneBookNotes = new ArrayList<>();
    }

    public boolean isPhoneNumberInBook(String phoneNumber) {
        boolean phoneNumberInList = false;
        for (PhoneBookNote book : this.phoneBookNotes) {
            if (book.isNumberInList(phoneNumber)) {
                phoneNumberInList = true;
            }
        }
        return phoneNumberInList;
    }

    private boolean isNameInBook(String name) {
        boolean nameInPhoneBook = false;
        for (PhoneBookNote note : phoneBookNotes) {
            if (note.getUserName().equals(name)) {
                nameInPhoneBook = true;
                break;
            }
        }
        return nameInPhoneBook;
    }

    private PhoneBookNote getPhoneBookNoteByName(String name) {
        PhoneBookNote phoneBookNoteWithFindingName = null;
        for (PhoneBookNote phoneBookNote : this.phoneBookNotes) {
            if (phoneBookNote.getUserName().equals(name)) {
                phoneBookNoteWithFindingName = phoneBookNote;
            }
        }
        return phoneBookNoteWithFindingName;
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
        PhoneBookNote phoneBookNoteWithFindingNumber = null;
        for (PhoneBookNote note : this.phoneBookNotes) {
            if (note.isNumberInList(number)) {
                phoneBookNoteWithFindingNumber = note;
            }
        }
        return phoneBookNoteWithFindingNumber;
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
        this.phoneBookNotes.sort(new UserNameCompare());
        for (PhoneBookNote note : this.phoneBookNotes) {
            note.printNote();
        }
    }


    public static void run(PhoneBook book) {
        boolean isContinue = true;
        String choiceToContinue;
        do {
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
            System.out.println("Do you want continue session?");
            choiceToContinue = ConsoleReader.yesNoReader();
            if (choiceToContinue.equals("n")) {
                isContinue = false;
            }
        } while (isContinue);
        System.out.println("Program was finished");
    }
}
