package RaumSchiffeVersenken.GUISteuerung;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import static RaumSchiffeVersenken.GUISteuerung.GUIStartFenster.spielerAktiv;


public class GUISpielerwechselFenster implements Initializable {

    private GUIKlangSteuerung guiKlangSteuerung = new GUIKlangSteuerung();

    @FXML
    private VBox vbox;

    @FXML
    private Label aktiverSpielerLabel;

    @FXML
    private void szeneWechsel() {
        try {
            guiKlangSteuerung.knopfDruecken();
            Stage spielefenster = (Stage) vbox.getScene().getWindow();
            Parent quelle = FXMLLoader.load(getClass().getResource("/fxml/spielrundeFenster.fxml"));
            Scene szene2 = new Scene(quelle);
            spielefenster.setScene(szene2);
            szene2.getStylesheets().add("/gestaltung.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param location  Dateipfad
     * @param resources verwendete Ressourcen
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aktiverSpielerLabel.setText("SPIELER " + spielerAktiv + " IST AN DER REIHE!");
    }

    /**
     *
     */
    @FXML
    private void knopfZielen() {
        guiKlangSteuerung.knopfZielen();
    }
}
