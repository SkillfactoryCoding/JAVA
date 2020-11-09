import java.util.Random;

public class Mentor extends Person implements Staff {
    public boolean mood;
    Random random;

    public Mentor() {
        this.mood = true;
    }

    public boolean checkTask(Task task) {
        random = new Random();
        int tempNum = random.nextInt(2000);

        if(tempNum > 1000) {
            mood = false;
            System.out.println("задание № " + task.taskNum + " не принято");
            return false;
        } else {
            System.out.println("задание № " + task.taskNum + " принято");
            return true;
        }
    }

    public void studentHelp(Student student) {
        System.out.println(student.getName() + " у тебя всё получится!");
    }

    @Override
    public void helpStudentInTask(Student student) {

    }

    @Override
    public void giveAdditionalTask() {

    }
}
