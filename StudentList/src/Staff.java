public interface Staff {

    void helpStudent(Student student);

    default void addMaterials() {
        System.out.println("https://habr.com/ru/all/");
    }
}
