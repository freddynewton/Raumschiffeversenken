package RaumSchiffeVersenken.Core;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
        Parent quelle = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/start.fxml"));
        Scene szene1 = new Scene(quelle);
        szene1.getStylesheets().add("gestaltung.css");
        spielefenster.setScene(szene1);
        spielefenster.show();
        spielefenster.setFullScreen(true);
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
