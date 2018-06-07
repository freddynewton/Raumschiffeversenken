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

import static RaumSchiffeVersenken.GUISteuerung.GUIStartFenster.spieler1Leben;
import static RaumSchiffeVersenken.GUISteuerung.GUIStartFenster.spieler2Leben;


public class GUISpielendeFenster implements Initializable {

    @FXML
    private VBox vbox;

    @FXML
    private Label siegesNachricht;

    @FXML
    private void spielEnde() throws IOException {
        Stage spielefenster = (Stage) vbox.getScene().getWindow();
        spielefenster.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (spieler1Leben == 0) {
            siegesNachricht.setText("Spieler 2 hat gewonnen!");
        } else if (spieler2Leben == 0) {
            siegesNachricht.setText("Spieler 1 hat gewonnen!");
        }
    }
}
