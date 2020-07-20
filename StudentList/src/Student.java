import java.util.UUID;

public class Student {

    /**
     * id студента
     */
    private String id;

    /**
     * Имя студента
     */
    private String name;

    /**
     * Телефон студента
     */
    private String phone;

    /**
     * Почта студента
     */
    private String eMail;

    public Student(String name, String phone, String eMail) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phone = phone;
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
