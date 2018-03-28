package RaumSchiffeVersenken;

public class Feld {

    int breite = 10;
    int laenge = 10;
    int[][] MapGroesse = new int[breite][laenge];

    /**
     * 10x10 Matrix 100 Felder mit Zahlen von 0-100
     *
     * @param breite
     * @param laenge
     * @param mapGroesse besteht aus breite * laenge
     */
    public Feld(int breite, int laenge, int[][] mapGroesse) {
        this.breite = breite;
        this.laenge = laenge;
        MapGroesse = mapGroesse;


        int x = 0;
        for (int i = 0; i < breite; i++) {
            for (int j = 0; j < laenge; j++) {
                mapGroesse[i][j] = x;
                x++;
            }
        }
    }
}
