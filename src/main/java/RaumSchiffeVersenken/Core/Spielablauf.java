package RaumSchiffeVersenken.Core;


import RaumSchiffeVersenken.Interface.RaumSchiff;


import java.util.HashMap;
import java.util.Objects;
import RaumSchiffeVersenken.Core.SchiffsArten.Jaeger;
import RaumSchiffeVersenken.Interface.RaumSchiff;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;

public class Spielablauf {

    int DerzeitigeSchiffslänge = 0;
    Feld Feld_Spieler1 = new Feld(10, 10);
    Feld Feld_Spieler2 = new Feld(10, 10);


    public String start() {
        System.out.println("Los gehts!");
        System.out.println("Spieler 1 beginnt:\n");

        Feld_Spieler1.toString();

        System.out.println("\n");

        Feld_Spieler2.toString();

        System.out.println("\nSetze jetzt deine Schiffe im oberen Feld.");

        System.out.println("Schiffe zu setzen:\n" + "5 Jäger mit der Länge 1\n" + "4 Bomber mit der Länge 2\n" +
                "2 Fregatten mit der Länge 4\n" + "1 Zerstörer mit der Länge 5\n");

        return "Start";
    }


    public void SchiffeSetzenAblauf() {

        HashMap<Integer, RaumSchiff> SchiffsMap = new HashMap<>();

        // Jaeger erstellen mit 1 Lebenspunkt
        SchiffsMap.put(1, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        SchiffsMap.put(2, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        SchiffsMap.put(3, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        SchiffsMap.put(4, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        SchiffsMap.put(5, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));

        //Bomber erstellen mit 2 Lebenspunkten
        SchiffsMap.put(6, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        SchiffsMap.put(7, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        SchiffsMap.put(8, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        SchiffsMap.put(9, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));

        //Fregatte erstellen mit 4 Lebenspunkten
        SchiffsMap.put(10, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));
        SchiffsMap.put(11, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));

        //Zerstörer erstellen mit 5 Lebenspunkten
        SchiffsMap.put(12, Objects.requireNonNull(SchiffFactory.getRaumschiff("5")));

        for (int i = 1; i <= 12; i++) {
            RaumSchiff schiff = SchiffsMap.get(i);
            DerzeitigeSchiffslänge = schiff.getLaenge();
            derzeitigerSchiffSetzer(i, SchiffsMap);
            Feld_Spieler1.zielenZumSchiffeSetzen(DerzeitigeSchiffslänge);
            Feld_Spieler1.toString();

        }

        Feld_Spieler1.toString();
        Feld_Spieler1.BereitAbfrage(Feld_Spieler1);



        for (int i = 1; i <= 12; i++) {
            DerzeitigeSchiffslänge = SchiffsMap.get(i).getLaenge();
            derzeitigerSchiffSetzer(i, SchiffsMap);
            Feld_Spieler2.zielenZumSchiffeSetzen(DerzeitigeSchiffslänge);
            Feld_Spieler2.toString();
        }

        Feld_Spieler2.toString();
        Feld_Spieler2.BereitAbfrage(Feld_Spieler2);
    }


    public void SchiessenAblauf() {

        Feld Kopie_Feld_Spieler1 = new Feld(10, 10);
        Feld Kopie_Feld_Spieler2 = new Feld(10, 10);
        Kopie_Feld_Spieler1 = Feld_Spieler1;
        Kopie_Feld_Spieler2 = Feld_Spieler2;
        Kopie_Feld_Spieler1.Kriegsnebel();
        Kopie_Feld_Spieler2.Kriegsnebel();

        for (int i = 0; i <= 99; i++) {
            System.out.println("Dein Feld:\n");
            Feld_Spieler1.toString();
            System.out.println("\nDas Gegnerfeld:\n");
            Kopie_Feld_Spieler2.toString();
            System.out.println("\nSpieler 1 ist dran mit Schiessen\n");
            Feld_Spieler2.zielenZumSchiessen();
            Kopie_Feld_Spieler2 = Feld_Spieler2;
            Kopie_Feld_Spieler2.Kriegsnebel();


            Feld_Spieler1.BereitAbfrage(Kopie_Feld_Spieler2);


            System.out.println("Dein Feld:\n");
            Feld_Spieler2.toString();
            System.out.println("\nDas Gegnerfeld:\n");
            Kopie_Feld_Spieler1.toString();
            System.out.println("\nSpieler 2 ist dran mit Schiessen\n");
            Feld_Spieler1.zielenZumSchiessen();
            Kopie_Feld_Spieler1 = Feld_Spieler1;
            Kopie_Feld_Spieler1.Kriegsnebel();


            Feld_Spieler2.BereitAbfrage(Kopie_Feld_Spieler1);


            Feld_Spieler2.TrefferZaehler(Feld_Spieler2, 2);
            Feld_Spieler1.TrefferZaehler(Feld_Spieler1, 1);
        }
    }

    public String derzeitigerSchiffSetzer(int i, HashMap map) {
        RaumSchiff schiff = (RaumSchiff) map.get(i);
        DerzeitigeSchiffslänge = schiff.getLaenge();
        String DerzeitigerSchiffsName = "";

        if (DerzeitigeSchiffslänge == 1) {
            DerzeitigerSchiffsName = "Jäger";
        } else if (DerzeitigeSchiffslänge == 2) {
            DerzeitigerSchiffsName = "Bomber";
        } else if (DerzeitigeSchiffslänge == 4) {
            DerzeitigerSchiffsName = "Fregatte";
        } else if (DerzeitigeSchiffslänge == 5) {
            DerzeitigerSchiffsName = "Zertörer";
        }

        System.out.println("Derzeitiger Schiffstyp: " + DerzeitigerSchiffsName + "\n" +
                "Es hat die Länge: " + DerzeitigeSchiffslänge + "\n");
        return "";
    }

}
