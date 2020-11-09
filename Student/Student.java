import java.util.Objects;

public class Student extends Person implements Autochecked {

    public int groupNum;
    public int taskCount;
    public static int taskCountForAll;
    Mentor mentor;
    public boolean solvedAllTasks;
    public static final int MAX_TASK_COUNT = 10;
    public static final int MAX_MODLE_COUNT = 20;

    public Student() {
        super();
    }

    public Student(String name, String surname, int age, int groupNum) {
        super(name, surname, age);
        this.groupNum = groupNum;
    }

    public int getGroupNum() {
        return groupNum;
    }
    public void setGroupNum(int groupNum) {
        this.groupNum = groupNum;
    }
    public int getTaskCount() {
        return taskCount;
    }
    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }
    public static int getTaskCountForAll() {
        return taskCountForAll;
    }

    public void solveTasks(int taskCount, Task[] arrTasks) {
        solveOneTask(arrTasks[taskCount]);
    }

    private void solveOneTask(Task oneTask) {
        checkAutomatically();

        while(mentor.checkTask(oneTask)) {
            mentor.checkTask(oneTask);
        }
        taskCount++;
        taskCountForAll++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", groupNum=" + groupNum +
                ", taskCount=" + taskCount +
                '}';
    }
}
