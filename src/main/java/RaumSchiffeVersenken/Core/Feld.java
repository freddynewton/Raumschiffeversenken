package RaumSchiffeVersenken.Core;

import java.util.Scanner;

public class Feld {

    int xAchse;
    int yAchse;
    int[][] mapGroesse;
    public int xAchseBeschuss;
    public int yAchseBeschuss;

    /**
     * 10x10 Matrix 100 Felder mit Zahlen von 0-99 mit 0 gefüllt
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

    public void zielen() {
        try {
            System.out.println("Bitte den gewünschten X-Achsenwert eingeben: ");
            Scanner scanx = new Scanner(System.in);
            String scanxString = scanx.nextLine();
            xAchseBeschuss = Integer.parseInt(scanxString);

            System.out.println("Bitte den gewünschten Y-Achsenwert eingeben: ");
            Scanner scany = new Scanner(System.in);
            String scanyString = scany.nextLine();
            yAchseBeschuss = Integer.parseInt(scanyString);

            if (yAchseBeschuss < 10 && yAchseBeschuss >= 0 && xAchseBeschuss < 10 && xAchseBeschuss >= 0) {
                schießen(xAchseBeschuss, yAchseBeschuss);
            }
        } catch (Exception e) {
            System.out.println("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse");
        }


    }

    public void schießen(int yAchseBeschuss, int xAchseBeschuss) {
        this.xAchseBeschuss = xAchseBeschuss;
        this.yAchseBeschuss = yAchseBeschuss;
        mapGroesse[xAchseBeschuss][yAchseBeschuss] += 1;


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
