package RaumSchiffeVersenken.Entwicklungskonsole;


public class SpielSystemMain {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Spielablauf s = new Spielablauf();

        s.start();
        s.SchiffeSetzenAblauf();
        s.SchiessenAblauf();
    }
}
