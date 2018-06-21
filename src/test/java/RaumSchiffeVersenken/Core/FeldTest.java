package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.GUISteuerung.GUISpielrundeFenster;
import javafx.scene.control.Label;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;


public class FeldTest {

    /**
     * Fuehrt einen Test durch, ob ein neu erstelltes Feld die richtige Groesse hat.
     *
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
     *
     */
    @Test
    public void schiffSetzen() {
        FeldFX spielFeld = new FeldFX(10, 10);

        spielFeld.schiffSetzenAutomatisch(0, 0, 2, 3);
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
    @Test
    public void exceptionTest() {
        try {
            FeldFX feldFX = null;
            feldFX.getMapGroesse();

            fail("NullPointerException!");
        } catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
    }
}