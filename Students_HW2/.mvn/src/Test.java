class Test extends Task implements AutoChecked {

    String[] answer;

    public Test(int numberOfTask, String task) {
        super(numberOfTask, task);
        this.answer = new String[]{"a", "b", "c"};
    }
}
