package RaumSchiffeVersenken.Core.SchiffsArten;

import RaumSchiffeVersenken.Interface.RaumSchiff;

public class Bomber implements RaumSchiff {

    private int laenge = 2;
    private int LebensPunkte = 2;
    private int xKoordinaten;
    private int yKoordinaten;

    @Override
    public int getLaenge() {
        return laenge;
    }

    @Override
    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    @Override
    public int getLebensPunkte() {
        return LebensPunkte;
    }

    @Override
    public void setLebensPunkte(int LebensPunkte) {
        this.LebensPunkte = LebensPunkte;
    }

    @Override
    public int getxKoordinaten() {
        return xKoordinaten;
    }

    @Override
    public void setxKoordinaten(int xKoordinaten) {
        this.xKoordinaten = xKoordinaten;
    }

    @Override
    public int getyKoordinaten() {
        return yKoordinaten;
    }

    @Override
    public void setyKoordinaten(int yKoordinaten) {
        this.yKoordinaten = yKoordinaten;
    }

    @Override
    public void zielenZumSchiffeSetzen() {

    }

    @Override
    public void schiffSetzen() {

    }
}
