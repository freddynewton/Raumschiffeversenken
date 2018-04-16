package RaumSchiffeVersenken.Core.SchiffsArten;

import RaumSchiffeVersenken.Interface.RaumSchiff;

abstract class Zerstoerer implements RaumSchiff {

    private int laenge = 4;
    private int LebensPunkte = 4;
    private int xKoordinaten;
    private int yKoordinaten;


    public int getLaenge() {
        return laenge;
    }

    ;

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    ;

    public int getLebensPunkte() {
        return LebensPunkte;
    }

    ;

    public void setLebensPunkte(int LebensPunkte) {
        this.LebensPunkte = LebensPunkte;
    }

    ;


    public void setxKoordinaten(int xKoordinaten) {
        this.xKoordinaten = xKoordinaten;
    }

    ;


    public void setyKoordinaten(int yKoordinaten) {
        this.yKoordinaten = yKoordinaten;
    }

    ;
}
