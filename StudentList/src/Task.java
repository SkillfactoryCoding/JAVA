abstract class Task {

    private int number;
    private String task;

    public Task(int number, String task) {
        this.number = number;
        this.task = task;
    }

    public int getNumber() {
        return number;
    }

    public String getTask() {
        return task;
    }
}

