package RaumSchiffeVersenken;

public class Feld {

    int breite = 10;
    int laenge = 10;


    /**
     * 10x10 Matrix 100 Felder mit Zahlen von 0-100
     *
     * @param xAchse
     * @param yAchse
     */
    public Feld(int xAchse, int yAchse) {
        this.breite = xAchse;
        this.laenge = yAchse;
        int[][] mapGroesse = new int[xAchse][yAchse];


        int IDverweiser = 0;
        for (int y = 0; y < yAchse; y++) {
            for (int x = 0; x < xAchse; x++) {
                mapGroesse[x][y] = IDverweiser;
                IDverweiser++;
            }
        }


    }


}
