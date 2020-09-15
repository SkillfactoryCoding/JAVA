import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Task[] tasks = generateTasks();

        Mentor firstMentor = new Mentor("Egor", 35);
        Mentor secondMentor = new Mentor("Igor", 40);

        Student[] students = new Student[4];

        students[0] = new Student("Antonio", 89, firstMentor);
        students[1] = new Student("Andrey", 35, secondMentor);
        students[2] = new Student("Eugene", 30, secondMentor);
        students[3] = new Student("Viktor", 30, firstMentor);

        while (!doesNotEachStudentSolveAllTasks(students)) {
            /*for (int i = 0; i < students.length - 1; i++) {
                Student students = students[i];
            }*/
            for (Student student : students) {
                int tasksToSolve = randomInt(5, tasks.length - 1);
                student.solveTasks(tasks, tasksToSolve);
            }
        }
    }

    private static boolean doesNotEachStudentSolveAllTasks(Student[] students) {
        boolean done = true;
        for (Student student : students) {
            boolean d = student.isAreAllTasksDone();
            done &= d;
        }
        return done;

    }

    private static Task[] generateTasks() {
        Task[] tasks = new Task[31];
        for (int i = 0; i < 7; i++) {
            Task t = new Test(i + 1, "Test Task " + (i + 1) + "text");
            tasks[i] = t;
        }
        for (int i = 7; i < 18; i++) {
            Task t = new DragAndDrop(i + 1, "DragAndDrop Task" + (i + 1) + "text");
            tasks[i] = t;
        }
        for (int i = 18; i < 31; i++) {
            Task t = new WriteCode(i + 1, "Write Code Task " + (i + 1) + " text");
            tasks[i] = t;
        }
        return tasks;
    }

    public static int randomInt(int min, int max) {
        Random random = new Random();
        int diff = max - min;
        int result = random.nextInt(diff + 1);
        result += min;
        return result;
    }
}
