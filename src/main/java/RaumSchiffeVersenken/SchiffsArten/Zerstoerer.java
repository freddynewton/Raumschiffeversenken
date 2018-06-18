package RaumSchiffeVersenken.SchiffsArten;

import RaumSchiffeVersenken.Interface_Factory.RaumSchiff;

public class Zerstoerer implements RaumSchiff {

    private int laenge = 5;
    private int lebensPunkte = 5;
    private int xKoordinaten;
    private int yKoordinaten;
    private int schiffsrichtung;

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
        return lebensPunkte;
    }

    @Override
    public void setLebensPunkte(int LebensPunkte) {
        this.lebensPunkte = LebensPunkte;
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

    @Override
    public int getSchiffsrichtung() {
        return 0;
    }

    @Override
    public void setSchiffsrichtung(int schiffsrichtung) {
        this.schiffsrichtung = schiffsrichtung;
    }
}
