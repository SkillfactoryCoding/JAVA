public interface AutoChecked {

    default void checkAutomatically() {
        System.out.println("Задание без проверки метором");
    }
}
