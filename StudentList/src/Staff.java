public interface Staff {
    void helpStudent(Student student);
    default void provideAdditionalMaterials() {
        System.out.println("See Hrabr");
    }
}
