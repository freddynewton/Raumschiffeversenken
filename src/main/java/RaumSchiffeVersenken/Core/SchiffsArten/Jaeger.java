package RaumSchiffeVersenken.Core.SchiffsArten;


import RaumSchiffeVersenken.Interface.RaumSchiff;

abstract class Jaeger implements RaumSchiff {

    private int laenge = 1;
    private int LebensPunkte = 1;
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
