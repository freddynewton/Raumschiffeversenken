package RaumSchiffeVersenken.GUISteuerung;

import RaumSchiffeVersenken.Core.SpielablaufFX;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GUIStartFenster implements Initializable {

    public static String spielerAktiv = "1";

    public static int spieler1Leben = 26;

    public static int spieler2Leben = 26;

    @FXML
    private VBox vbox;

    @FXML
    private void starteSpiel() throws IOException {
        try {
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

    @FXML
    private void beendeSpiel() throws IOException {
        Stage spielefenster = (Stage) vbox.getScene().getWindow();
        spielefenster.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SpielablaufFX sfx = new SpielablaufFX();
        sfx.SchiffeSetzenAblauf();
    }

}
