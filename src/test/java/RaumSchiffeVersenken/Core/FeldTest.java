package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.Exception.AbtasterException;
import RaumSchiffeVersenken.GUISteuerung.GUISpielrundeFenster;
import RaumSchiffeVersenken.Interface_Factory.RaumSchiff;
import RaumSchiffeVersenken.Interface_Factory.SchiffFactory;
import javafx.scene.control.Label;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;


public class FeldTest {

    /**
     * Fuehrt einen Test durch, ob ein neu erstelltes Feld die richtige Groesse hat.
     */
    @Test
    public void feldErstellen() {
        FeldFX spielFeld = new FeldFX(10, 10);

        int[][] erwartetesFeld = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        Assert.assertNotEquals(spielFeld, erwartetesFeld);
    }

    /**
     * Fuehrt einen Test durch, ob Schiffe richtig im Spielfeld-Array gesetzt werden.
     */
    @Test
    public void schiffSetzen() {
        FeldFX spielFeld = new FeldFX(10, 10);

        try {
            spielFeld.schiffSetzenAutomatisch(0, 0, 2, 3);
        } catch (AbtasterException e) {
            e.printStackTrace();
        }
        int[][] ergebnis = spielFeld.getMapGroesse();
        int[][] erwartetesFeld =
                {{5, 5, 5, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        Assert.assertArrayEquals(erwartetesFeld, ergebnis);
    }

    /**
     * Fuehrt einen Test durch, um die Funktionalitaet der Textausgabe zu pruefen.
     */
    @Test
    public void exceptionTestTextAusgabe() {
        try {
            GUISpielrundeFenster.textAusgabeSteuerung("Test", new Label());
            fail("Label konnte nicht initialisiert werden.");
        } catch (Throwable expected) {
            assertEquals(ExceptionInInitializerError.class, expected.getClass());
        }
    }

    /**
     * Fuehrt einen Test durch, um eine Exception zu testen.
     */
    @SuppressWarnings("unchecked")
    @Test(expected = NullPointerException.class)
    public void exceptionTest() {
        FeldFX feldFX = null;
        try {
            feldFX.schiffSetzenAutomatisch(3, 3, 2, 3);
        } catch (AbtasterException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fuehrt einen Test durch, um die Funktion der HashMap (schiffsMap) zu testen und berechnet dazu die Summe aller Schiffslaengen innerhalb der Map.
     */
    @Test
    public void mapParallelStream() {

        HashMap<Integer, RaumSchiff> schiffsMap = new HashMap<>();

        int SchiffslaengeGesamt;

            schiffsMap.put(1, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
            schiffsMap.put(2, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
            schiffsMap.put(3, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));
            schiffsMap.put(4, Objects.requireNonNull(SchiffFactory.getRaumschiff("5")));

        SchiffslaengeGesamt = schiffsMap
                .entrySet()
                .parallelStream()
                .mapToInt(e -> e.getValue().getLaenge()).sum();

        assertEquals(12, SchiffslaengeGesamt);
    }
}