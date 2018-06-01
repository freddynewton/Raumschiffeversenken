package RaumSchiffeVersenken.Core;

import javafx.scene.control.Label;


public class SpielablaufFX {

    int derzeitigeSchiffslänge = 0;

    Feld Feld_Spieler1 = new Feld(10, 10);
    Feld Feld_Spieler2 = new Feld(10, 10);


    //Die Spieleinstruktionen werden im Textfeld des GUI über eine Methode in der GUISpielrundeFenster ausgegeben
    public String start(Label textAusgabe) {

        GUISpielrundeFenster.textAusgabeSteuerung("Ziele auf ein Feld!", textAusgabe);

        return "Start";
    }





}
