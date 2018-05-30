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
    public int SchiffsLänge;
    public int CounterSpieler1 = 0;
    public int CounterSpieler2 = 0;
    public int BenoetigteTrefferZumGewinnen = 26;

    Lock lock = new ReentrantLock();

    /**
     *Logger erstellung.
     */
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

    /**
     * Constructor Copy
     *
     * @param feld
     */
    public Feld(Feld feld) {
        this.xAchse = feld.xAchse;
        this.yAchse = feld.yAchse;
        this.mapGroesse = new int[xAchse][yAchse];

        for (int y = 0; y < yAchse; y++) {
            for (int x = 0; x < xAchse; x++) {
                mapGroesse[x][y] = feld.mapGroesse[x][y];
            }
        }
    }

    //--------------------------------------------------------------------------------------------------------------------
    // TODO: 20.04.2018 Lock und finally hinzufügen bei allen Methoden

    /**
     * Hier werden mit Scanner die jeweilige X-Achse und Y-Achse Koordinate abgefragt und
     * und Kontrolliert ob sie im Array sind und übergibt die Werte dann zur
     * schießen() methode
     *
     */
    public void zielenZumSchiessen() {

        try {
            log.info("Bitte den gewünschten X-Achsenwert eingeben: ");
            System.out.println("Bitte den gewünschten X-Achsenwert eingeben: ");
            Scanner scanx = new Scanner(System.in);
            String scanxString = scanx.nextLine();
            xAchseBeschuss = Integer.parseInt(scanxString);

            log.info("Bitte den gewünschten Y-Achsenwert eingeben: ");
            System.out.println("Bitte den gewünschten Y-Achsenwert eingeben: ");
            Scanner scany = new Scanner(System.in);
            String scanyString = scany.nextLine();
            yAchseBeschuss = Integer.parseInt(scanyString);

            if (yAchseBeschuss < 10 && yAchseBeschuss >= 0 && xAchseBeschuss < 10 && xAchseBeschuss >= 0) {
                schießen(xAchseBeschuss, yAchseBeschuss);
            } else {
                log.info("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse");
                System.out.println("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse");
                zielenZumSchiessen();
            }
        } catch (Exception ex1) {
            log.error("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse", ex1);
            System.out.println("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse");
            zielenZumSchiessen();
        }
    }


    /**
     * @param yAchseBeschuss
     * @param xAchseBeschuss
     */
    public void schießen(int yAchseBeschuss, int xAchseBeschuss) {
        this.xAchseBeschuss = xAchseBeschuss;
        this.yAchseBeschuss = yAchseBeschuss;

        try {
            if (mapGroesse[xAchseBeschuss][yAchseBeschuss] == 0 || mapGroesse[xAchseBeschuss][yAchseBeschuss] == 5) {
                mapGroesse[xAchseBeschuss][yAchseBeschuss] += 1;
                if (mapGroesse[xAchseBeschuss][yAchseBeschuss] == 6) {
                    log.info("GETROFFEN! Sie dürfen nochmal!\n");
                    System.out.println("GETROFFEN! Sie dürfen nochmal!");
                    zielenZumSchiessen();
                }
            } else {
                log.info("Bitte eine andere Zelle wählen da hier schon attackiert wurde\n" +
                        "------------------------------------------------------------------\n" +
                        "\n");
                System.out.println("Bitte eine andere Zelle wählen da hier schon attackiert wurde\n" +
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

    /**
     *
     * @param SchiffsLänge
     */
    public void zielenZumSchiffeSetzen(int SchiffsLänge) {
        this.SchiffsLänge = SchiffsLänge;

        try {
            log.info("Bitte geben sie ein in welcher Richtung sie das Schiff haben möchten\n" +
                    "1 für die yAchse entlang\n" +
                    "2 für die xAchse entlang\n" +
                    "Hier:  ");
            System.out.println("Bitte geben sie ein in welcher Richtung sie das Schiff haben möchten\n" +
                    "1 für die yAchse entlang\n" +
                    "2 für die xAchse entlang\n" +
                    "Hier:  ");
            Scanner scanr = new Scanner(System.in);
            String scanrString = scanr.nextLine();
            SchiffsRichtung = Integer.parseInt(scanrString);

            log.info("Bitte den gewünschten X-Achsenwert eingeben: ");
            System.out.println("Bitte den gewünschten X-Achsenwert eingeben: ");
            Scanner scanx = new Scanner(System.in);
            String scanxString = scanx.nextLine();
            xAchseBeschuss = Integer.parseInt(scanxString);

            log.info("Bitte den gewünschten Y-Achsenwert eingeben: ");
            System.out.println("Bitte den gewünschten Y-Achsenwert eingeben: ");
            Scanner scany = new Scanner(System.in);
            String scanyString = scany.nextLine();
            yAchseBeschuss = Integer.parseInt(scanyString);

            if (yAchseBeschuss < 10 && yAchseBeschuss >= 0 && xAchseBeschuss < 10 && xAchseBeschuss >= 0) {
                schiffSetzenManuel(xAchseBeschuss, yAchseBeschuss, SchiffsRichtung, SchiffsLänge);
            } else {
                log.info("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse und Bei der Schiffsrichtung nur 1 & 2");
                System.out.println("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse und Bei der Schiffsrichtung nur 1 & 2");
                zielenZumSchiffeSetzen(SchiffsLänge);
            }
        } catch (Exception ex1) {
            log.error("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse und Bei der Schiffsrichtung nur 1 & 2", ex1);
            System.out.println("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse und Bei der Schiffsrichtung nur 1 & 2");
            zielenZumSchiffeSetzen(SchiffsLänge);
        }
    }

    /**
     *
     * @param yAchseBeschuss
     * @param xAchseBeschuss
     * @param SchiffsRichtung
     * @param SchiffsLänge
     */
    public void schiffSetzenManuel(int yAchseBeschuss, int xAchseBeschuss, int SchiffsRichtung, int SchiffsLänge) {
        this.xAchseBeschuss = xAchseBeschuss;
        this.yAchseBeschuss = yAchseBeschuss;
        this.SchiffsRichtung = SchiffsRichtung;
        this.SchiffsLänge = SchiffsLänge;
        boolean SchiffErfolgreichSetzen = false;
        int SchiffsLängeCounter = 0;

        try {

            if (SchiffsRichtung == 1) {
                for (int i = 0; i < SchiffsLänge; i++) {
                    log.info("mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0" + (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0));
                    log.info("mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5" + (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5));
                    if (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0 && mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5) {
                        SchiffsLängeCounter++;
                    }
                }
            } else if (SchiffsRichtung == 2) {
                for (int i = 0; i < SchiffsLänge; i++) {
                    log.info("mapGroesse[xAchseBeschuss][yAchseBeschuss + 1] == 0" + (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] == 0));
                    log.info("mapGroesse[xAchseBeschuss][yAchseBeschuss + 1] != 5" + (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] != 5));
                    if (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] == 0 && mapGroesse[xAchseBeschuss][yAchseBeschuss + i] != 5) {
                        SchiffsLängeCounter++;
                    }
                }
            }

            if (SchiffsLängeCounter == SchiffsLänge) {
                SchiffErfolgreichSetzen = true;
            }

            if (SchiffErfolgreichSetzen == true) {
                if (SchiffsRichtung == 1) {
                    for (int i = 0; i < SchiffsLänge; i++) {
                        mapGroesse[xAchseBeschuss + i][yAchseBeschuss] += 5;
                    }
                } else if (SchiffsRichtung == 2) {
                    for (int i = 0; i < SchiffsLänge; i++) {
                        mapGroesse[xAchseBeschuss][yAchseBeschuss + i] += 5;
                    }
                }
            } else {
                log.info("Bitte eine andere Zelle wählen da hier schon ein Schiff steht\n" +
                        "------------------------------------------------------------------\n" +
                        "\n");
                System.out.println("Bitte eine andere Zelle wählen da hier schon ein Schiff steht\n" +
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


    public boolean schiffSetzenAutomatisch(int yAchseBeschuss, int xAchseBeschuss, int SchiffsRichtung, int SchiffsLänge) {
        this.xAchseBeschuss = xAchseBeschuss;
        this.yAchseBeschuss = yAchseBeschuss;
        this.SchiffsRichtung = SchiffsRichtung;
        this.SchiffsLänge = SchiffsLänge;
        boolean SchiffErfolgreichSetzen = false;
        int SchiffsLängeCounter = 0;

        try {

            if (SchiffsRichtung == 1) {
                for (int i = 0; i < SchiffsLänge; i++) {
                    log.info("mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0" + (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0));
                    log.info("mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5" + (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5));
                    if (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0 && mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5) {
                        SchiffsLängeCounter++;
                    }
                }
            } else if (SchiffsRichtung == 2) {
                for (int i = 0; i < SchiffsLänge; i++) {
                    log.info("mapGroesse[xAchseBeschuss][yAchseBeschuss + 1] == 0" + (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] == 0));
                    log.info("mapGroesse[xAchseBeschuss][yAchseBeschuss + 1] != 5" + (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] != 5));
                    if (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] == 0 && mapGroesse[xAchseBeschuss][yAchseBeschuss + i] != 5) {
                        SchiffsLängeCounter++;
                    }
                }
            }

            if (SchiffsLängeCounter == SchiffsLänge) {
                SchiffErfolgreichSetzen = true;
            }

            if (SchiffErfolgreichSetzen) {
                if (SchiffsRichtung == 1) {
                    for (int i = 0; i < SchiffsLänge; i++) {
                        mapGroesse[xAchseBeschuss + i][yAchseBeschuss] += 5;
                    }

                } else if (SchiffsRichtung == 2) {
                    for (int i = 0; i < SchiffsLänge; i++) {
                        mapGroesse[xAchseBeschuss][yAchseBeschuss + i] += 5;
                    }

                }
            } else {
                log.info("Bitte eine andere Zelle wählen da hier schon ein Schiff steht 'else'\n" +
                        "------------------------------------------------------------------\n" +
                        "\n");
                System.out.println("Bitte eine andere Zelle wählen da hier schon ein Schiff steht 'else'\n" +
                        "------------------------------------------------------------------\n" +
                        "\n");

            }
        } catch (Exception ex4) {
            log.error("Bitte eine andere Zelle wählen da hier schon ein Schiff steht 'catch'\n" +
                    "------------------------------------------------------------------\n" +
                    "\n", ex4);
            System.out.println("Bitte eine andere Zelle wählen da hier schon ein Schiff steht 'catch'\n" +
                    "------------------------------------------------------------------\n" +
                    "\n");

        }
        return SchiffErfolgreichSetzen;
    }


    // ----------------------------------------------------------------------------------------------

    /**
     *
     */
    public void kriegsnebel() {

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                if (mapGroesse[j][i] == 5) {
                    mapGroesse[j][i] = 0;
                }
            }
        }
    }

    // ----------------------------------------------------------------------------------------------

    /**
     *
     * @param feld
     */
    public void BereitAbfrage(Feld feld) {

        int BereitStatus = 0;

        /*
        log.info("Sind sie Bereit?\n" +
                "1 für Bereit\n" +
                "2 für nicht Bereit\n" +
                "Hier: ");
       */
        System.out.println("Sind sie Bereit?\n" +
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

    /**
     *
     * @param feld
     * @param SpielerNummer
     */
    public void TrefferZaehler(Feld feld, int SpielerNummer) {
        this.CounterSpieler1 = CounterSpieler1;
        this.CounterSpieler2 = CounterSpieler2;
        this.BenoetigteTrefferZumGewinnen = BenoetigteTrefferZumGewinnen;
        this.mapGroesse = mapGroesse;
        int RevanceStatus;


        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                if (mapGroesse[j][i] == 6) {
                    if (SpielerNummer == 1) {
                        CounterSpieler2++;
                    } else if (SpielerNummer == 2) {
                        CounterSpieler1++;
                    }

                }
            }
        }

        if (CounterSpieler1 == BenoetigteTrefferZumGewinnen) {
            log.info("Spieler 1 hat gewonnen!\n" +
                    "Möchten sie eine Revance?\n" +
                    "1 für Ja\n" +
                    "2 für Nein\n" +
                    "Hier: ");
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

        } else if (CounterSpieler2 == BenoetigteTrefferZumGewinnen) {

            log.info("Spieler 2 hat gewonnen!\n" +
                    "Möchten sie eine Revance?\n" +
                    "1 für Ja\n" +
                    "2 für Nein\n" +
                    "Hier: ");
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

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                //log.info("Feld wurde ausgeprintet!");
                System.out.print(mapGroesse[j][i] + " ");
            }
            System.out.println();
        }
        return "";
    }

    /** Für Test relevant
     *
     * @return
     */
    public int[][] getMapGroesse() {
        return mapGroesse;
    }
}
