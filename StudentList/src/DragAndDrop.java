class DragAndDrop extends Task implements AutoChecked {

    private String[][] var;

    public DragAndDrop(int numberOfTask, String task) {
        super(numberOfTask, task);

        // String [] s = new String[2];
        // [0] [1]
        // String [][] ss = new String[2][3];
        // [[0] [1] [2]] [[0] [1] [2]]

        this.var = new String[2][2];
        var[0][0] = "вариант1";
        var[0][1] = "вариант2";
        var[1][0] = "вариант3";
        var[1][1] = "вариант4";
    }
}
