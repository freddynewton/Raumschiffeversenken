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


public class SpielSystemMainFX extends Application {

    /**
     * Die Szene im Spielefenster wird hier mit der FXML-Datei und der CSS-Datei verknüpft.
     *
     * @param spielefenster
     * @throws IOException
     */
    @Override
    public void start(Stage spielefenster) throws IOException {
        Parent quelle = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/startFenster.fxml"));
        Scene szene1 = new Scene(quelle);
        szene1.getStylesheets().add("gestaltung.css");
        spielefenster.setScene(szene1);
        spielefenster.show();
        //spielefenster.setFullScreen(true);

        //spielt die titelmusik in einer Endlosschleife!
        String musicFile = "src/main/resources/musik/titelmusik.mp3";
        Media titelmusik = new Media(new File(musicFile).toURI().toString());
        AudioClip musikSpieler = new AudioClip(titelmusik.getSource());
        musikSpieler.setCycleCount(AudioClip.INDEFINITE);
        musikSpieler.play();
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
