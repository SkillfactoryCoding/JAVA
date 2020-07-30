import java.util.ArrayList;

public class PhoneBookNote {
    private String userName;
    private ArrayList<String> usersPhoneNumbers;

    public PhoneBookNote(String userName, ArrayList<String> usersPhoneNumbers) {
        this.userName = userName;
        this.usersPhoneNumbers = usersPhoneNumbers;
    }

    public boolean isNumberInList(String number){
        for (String phoneNumber : this.usersPhoneNumbers) {
            if (phoneNumber.equals(number)){
                return true;
            }
        }
        return false;
    }

    public void addNumber(String number) {
        if (!usersPhoneNumbers.contains(number)) {
            usersPhoneNumbers.add(number);
        }
    }

    public void printNote() {
        System.out.println(userName + ": ");
        for (String phone : usersPhoneNumbers) {
            System.out.println("\t" + phone + ";");
        }
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<String> getUsersPhoneNumbers() {
        return usersPhoneNumbers;
    }
}
