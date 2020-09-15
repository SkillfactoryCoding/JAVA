import java.util.Random;

public class Mentor extends Person implements Staff {

    private boolean mood; // ?
    private Random random = new Random(); // ?

    public Mentor(String name, int age) {
        super(name, age);
        this.mood = true;
    }

    @Override
    public void helpStudent(Student student) {
        System.out.println(student.getName() + ", не унывай, все получится");
    }

    public boolean checkCode(Task task) {
        int number = Main.randomInt(0, 2000);
        if (number > 1000) {
            mood = true;
            System.out.println("[" + task.getTask() + "] was checked by [" + getName() + "]") ;
            return true;
        }
        mood = false;
        System.out.println("[" + task.getTask() + "] was not checked by [" + getName() + "]");
        return false;
    }
}

