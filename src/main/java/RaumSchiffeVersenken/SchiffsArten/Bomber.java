package RaumSchiffeVersenken.SchiffsArten;

import RaumSchiffeVersenken.Interface_Factory.RaumSchiff;

public class Bomber implements RaumSchiff {

    private int laenge = 3;
    private int LebensPunkte = 3;
    private int xKoordinaten;
    private int yKoordinaten;
    private int Schiffsrichtung;

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

    @Override
    public int getSchiffsrichtung() {
        return Schiffsrichtung;
    }

    @Override
    public void setSchiffsrichtung(int schiffsrichtung) {
        Schiffsrichtung = schiffsrichtung;
    }
}
