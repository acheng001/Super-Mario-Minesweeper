package ca.cmpt276.cmpt276assignmentthree;

public class Opt {

    public static Opt instance;
    private static int rows;
    private static int columns;
    private static int mine;

    private Opt(){
        rows = 4;
        columns = 6;
        mine = 6;
    }

    public static Opt getInstance(){
        if(instance == null){
            instance = new Opt();
        }
        return instance;
    }


    public static int getColumns() {
        return columns;
    }

    public static void setColumns(int columns) {
        Opt.columns = columns;
    }

    public static int getRows() {
        return rows;
    }

    public static void setRows(int rows) {
        Opt.rows = rows;
    }

    public static int getMine() {
        return mine;
    }

    public static void setMine(int mine) {
        Opt.mine = mine;
    }
}
