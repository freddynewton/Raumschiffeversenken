package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.Interface.RaumSchiff;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

        // Jaeger erstellen 1 Lebenspunkt
        RaumSchiff Jaeger1 = SchiffFactory.getRaumschiff("1");

        // Bomber Erstellen 2 Lebenspunkte
        RaumSchiff Bomber1 = SchiffFactory.getRaumschiff("2");

        // Fregatte erstellen 4 Lebenspunkte
        RaumSchiff Fregatte1 = SchiffFactory.getRaumschiff("4");

        // Zerstoerer erstellen 5 Lebenspunkte
        RaumSchiff Zerstoerer1 = SchiffFactory.getRaumschiff("5");

        System.out.println(Feld1.toString());

        Feld1.zielenZumSchiffeSetzen(Jaeger1.getLaenge());
        System.out.println(Feld1.toString());

        Feld1.zielenZumSchiffeSetzen(Zerstoerer1.getLaenge());
        System.out.println(Feld1.toString());

        Feld1.zielenZumSchiessen();
        System.out.println(Feld1.toString());
        System.out.println("\n jetzt kommt das Feld mit Kriegsnebel: \n\n");
        Feld1_1.Kriegsnebel();
        Feld1_1.toString();




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
