public class DragAndDrop extends Task implements Autochecked {
    public String[][] variants;

    public DragAndDrop() {
        super();
        this.variants = new String[20][20];
        for (int i = 0; i < variants.length; i++) {
            for (int j = 0; j < variants[i].length; j++) {
                variants[i][j] = "Task" + i + "-" + j;
            }
        }
    }
}
