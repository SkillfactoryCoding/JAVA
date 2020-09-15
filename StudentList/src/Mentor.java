import java.util.Random;

public class Mentor extends Person implements Staff {
    public boolean mentorMood;
//    private static final Random a;
    public Mentor(String name, int age) {
        super(name, age);
        this.mentorMood = true;

    }

    public boolean checkCode(Task code) {

        //Random используется для генерации случайных чисел
        Random random = new Random();
        int i = random.nextInt(10000);
        if (i <= 1000) {
            System.out.println("Task " + code.number + " are not done.");
            return false;
        } else {
            System.out.println("Task " + code.number + " are done.");
            return true;
        }

    }

    public void helpStudent(Student student) {
        System.out.println("Yahoo, " + student.getName() + ", you are best!");
    }
}
