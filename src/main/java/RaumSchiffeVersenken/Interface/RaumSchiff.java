package RaumSchiffeVersenken.Interface;

public interface RaumSchiff {

    public static enum RaumschiffsArten {
        JAGER,
        FREGATTE,
        ZERSTOERER,
        KREUZER;

        RaumschiffsArten() {
        }
    }

    public int getLaenge();

    public void setLaenge(int laenge);

    public int getLebensPunkte();

    public void setLebensPunkte(int lebensPunkte);

    public int getxKoordinaten();

    public void setxKoordinaten(int xKoordinaten);

    public int getyKoordinaten();

    public void setyKoordinaten(int yKoordinaten);

    public void zielenZumSchiffeSetzen();

    public void schiffSetzen();
}
