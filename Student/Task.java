public abstract class Task {
    public int taskNum;
    public String taskDiscription;
    public Task() {
        this.taskNum = 0;
        this.taskDiscription = "бла бла бла";
    }
    abstract void Test();
    abstract void DragAndDrop();
    abstract void Code();
}
