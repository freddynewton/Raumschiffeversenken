package RaumSchiffeVersenken.Core;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Feld {

    int xAchse;
    int yAchse;
    int[][] mapGroesse;
    public int xAchseBeschuss;
    public int yAchseBeschuss;
    public int SchiffsRichtung;
    // 1 für x Achse und 2 für y Achse
    public int SchiffsLänge;
    public int CounterSpieler1 = 0;
    public int CounterSpieler2 = 0;
    public int BenötigteTrefferZumGewinnen = 26;

    Lock lock = new ReentrantLock();

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
    // TODO: 20.04.2018 Lock und finally hinzufügen bei allen Methoden
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

    public void zielenZumSchiffeSetzen(int SchiffsLänge) {
        this.SchiffsLänge = SchiffsLänge;

        try {
            log.info("Bitte geben sie ein in welcher Richtung sie das Schiff haben möchten\n" +
                    "1 für die xAchse entlang\n" +
                    "2 für die yAchse entlang\n" +
                    "Hier:  ");
            Scanner scanr = new Scanner(System.in);
            String scanrString = scanr.nextLine();
            SchiffsRichtung = Integer.parseInt(scanrString);

            log.info("Bitte den gewünschten X-Achsenwert eingeben: ");
            Scanner scanx = new Scanner(System.in);
            String scanxString = scanx.nextLine();
            xAchseBeschuss = Integer.parseInt(scanxString);

            log.info("Bitte den gewünschten Y-Achsenwert eingeben: ");
            Scanner scany = new Scanner(System.in);
            String scanyString = scany.nextLine();
            yAchseBeschuss = Integer.parseInt(scanyString);

            if (yAchseBeschuss < 10 && yAchseBeschuss >= 0 && xAchseBeschuss < 10 && xAchseBeschuss >= 0) {
                schiffSetzen(xAchseBeschuss, yAchseBeschuss, SchiffsRichtung, SchiffsLänge);
            } else {
                log.info("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse und Bei der Schiffsrichtung nur 1 & 2");
                zielenZumSchiffeSetzen(SchiffsLänge);
            }
        } catch (Exception ex1) {
            log.error("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse und Bei der Schiffsrichtung nur 1 & 2", ex1);
            System.out.println("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse und Bei der Schiffsrichtung nur 1 & 2");
            zielenZumSchiffeSetzen(SchiffsLänge);
        }
    }

    public void schiffSetzen(int yAchseBeschuss, int xAchseBeschuss, int SchiffsRichtung, int SchiffsLänge) {
        this.xAchseBeschuss = xAchseBeschuss;
        this.yAchseBeschuss = yAchseBeschuss;
        this.SchiffsRichtung = SchiffsRichtung;
        this.SchiffsLänge = SchiffsLänge;

        try {
            if ((mapGroesse[xAchseBeschuss][yAchseBeschuss] == 0 || mapGroesse[xAchseBeschuss][yAchseBeschuss] != 5) &&
                    SchiffsRichtung == 1) {
                for (int i = 0; i < SchiffsLänge; i++) {
                    mapGroesse[xAchseBeschuss + i][yAchseBeschuss] += 5;
                }
            } else if ((mapGroesse[xAchseBeschuss][yAchseBeschuss] == 0 || mapGroesse[xAchseBeschuss][yAchseBeschuss] != 5) &&
                    SchiffsRichtung == 2) {
                for (int i = 0; i < SchiffsLänge; i++) {
                    mapGroesse[xAchseBeschuss][yAchseBeschuss + i] += 5;
                }
            } else {
                log.info("Bitte eine andere Zelle wählen da hier schon ein Schiff steht\n" +
                        "------------------------------------------------------------------\n" +
                        "\n");
                zielenZumSchiffeSetzen(SchiffsLänge);
            }
        } catch (Exception ex2) {
            log.error("Bitte eine andere Zelle wählen da hier schon ein Schiff steht\n" +
                    "------------------------------------------------------------------\n" +
                    "\n", ex2);
            System.out.println("Bitte eine andere Zelle wählen da hier schon ein Schiff steht\n" +
                    "------------------------------------------------------------------\n" +
                    "\n");
            zielenZumSchiffeSetzen(SchiffsLänge);
        }
    }

    // ----------------------------------------------------------------------------------------------

    public void Kriegsnebel() {
        this.mapGroesse = mapGroesse;

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                if (mapGroesse[j][i] == 5) {
                    mapGroesse[j][i] = 0;
                }
            }
        }
    }

    // ----------------------------------------------------------------------------------------------

    public void BereitAbfrage(Feld feld) {

        int BereitStatus = 0;

        log.info("Sind sie Bereit?\n" +
                "1 für Bereit\n" +
                "2 für nicht Bereit\n" +
                "Hier: ");

        Scanner BereitScanner = new Scanner(System.in);
        String BereitString = BereitScanner.nextLine();
        BereitStatus = Integer.parseInt(BereitString);

        if (BereitStatus == 2) {
            BereitAbfrage(feld);
            System.out.println(feld.toString());
        }

    }

    //-------------------------------------------------------------------------------------------------
// TODO: 03.05.2018 Auf Jar-Datei warten um die App neu zu starten in dem Revance
    public void TrefferZaehler(Feld feld, int SpielerNummer) {
        this.CounterSpieler1 = CounterSpieler1;
        this.CounterSpieler2 = CounterSpieler2;
        this.BenötigteTrefferZumGewinnen = BenötigteTrefferZumGewinnen;
        this.mapGroesse = mapGroesse;
        int RevanceStatus;


        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                if (mapGroesse[j][i] == 6) {
                    if (SpielerNummer == 1) {
                        CounterSpieler1++;
                    } else if (SpielerNummer == 2) {
                        CounterSpieler2++;
                    }

                }
            }
        }
        if (CounterSpieler1 == BenötigteTrefferZumGewinnen) {
            System.out.println("Spieler 1 hat gewonnen!\n" +
                    "Möchten sie eine Revance?\n" +
                    "1 für Ja\n" +
                    "2 für Nein\n" +
                    "Hier: ");
            Scanner RevanceScanner = new Scanner(System.in);
            String BereitString = RevanceScanner.nextLine();
            RevanceStatus = Integer.parseInt(BereitString);

            if (RevanceStatus == 1) {

            } else if (RevanceStatus == 2) {
                System.exit(0);
            }

        } else if (CounterSpieler2 == BenötigteTrefferZumGewinnen) {

            System.out.println("Spieler 2 hat gewonnen!\n" +
                    "Möchten sie eine Revance?\n" +
                    "1 für Ja\n" +
                    "2 für Nein\n" +
                    "Hier: ");
            Scanner RevanceScanner = new Scanner(System.in);
            String BereitString = RevanceScanner.nextLine();
            RevanceStatus = Integer.parseInt(BereitString);

            if (RevanceStatus == 1) {

            } else if (RevanceStatus == 2) {
                System.exit(0);
            }

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
