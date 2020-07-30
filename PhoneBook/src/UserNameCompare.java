import java.util.Comparator;

public class UserNameCompare implements Comparator<PhoneBookNote> {
    @Override
    public int compare(PhoneBookNote phoneBookNote1, PhoneBookNote phoneBookNote2) {
        return phoneBookNote1.getUserName().compareTo(phoneBookNote2.getUserName());
    }
}
