package RaumSchiffeVersenken.Core;

import java.util.Scanner;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Feld {

    int xAchse;
    int yAchse;
    int[][] mapGroesse;
    public int xAchseBeschuss;
    public int yAchseBeschuss;

    private static final Logger log = LogManager.getLogger(Feld.class);

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

    //--------------------------------------------------------------------------------------------------------------------

    public void zielenZumSchiessen() {

        try {
            log.info("Bitte den gewünschten X-Achsenwert eingeben: ");
            Scanner scanx = new Scanner(System.in);
            String scanxString = scanx.nextLine();
            xAchseBeschuss = Integer.parseInt(scanxString);

            log.info("Bitte den gewünschten Y-Achsenwert eingeben: ");
            Scanner scany = new Scanner(System.in);
            String scanyString = scany.nextLine();
            yAchseBeschuss = Integer.parseInt(scanyString);

            if (yAchseBeschuss < 10 && yAchseBeschuss >= 0 && xAchseBeschuss < 10 && xAchseBeschuss >= 0) {
                schießen(xAchseBeschuss, yAchseBeschuss);
            } else {
                log.info("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse");
                zielenZumSchiessen();
            }
        } catch (Exception ex1) {
            log.error("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse", ex1);
            System.out.println("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse");
            zielenZumSchiessen();
        }
    }

    public void schießen(int yAchseBeschuss, int xAchseBeschuss) {
        this.xAchseBeschuss = xAchseBeschuss;
        this.yAchseBeschuss = yAchseBeschuss;

        try {
            if (mapGroesse[xAchseBeschuss][yAchseBeschuss] == 0 || mapGroesse[xAchseBeschuss][yAchseBeschuss] == 5) {
                mapGroesse[xAchseBeschuss][yAchseBeschuss] += 1;
            } else {
                log.info("Bitte eine andere Zelle wählen da hier schon attackiert wurde\n" +
                        "------------------------------------------------------------------\n" +
                        "\n");
                zielenZumSchiessen();
            }
        } catch (Exception ex2) {
            log.error("Bitte eine andere Zelle wählen da hier schon attackiert wurde\n" +
                    "------------------------------------------------------------------\n" +
                    "\n", ex2);
            System.out.println("Bitte eine andere Zelle wählen da hier schon attackiert wurde\n" +
                    "------------------------------------------------------------------\n" +
                    "\n");
            zielenZumSchiessen();
        }
    }


    //---------------------------------------------------------------------------------------------------------------------

    public void zielenZumSchiffeSetzen() {
        try {
            log.info("Bitte den gewünschten X-Achsenwert eingeben: ");
            Scanner scanx = new Scanner(System.in);
            String scanxString = scanx.nextLine();
            xAchseBeschuss = Integer.parseInt(scanxString);

            log.info("Bitte den gewünschten Y-Achsenwert eingeben: ");
            Scanner scany = new Scanner(System.in);
            String scanyString = scany.nextLine();
            yAchseBeschuss = Integer.parseInt(scanyString);

            if (yAchseBeschuss < 10 && yAchseBeschuss >= 0 && xAchseBeschuss < 10 && xAchseBeschuss >= 0) {
                schiffSetzen(xAchseBeschuss, yAchseBeschuss);
            } else {
                log.info("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse");
                zielenZumSchiffeSetzen();
            }
        } catch (Exception ex1) {
            log.error("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse", ex1);
            System.out.println("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse");
            zielenZumSchiffeSetzen();
        }
    }

    public void schiffSetzen(int yAchseBeschuss, int xAchseBeschuss) {
        this.xAchseBeschuss = xAchseBeschuss;
        this.yAchseBeschuss = yAchseBeschuss;

        try {
            if (mapGroesse[xAchseBeschuss][yAchseBeschuss] == 0 || mapGroesse[xAchseBeschuss][yAchseBeschuss] != 5) {
                mapGroesse[xAchseBeschuss][yAchseBeschuss] += 5;
            } else {
                log.info("Bitte eine andere Zelle wählen da hier schon ein Schiff steht\n" +
                        "------------------------------------------------------------------\n" +
                        "\n");
                zielenZumSchiffeSetzen();
            }
        } catch (Exception ex2) {
            log.error("Bitte eine andere Zelle wählen da hier schon ein Schiff steht\n" +
                    "------------------------------------------------------------------\n" +
                    "\n", ex2);
            System.out.println("Bitte eine andere Zelle wählen da hier schon ein Schiff steht\n" +
                    "------------------------------------------------------------------\n" +
                    "\n");
            zielenZumSchiffeSetzen();
        }

    }

    @Override
    public String toString() {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                System.out.print(mapGroesse[j][i] + " ");
            }
            System.out.println();
        }
        return "";
    }
}
