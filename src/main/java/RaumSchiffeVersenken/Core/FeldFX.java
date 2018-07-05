package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.Exception.AbtasterException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FeldFX {

    public int[][] mapGroesse;

    /**
     * <p>Erstellung des Loggers.</p>
     */
    private static final Logger log = LogManager.getLogger(FeldFX.class);

    /**
     * <p>10x10 Matrix 100 Feldern wird mit Zahlen von 0-99 mit "0" gefuellt.</p>
     *
     * @param xAchse Laenge
     * @param yAchse Laenge
     */
    FeldFX(int xAchse, int yAchse) {
        this.mapGroesse = new int[xAchse][yAchse];

        for (int y = 0; y < yAchse; y++) {
            for (int x = 0; x < xAchse; x++) {
                mapGroesse[x][y] = 0;
            }
        }
    }

    /**
     * @param yAchseBeschuss  y-Koordinate des Schusses
     * @param xAchseBeschuss  x-Koordinate des Schusses
     * @param schiffsRichtung Ausrichtung des Schiffes
     * @param schiffsLaenge   Laenge des Schiffes
     * @return boolean
     */
    boolean schiffSetzenAutomatisch(int yAchseBeschuss, int xAchseBeschuss, int schiffsRichtung, int schiffsLaenge) throws AbtasterException {
        boolean schiffErfolgreichSetzen = false;
        int schiffsLaengeCounter = 0;

        try {
            if (schiffsRichtung == 1) {
                for (int i = 0; i < schiffsLaenge; i++) {
                    if (mapGroesse[xAchseBeschuss + i][yAchseBeschuss] == 0 && mapGroesse[xAchseBeschuss + i][yAchseBeschuss] != 5) {
                        schiffsLaengeCounter++;
                    }
                }
            } else if (schiffsRichtung == 2) {
                for (int i = 0; i < schiffsLaenge; i++) {
                    if (mapGroesse[xAchseBeschuss][yAchseBeschuss + i] == 0 && mapGroesse[xAchseBeschuss][yAchseBeschuss + i] != 5) {
                        schiffsLaengeCounter++;
                    }
                }
            }

            if (schiffsLaengeCounter == schiffsLaenge) {
                schiffErfolgreichSetzen = true;
            } else {
                throw new AbtasterException("Abtaster fehlschlag");
            }

            if (schiffsRichtung == 1) {
                for (int i = 0; i < schiffsLaenge; i++) {
                    mapGroesse[xAchseBeschuss + i][yAchseBeschuss] += 5;
                    log.info("Schiff erfolgreich horizontal gesetzt.\n");
                }
            } else if (schiffsRichtung == 2) {
                for (int i = 0; i < schiffsLaenge; i++) {
                    mapGroesse[xAchseBeschuss][yAchseBeschuss + i] += 5;
                    log.info("Schiff erfolgreich vertikal gesetzt.\n");
                }
            }
        } catch (Exception ex) {
            log.error("Catchblock: Schiff wurde nicht gesetzt", ex);
        }
        return schiffErfolgreichSetzen;
    }

    /**
     * <p>Für Test relevant</p>
     *
     * @return mapGroesse
     */
    int[][] getMapGroesse() {
        return mapGroesse;
    }
}
