package RaumSchiffeVersenken;

import java.util.ArrayList;

public class Spieler {
    protected String Name = "Admiral Habermann";


    public void schiffeSetzen() {
        ArrayList<RaumSchiff> GesamtSchiffeList = new ArrayList<RaumSchiff>();
        GesamtSchiffeList.add(new RaumSchiff(4, 4, 3, 2));
    }
}
