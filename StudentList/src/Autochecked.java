public interface Autochecked {
    default void doTask() {
        System.out.println("Task done.");
    }
}
