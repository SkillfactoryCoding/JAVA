import java.util.Random;

public class Student extends Person{

    private int countTasks = 0;
    public static int countAllTasks;

    private Mentor mentor;

    private boolean completist;


    public Student(String name, int age, Mentor mentor, boolean completist) {
        super(name, age);
        this.mentor = mentor;
        this.completist = completist;
    }

    public int getCountTasks() {
        return countTasks;
    }

    public void setCountTasks(int countTasks) {
        this.countTasks = countTasks;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public boolean isCompletist() {
        return completist;
    }

    public void setCompletist(boolean completist) {
        this.completist = completist;
    }

    public void allTasksSolve(int count, Task[] tasks) {

        for (int i = 0; i < count ; i++) {

            taskSolve(tasks[getCountTasks()]);
            if (getCountTasks() == tasks.length) {
                System.out.println("All tasks completed");
                setCompletist(true);
                return;
            }
        }
        System.out.println("Not all tasks completed");
        setCompletist(false);
    }

    private void taskSolve(Task task) {

        while (!mentor.checkCode(task));

        setCountTasks(getCountTasks() + 1);
        countAllTasks++;

    }

    public static void main(String[] args) {
        Task[] task = new Task[120];
        for (int i = 0; i < task.length; i++) {

            switch ( i % 3) {
                case 0:
                    task[i] = new Code();
                    break;
                case 1:
                    task[i] = new DragAndDrop();
                    break;
                case 2:
                    task[i] = new Test();
                    break;
            }
        }

        Mentor mentor1 = new Mentor("Oleg", 44);
        Mentor mentor2 = new Mentor("Ilia", 55);

        Student[] students = {new Student("Ivan", 22, mentor1, false), new Student("Liza", 23, mentor2, false)};

        while (countAllTasks != task.length * 2) {
            for (Student student: students) {
                Random random = new Random();
                while (!student.isCompletist()) {
                    student.allTasksSolve(random.nextInt(task.length), task);
                }
            }
        }

    }
}
