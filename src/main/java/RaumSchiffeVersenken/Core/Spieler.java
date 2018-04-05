package RaumSchiffeVersenken.Core;

import java.util.ArrayList;

public class Spieler {
    protected String Name = "Admiral Habermann";


    public void schiffeListe() {
        ArrayList<RaumSchiffFactory> GesamtSchiffeList = new ArrayList<RaumSchiffFactory>();
        GesamtSchiffeList.add(new RaumSchiffFactory(4, 4, 3, 2));
        GesamtSchiffeList.add(new RaumSchiffFactory(3, 3, 3, 2));

    }
}
