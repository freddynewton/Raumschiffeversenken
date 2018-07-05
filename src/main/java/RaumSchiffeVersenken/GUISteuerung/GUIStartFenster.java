package RaumSchiffeVersenken.GUISteuerung;

import RaumSchiffeVersenken.Core.SpielablaufFX;
import RaumSchiffeVersenken.Exception.AbtasterException;
import RaumSchiffeVersenken.Exception.SchiffSetzenException;
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

    static String spielerAktiv = "1";

    static int spieler1Leben = 26;

    static int spieler2Leben = 26;

    private GUIKlangSteuerung guiKlangSteuerung = new GUIKlangSteuerung();

    @FXML
    private VBox vbox;

    @FXML
    private void starteSpiel() {
        try {
            guiKlangSteuerung.knopfDruecken();
            SpielablaufFX sfx = new SpielablaufFX();
            try {
                sfx.SchiffeSetzenAblauf();
            } catch (SchiffSetzenException e) {
                e.printStackTrace();
            }
            Stage spielefenster = (Stage) vbox.getScene().getWindow();
            Parent quelle = FXMLLoader.load(getClass().getResource("/fxml/spielerwechselFenster.fxml"));
            Scene szene2 = new Scene(quelle);
            spielefenster.setScene(szene2);
            szene2.getStylesheets().add("/gestaltung.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void oeffneCredits() {
        try {
            guiKlangSteuerung.knopfDruecken();
            Stage spielefenster = (Stage) vbox.getScene().getWindow();
            Parent quelle = FXMLLoader.load(getClass().getResource("/fxml/creditsFenster.fxml"));
            Scene szene2 = new Scene(quelle);
            spielefenster.setScene(szene2);
            szene2.getStylesheets().add("/gestaltung.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void beendeSpiel() {
        guiKlangSteuerung.knopfDruecken();
        Stage spielefenster = (Stage) vbox.getScene().getWindow();
        spielefenster.close();
    }

    /**
     * @param location  Dateipfad
     * @param resources verwendete Ressourcen
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    
    @FXML
    private void knopfZielen() {
        guiKlangSteuerung.knopfZielen();
    }
}
