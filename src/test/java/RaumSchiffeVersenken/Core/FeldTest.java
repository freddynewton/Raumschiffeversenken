package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.Entwicklungskonsole.Feld;
import org.junit.Assert;
import org.junit.Test;

public class FeldTest {
    @Test
    public void zielenZumSchiessen() throws Exception {
    }

    @Test
    public void schießen() throws Exception {
    }

    @Test
    public void zielenZumSchiffeSetzen() throws Exception {
    }

    @Test
    public void schiffSetzen() throws Exception {
        //Feld[][] mapGroesse = new Feld[10][10];
        Feld play = new Feld(10, 10);

        play.schiffSetzenManuel(0, 0, 2, 3);
        int[][] result = play.getMapGroesse();
        int[][] expectedArray =  {{5,5,5,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0,0,0}};

        Assert.assertArrayEquals(expectedArray,result);




    }

    @Test
    public void kriegsnebel() throws Exception {
    }

    @Test
    public void bereitAbfrage() throws Exception {
    }

    @Test
    public void trefferZaehler() throws Exception {
    }


}