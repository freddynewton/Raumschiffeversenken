package RaumSchiffeVersenken.Core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


/**
 * <!DOCTYPE html>
 * <p>Die Klasse SpielSystemMainFX definiert das Startfenster (Stage) und ruft es auf. Als Main-Klasse ist es die erste
 * Klasse die gestartet wird und die über JavaFX definierte Szene in der erstellten Stage einstellt.</p>
 *
 * <p>Die Reihenfolge der JavaFX Benutzeroberfläche bei der Anlage fnktioniert wie folgt:</p>
 * <ul>
 * <li>die SpieleSystemMainFX-Klasse erbt von Application</li>
 * <li>die Start-Methode wird überschrieben</li>
 * <li>die Stage wird über den FXML Loader festgelegt</li>
 * <li>der Stage wird eine Szene hinzugefügt</li>
 * <li>die Szene wird mit einer .css-Datei verknüpft</li>
 * <li>die Szene wird gesetzt und schließlich die Stage gestartet</li>
 * </ul>
 */
public class SpielSystemMainFX extends Application {

    /**
     * <p>Die Szene des Startinterfaces im Spielefenster wird hier mit der FXML-Datei und der CSS-Datei verknüpft und
     * aufgerufen. Im zweiten Codeblock wird die Titelmusik über einen AudioClip in eier Endlosschleife abgespielt.</p>
     *
     * @param spielefenster ist das Fenster (Stage) in dem das Spiel aufgerufen wird
     * @throws IOException für die Fehler-Bearbeitung
     */
    @Override
    public void start(Stage spielefenster) throws IOException {
        Parent quelle = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml/startFenster.fxml")));
        Scene szene1 = new Scene(quelle);
        szene1.getStylesheets().add("gestaltung.css");
        spielefenster.setScene(szene1);
        spielefenster.show();

        String musicFile = "src/main/resources/musik/titelmusik.mp3";
        Media titelmusik = new Media(new File(musicFile).toURI().toString());
        AudioClip musikSpieler = new AudioClip(titelmusik.getSource());
        musikSpieler.setCycleCount(AudioClip.INDEFINITE);
        musikSpieler.play();
    }

    /**
     * <p>Die Main-Methode ruft das Fenster (Stage) auf, nachdem es initialisiert wurde.</p>
     *
     * @param args als String
     */
    public static void main(String[] args) {
        launch(args);
    }
}
