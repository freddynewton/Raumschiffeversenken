package RaumSchiffeVersenken;

public class ersteMap {

    int breite = 10;
    int laenge = 10;
    int[][] MapGroesse = new int[breite][laenge];


    public ersteMap(int breite, int laenge, int[][] mapGroesse) {
        this.breite = breite;
        this.laenge = laenge;
        MapGroesse = mapGroesse;

        int x = 1;
        for (int i = 0; i < breite; i++) {
            for (int j = 0; j < laenge; j++) {
                mapGroesse[i][j] = x;
                x++;
            }
        }


        /**
         for (int i = 0; i < breite; i++) {
         for (int j = 0; x < laenge; x++) {
         MapGroesse[i][j] = i * x;
         }
         }
         */

    }
}
