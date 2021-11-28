public interface Autochecked {

    default void checkAutomatically() {
        System.out.println("Задача выполнена");
    }
}
