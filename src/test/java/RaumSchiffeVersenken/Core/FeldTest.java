package RaumSchiffeVersenken.Core;

import org.junit.Assert;
import org.junit.Test;


public class FeldTest {
    @Test
    public void feldErstellen() throws Exception {
        FeldFX spielFeld1 = new FeldFX(10,10);

        int[][] erwartetesFeld =   {{0,0,0,0,0,0,0,0,0,0},
                                    {0,0,0,0,0,0,0,0,0,0}};

        Assert.assertNotEquals(spielFeld1, erwartetesFeld);
    }

    @Test
    public void schiffSetzen() throws Exception {
        FeldFX play = new FeldFX(10, 10);

        play.schiffSetzenAutomatisch(0, 0, 2, 3);
        int[][] ergebnis = play.getMapGroesse();
        int[][] erwartetesFeld =  {{5,5,5,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0}};

        Assert.assertArrayEquals(erwartetesFeld,ergebnis);
    }

    // TODO: 21.06.2018 Negativtescht einfügen

    @Test (expected = IllegalArgumentException.class)
    public void feldNegativTest() throws Exception{
        //FeldFX spielFeld1 = new FeldFX(10,10);

    }
}