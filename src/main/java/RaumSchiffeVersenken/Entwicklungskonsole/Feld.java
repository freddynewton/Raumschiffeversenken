package RaumSchiffeVersenken.Entwicklungskonsole;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Feld {

    int xAchse;
    int yAchse;
    public int[][] mapGroesse;
    public int xAchseBeschuss;
    public int yAchseBeschuss;
    public int schiffsRichtung;
    public int SchiffsLaenge;
    public int counterSpieler1 = 0;
    public int counterSpieler2 = 0;
    public int benoetigteTrefferZumGewinnen = 26;

    Lock lock = new ReentrantLock();

    /**
     * <p>Erstellung des Loggers.</p>
     */
    private static final Logger log = LogManager.getLogger(Feld.class);

    /**
     * <p>10x10 Matrix 100 Feldern wird mit Zahlen von 0-99 mit "0" gefüllt.</p>
     *
     * @param xAchse Länge
     * @param yAchse Länge
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
     * <p>Constructor Kopie für das Feld wird erstellt.</p>
     *
     * @param feld überhabe 2D-Array damit eine Copie erstellt wird.
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

    /**
     * <p>Hier werden mit Scanner die jeweilige X-Achse und Y-Achse Koordinate abgefragt und
     * und Kontrolliert ob sie im Array sind und übergibt die Werte dann zur
     * schiessen() methode.</p>
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
                schiessen(xAchseBeschuss, yAchseBeschuss);
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
     * @param yAchseBeschuss yAchse Grad beim beschuss
     * @param xAchseBeschuss xAchse Grad beim beschuss
     */
    public void schiessen(int yAchseBeschuss, int xAchseBeschuss) {
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

    /**
     * @param SchiffsLaenge SchiffsLänge die zum Setzen benötigt wird
     */
    public void zielenZumSchiffeSetzen(int SchiffsLaenge) {
        this.SchiffsLaenge = SchiffsLaenge;

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
            schiffsRichtung = Integer.parseInt(scanrString);

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
                schiffSetzenManuel(xAchseBeschuss, yAchseBeschuss, schiffsRichtung, SchiffsLaenge);
            } else {
                log.info("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse und Bei der Schiffsrichtung nur 1 & 2");
                System.out.println("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse und Bei der Schiffsrichtung nur 1 & 2");
                zielenZumSchiffeSetzen(SchiffsLaenge);
            }
        } catch (Exception ex1) {
            log.error("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse und Bei der Schiffsrichtung nur 1 & 2", ex1);
            System.out.println("Bitte nur zwischen 0-9 jeweils in der X-Achse und Y-Achse und Bei der Schiffsrichtung nur 1 & 2");
            zielenZumSchiffeSetzen(SchiffsLaenge);
        }
    }

    // TODO: 14.06.2018 doppelten code eleganter lösen (variablen)

    /**
     * @param yAchseBeschuss  :)
     * @param xAchseBeschuss  :)
     * @param SchiffsRichtung :)
     * @param SchiffsLaenge   :)
     */
    public void schiffSetzenManuel(int yAchseBeschuss, int xAchseBeschuss, int SchiffsRichtung, int SchiffsLaenge) {
        this.xAchseBeschuss = xAchseBeschuss;
        this.yAchseBeschuss = yAchseBeschuss;
        this.schiffsRichtung = SchiffsRichtung;
        this.SchiffsLaenge = SchiffsLaenge;
        boolean SchiffErfolgreichSetzen = false;
        int SchiffsLaengeCounter = 0;

        try {
            if (SchiffsRichtung == 1) {
                for (int i = 0; i < SchiffsLaenge; i++) {
                    log.info("mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0" + (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0));
                    log.info("mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5" + (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5));
                    if (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0 && mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5) {
                        SchiffsLaengeCounter++;
                    }
                }
            } else if (SchiffsRichtung == 2) {
                for (int i = 0; i < SchiffsLaenge; i++) {
                    log.info("mapGroesse[xAchseBeschuss][yAchseBeschuss + 1] == 0" + (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] == 0));
                    log.info("mapGroesse[xAchseBeschuss][yAchseBeschuss + 1] != 5" + (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] != 5));
                    if (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] == 0 && mapGroesse[xAchseBeschuss][yAchseBeschuss + i] != 5) {
                        SchiffsLaengeCounter++;
                    }
                }
            }

            if (SchiffsLaengeCounter == SchiffsLaenge) {
                SchiffErfolgreichSetzen = true;
            }

            if (SchiffErfolgreichSetzen) {
                if (SchiffsRichtung == 1) {
                    for (int i = 0; i < SchiffsLaenge; i++) {
                        mapGroesse[xAchseBeschuss + i][yAchseBeschuss] += 5;
                    }
                } else if (SchiffsRichtung == 2) {
                    for (int i = 0; i < SchiffsLaenge; i++) {
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

                zielenZumSchiffeSetzen(SchiffsLaenge);
            }
        } catch (Exception ex2) {
            log.error("Bitte eine andere Zelle wählen da hier schon ein Schiff steht\n" +
                    "------------------------------------------------------------------\n" +
                    "\n", ex2);
            System.out.println("Bitte eine andere Zelle wählen da hier schon ein Schiff steht\n" +
                    "------------------------------------------------------------------\n" +
                    "\n");
            zielenZumSchiffeSetzen(SchiffsLaenge);
        }
    }

    /**
     * @param yAchseBeschuss  :)
     * @param xAchseBeschuss  :)
     * @param SchiffsRichtung :)
     * @param SchiffsLaenge   :)
     * @return :)
     */
    public boolean schiffSetzenAutomatisch(int yAchseBeschuss, int xAchseBeschuss, int SchiffsRichtung, int SchiffsLaenge) {
        this.xAchseBeschuss = xAchseBeschuss;
        this.yAchseBeschuss = yAchseBeschuss;
        this.schiffsRichtung = SchiffsRichtung;
        this.SchiffsLaenge = SchiffsLaenge;
        boolean SchiffErfolgreichSetzen = false;
        int SchiffsLaengeCounter = 0;

        try {

            if (SchiffsRichtung == 1) {
                for (int i = 0; i < SchiffsLaenge; i++) {
                    log.info("mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0" + (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0));
                    log.info("mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5" + (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5));
                    if (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0 && mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5) {
                        SchiffsLaengeCounter++;
                    }
                }
            } else if (SchiffsRichtung == 2) {
                for (int i = 0; i < SchiffsLaenge; i++) {
                    log.info("mapGroesse[xAchseBeschuss][yAchseBeschuss + 1] == 0" + (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] == 0));
                    log.info("mapGroesse[xAchseBeschuss][yAchseBeschuss + 1] != 5" + (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] != 5));
                    if (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] == 0 && mapGroesse[xAchseBeschuss][yAchseBeschuss + i] != 5) {
                        SchiffsLaengeCounter++;
                    }
                }
            }

            if (SchiffsLaengeCounter == SchiffsLaenge) {
                SchiffErfolgreichSetzen = true;
            }

            if (SchiffErfolgreichSetzen) {
                if (SchiffsRichtung == 1) {
                    for (int i = 0; i < SchiffsLaenge; i++) {
                        mapGroesse[xAchseBeschuss + i][yAchseBeschuss] += 5;
                    }
                } else if (SchiffsRichtung == 2) {
                    for (int i = 0; i < SchiffsLaenge; i++) {
                        mapGroesse[xAchseBeschuss][yAchseBeschuss + i] += 5;
                    }

                }
            } else {
                log.info("Bitte eine andere Zelle wählen da hier schon ein Schiff steht 'else'\n" +
                        "------------------------------------------------------------------\n" +
                        "\n");
            }
        } catch (Exception ex4) {
            log.error("Bitte eine andere Zelle wählen da hier schon ein Schiff steht 'catch'\n" +
                    "------------------------------------------------------------------\n" +
                    "\n", ex4);
        }
        return SchiffErfolgreichSetzen;
    }

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

    /**
     * @param feld :)
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

    /**
     * @param feld          :)
     * @param SpielerNummer :)
     */
    public void TrefferZaehler(Feld feld, int SpielerNummer) {
        this.counterSpieler1 = counterSpieler1;
        this.counterSpieler2 = counterSpieler2;
        this.benoetigteTrefferZumGewinnen = benoetigteTrefferZumGewinnen;
        this.mapGroesse = mapGroesse;
        int RevanceStatus;

        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                if (mapGroesse[j][i] == 6) {
                    if (SpielerNummer == 1) {
                        counterSpieler2++;
                    } else if (SpielerNummer == 2) {
                        counterSpieler1++;
                    }

                }
            }
        }

        if (counterSpieler1 == benoetigteTrefferZumGewinnen) {
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

            if (RevanceStatus == 2) {
                System.exit(0);
            }

        } else if (counterSpieler2 == benoetigteTrefferZumGewinnen) {

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

            if (RevanceStatus == 2) {
                System.exit(0);
            }

        }
    }

    /**
     * @return :)
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

    /**
     * Für Test relevant
     *
     * @return mapGroesse
     */
    public int[][] getMapGroesse() {
        return mapGroesse;
    }
}
