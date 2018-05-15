package RaumSchiffeVersenken.Core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class SpielSystemMainFX extends Application{

    /**
     * Die Szene im Spielefenster wird hier mit der FXML-Datei und der CSS-Datei verknüpft.
     *
     * @param spielefenster
     * @throws IOException
     */
    @Override
    public void start(Stage spielefenster) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("gui.fxml"));
        Parent fenster = loader.load();
        Scene szene1 = new Scene(fenster);
        szene1.getStylesheets().add("gestaltung.css");

        spielefenster.setScene(szene1);
        spielefenster.show();
     }

    /**
     * Die Main-Methode ruft das Fenster (Stage) auf, nachdem es initialisiert wurde.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
