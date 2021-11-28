public class Kurator extends Person implements Staff {

    public void giveTheAnswer() {
        System.out.println("Куратор: ответ на вопрос...");
    }

    public void giveNewInfo() {
        System.out.println("Куратор: а вы знали что...");
    }

    @Override
    public void helpStudentInTask(Student student) {

    }

    @Override
    public void giveAdditionalTask() {

    }
}
