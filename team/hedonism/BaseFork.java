package team.hedonism;

public class BaseFork {
    private int id;

    public BaseFork(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void take() {
        long t = System.nanoTime();
        if (Main.DEBUG) {
            System.out.println(t + ": Fork " + id + " is taken");
        }
    }

    public void put() {
        long t = System.nanoTime();
        if (Main.DEBUG) {
            System.out.println(t + ": Fork " + id + " is put");
        }
    }
}
