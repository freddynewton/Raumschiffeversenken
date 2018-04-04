package RaumSchiffeVersenken;


public class RaumSchiff {
    public int laenge;
    public int Model;
    public int xKoordinaten;
    public int yKoordinaten;

    /**
     * @param laenge       Das beschreibt mit dem Model die Größe und dementsprechend dann
     *                     auch das Model.
     * @param model        1 = Jäger
     *                     2 = Frigatte
     *                     4 = Zerstörer
     *                     5 = Kreuzer
     * @param xKoordinaten
     * @param yKoordinaten
     */
    public RaumSchiff(int laenge, int model, int xKoordinaten, int yKoordinaten) {
        this.laenge = laenge;
        this.Model = model;
        this.xKoordinaten = xKoordinaten;
        this.yKoordinaten = yKoordinaten;
    }
/*
   Beispiel wie man ein Schiff erstellt mit dem Constructor

    RaumSchiff zerstörer = new RaumSchiff(4,4, 3, 10);
     */


    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public int getModel() {
        return Model;
    }

    public void setModel(int model) {
        Model = model;
    }

    public int getxKoordinaten() {
        return xKoordinaten;
    }

    public void setxKoordinaten(int xKoordinaten) {
        this.xKoordinaten = xKoordinaten;
    }

    public int getyKoordinaten() {
        return yKoordinaten;
    }

    public void setyKoordinaten(int yKoordinaten) {
        this.yKoordinaten = yKoordinaten;
    }
}
