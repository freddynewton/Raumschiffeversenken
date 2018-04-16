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

    public void setLaenge();

    public int getLebensPunkte();

    public void setLebensPunkte();

    public int getxKoordinaten();

    public void setxKoordinaten();

    public int getyKoordinaten();

    public void setyKoordinaten();

    public void zielenZumSchiffeSetzen();

    public void schiffSetzen();
}
