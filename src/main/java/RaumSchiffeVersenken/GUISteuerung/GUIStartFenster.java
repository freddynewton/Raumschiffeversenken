package RaumSchiffeVersenken.GUISteuerung;

import RaumSchiffeVersenken.Core.SpielablaufFX;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GUIStartFenster implements Initializable {

    public static String spielerAktiv = "1";

    public static int spieler1Leben = 26;

    public static int spieler2Leben = 26;

    @FXML
    private VBox vbox;

    /**
     * @throws IOException
     */
    @FXML
    private void starteSpiel() throws IOException {
        try {
            SpielablaufFX sfx = new SpielablaufFX();
            sfx.SchiffeSetzenAblauf();
            Stage spielefenster = (Stage) vbox.getScene().getWindow();
            Parent quelle = FXMLLoader.load(getClass().getResource("/fxml/spielerwechselFenster.fxml"));
            Scene szene2 = new Scene(quelle);
            spielefenster.setScene(szene2);
            szene2.getStylesheets().add("/gestaltung.css");
            spielefenster.setFullScreen(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException
     */
    @FXML
    private void oeffneCredits() throws IOException {
        try {
            Stage spielefenster = (Stage) vbox.getScene().getWindow();
            Parent quelle = FXMLLoader.load(getClass().getResource("/fxml/creditsFenster.fxml"));
            Scene szene2 = new Scene(quelle);
            spielefenster.setScene(szene2);
            szene2.getStylesheets().add("/gestaltung.css");
            spielefenster.setFullScreen(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException
     */
    @FXML
    private void beendeSpiel() throws IOException {
        Stage spielefenster = (Stage) vbox.getScene().getWindow();
        spielefenster.close();
    }

    /**
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
