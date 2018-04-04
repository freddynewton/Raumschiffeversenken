package RaumSchiffeVersenken;

import java.util.Arrays;

public class SpielSystemMain {
    public static void main(String[] args) {


        int[][] mapMitZelle = new int[10][10];

        //Arrays.fill(mapMitZelle, 0);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                mapMitZelle[i][j] = 0;
            }

        }

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                System.out.print(mapMitZelle[j][i]);
            }
            System.out.println();
        }




    }
}
