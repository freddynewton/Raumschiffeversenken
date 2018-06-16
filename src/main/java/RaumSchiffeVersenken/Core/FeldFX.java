package RaumSchiffeVersenken.Core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FeldFX {

    int xAchse;
    int yAchse;
    public int[][] mapGroesse;
    public int xAchseBeschuss;
    public int yAchseBeschuss;
    public int schiffsRichtung;
    public int SchiffsLaenge;

    /**
     * <p>Erstellung des Loggers.</p>
     */
    private static final Logger log = LogManager.getLogger(FeldFX.class);

    /**
     * <p>10x10 Matrix 100 Feldern wird mit Zahlen von 0-99 mit "0" gefüllt.</p>
     *
     * @param xAchse Länge
     * @param yAchse Länge
     */
    public FeldFX(int xAchse, int yAchse) {
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
    public FeldFX(FeldFX feld) {
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
     * Für Test relevant
     *
     * @return mapGroesse
     */
    public int[][] getMapGroesse() {
        return mapGroesse;
    }
}
