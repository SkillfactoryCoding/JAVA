public interface Staff {

    public void helpStudentInTask(Student student);
    default void giveAdditionalTask(){
        System.out.println("ссылка на дополнительное задание: https://github.com/Zavalishchev/JAVA");
    }

}
