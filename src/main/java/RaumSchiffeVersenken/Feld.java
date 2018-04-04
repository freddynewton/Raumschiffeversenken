package RaumSchiffeVersenken;

public class Feld {

    int xAchse;
    int yAchse;
    int[][] mapGroesse;

    /**
     * 10x10 Matrix 100 Felder mit Zahlen von 0-100
     *
     * @param xAchse
     * @param yAchse
     */
    public Feld(int xAchse, int yAchse) {
        this.xAchse = xAchse;
        this.yAchse = yAchse;
        this.mapGroesse = new int[xAchse][yAchse];


        for (int y = 0; y < yAchse; y++) {
            for (int x = 0; x < xAchse; x++) {
                mapGroesse[x][y] = 0;
            }
        }
    }

    @Override
    public String toString() {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                System.out.print(mapGroesse[j][i]);
            }
            System.out.println();
        }
        return "";
    }
}
