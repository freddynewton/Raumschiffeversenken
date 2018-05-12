package RaumSchiffeVersenken.Core;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.DoubleToLongFunction;


public class GUISteuerung implements Initializable {

    //referentziert GUI-Elemente der FXML-Datei
    @FXML
    private GridPane spielfeld1;

    @FXML
    private GridPane spielfeld2;

    @FXML
    private TextFlow textAusgabe;

    //Initialisierung des Fensters direkt nach dessen Start führt GUI-Methoden aus
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int feldSpalte = 10;
        int feldReihe = 10;

        feldgrafikAktualisieren(feldSpalte, feldReihe);
        //GUISteuerung.textAusgabeSteuerung("Geht los!", textAusgabe);

        //starte die Spielablauf-Klasse im Hintergrund
        SpielablaufFX s = new SpielablaufFX();
        s.start(textAusgabe);
        //s.SchiffeSetzenAblauf();
        //s.SchiessenAblauf();
    }

    public void feldgrafikAktualisieren(int feldSpalte, int feldReihe) {

        //die for-Schleifen befüllen beide Spielfelder mit Grafiken
        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                Image feldGrafik = new Image("images/weltraum.png");
                ImageView grafik = new ImageView();
                grafik.setFitWidth(24);
                grafik.setFitHeight(24);
                grafik.setImage(feldGrafik);
                spielfeld1.add(grafik, x, y);
            }
        }

        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                Image feldGrafik = new Image("images/weltraum.png");
                ImageView grafik = new ImageView();
                grafik.setFitWidth(24);
                grafik.setFitHeight(24);
                grafik.setImage(feldGrafik);
                spielfeld2.add(grafik, x, y);
            }
        }
    }

    public static void textAusgabeSteuerung(String textAusgabeText, TextFlow textAusgabe) {

        //erstellt ein Textelement für das Textfeld
        Text text1 = new Text(textAusgabeText);

        //erstellt Liste der Textfeld-Elemente
        ObservableList liste = textAusgabe.getChildren();

        //Textkoeper wird dem Textfeld hizugefügt
        liste.addAll(text1);

    }

}
