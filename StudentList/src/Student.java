public class Student extends Person {

    public static int tasksSum;

    public int solvedTasks;
    public Mentor mentor;
    public boolean allTasksSolved = false;

    public Student(String name, int age, Mentor mentor) {
        super(name, age);
        this.mentor = mentor;
        this.solvedTasks = 0;
    }

    public int getSolvedTasks() {
        return solvedTasks;
    }

    public void setSolvedTasks(int solvedTasks) {
        this.solvedTasks = solvedTasks;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public boolean isAreAllTasksDone() {
        return allTasksSolved;
    }

    public void solveTasks(Task[] tasks, int tasksToSolve) {
        // solvedTasks = 2
        // tasksToSolve = 2
        // [0] [1] [2] [3] [4] [5]
        System.out.println("[" + getName() + "] already solved [" + solvedTasks + "] and [" + tasksToSolve + "] new tasks to solve");
        for (int i = solvedTasks; i < solvedTasks + tasksToSolve; i++) {

            solveTask(tasks[i]);
            if (solvedTasks >= tasks.length) {
                allTasksSolved = true;
                System.out.println("[" + getName() + "] solved all tasks!");
                return;
            } else {
                allTasksSolved = false;
            }
        }

    }

    private void solveTask(Task task) {
        if (task instanceof AutoChecked) {
            ((AutoChecked) task).checkAutomatically();
        } else {
            while (!mentor.checkCode(task)) {
            }
        }
        solvedTasks++;
        tasksSum++;
    }
}