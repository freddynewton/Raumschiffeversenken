package RaumSchiffeVersenken;

public class ersteMap {

    int breite = 9;
    int laenge = 9;
    int[][] MapGroesse = new int[breite][laenge];


    public ersteMap(int breite, int laenge, int[][] mapGroesse) {
        this.breite = breite;
        this.laenge = laenge;
        MapGroesse = mapGroesse;

        for (int i = 0; i < breite; i++) {
            for (int x = 0; x < laenge; x++) {
                MapGroesse[i][x] = i + x;
            }
        }


    }


}
