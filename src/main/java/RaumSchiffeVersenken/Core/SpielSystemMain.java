package RaumSchiffeVersenken.Core;


import RaumSchiffeVersenken.Core.SchiffsArten.Jaeger;
import RaumSchiffeVersenken.Interface.RaumSchiff;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

import static javafx.application.Application.launch;

public class SpielSystemMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample.fxml"));
        primaryStage.setTitle("Raumschiffeversenken");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

        // Spieler 1 Spielfeld erstellt
        Feld Feld1 = new Feld(10, 10);
        Feld Feld1_1 = Feld1;

        //Spieler 2 Spielfeld erstellt
        Feld Feld2 = new Feld(10, 10);
        Feld Feld2_1 = Feld2;


        HashMap<Integer, RaumSchiff> HashHangar = new HashMap<>();

        // Jaeger erstellen mit 1 Lebenspunkt
        HashHangar.put(1, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        HashHangar.put(2, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        HashHangar.put(3, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        HashHangar.put(4, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        HashHangar.put(5, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));

        //Bomber erstellen mit 2 Lebenspunkten
        HashHangar.put(6, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        HashHangar.put(7, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        HashHangar.put(8, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        HashHangar.put(9, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));

        //Fregatte erstellen mit 4 Lebenspunkten
        HashHangar.put(10, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));
        HashHangar.put(11, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));

        //Zerstörer erstellen mit 5 Lebenspunkten
        HashHangar.put(12, Objects.requireNonNull(SchiffFactory.getRaumschiff("5")));

        //Zur Berechnung um die Treffer zu Zählen wer der Gewinner ist.
        int CounterSpieler1 = 0;
        int CounterSpieler2 = 0;
        int BenötigteTrefferZumGewinnen = 26;

        int DerzeitigeSchiffslänge = 0;


        /**
         * SchiffeSetzen Spieler 1
         */
        for (int i = 1; i == 12; i++) {
            DerzeitigeSchiffslänge = HashHangar.get(i).getLaenge();
            System.out.println(Feld1.toString());
            Feld1.zielenZumSchiffeSetzen(DerzeitigeSchiffslänge);
        }
        Feld1.BereitAbfrage(Feld1);

        /**
         * SchiffeSetzen Spieler 2
         */
        for (int i = 1; i == 12; i++) {
            DerzeitigeSchiffslänge = HashHangar.get(i).getLaenge();
            System.out.println(Feld2.toString());
            Feld2.zielenZumSchiffeSetzen(DerzeitigeSchiffslänge);
        }
        Feld2.BereitAbfrage(Feld2);









        // TODO: 20.04.2018 Versuchen die 2. Map zu zeigen mit einem Fog of War



       /*for (int i = 0; i < 99; i++) {
            Feld1.zielenZumSchiessen();
            System.out.println("\n");
            System.out.println(Feld1.toString());
        }
        */
        // zweites Feld bla bla

        Feld2.zielenZumSchiessen();

        System.out.println("\n");
        System.out.println(Feld2.toString());


    }
}
