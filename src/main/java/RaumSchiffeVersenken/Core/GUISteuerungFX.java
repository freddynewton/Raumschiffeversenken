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

import static RaumSchiffeVersenken.Core.Spielablauf.Feld_Spieler1;
import static RaumSchiffeVersenken.Core.Spielablauf.Feld_Spieler2;


public class GUISteuerungFX implements Initializable {

    //referentziert GUI-Elemente der FXML-Datei
    @FXML
    private GridPane spielfeld1;

    @FXML
    private GridPane spielfeld2;

    @FXML
    private TextField textAusgabe;

    /**
     * Die initialisierung des Fensters direkt vor dessen Aufrufen, verknüpft das GUI mit der Logik.
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int feldSpalte = 10;
        int feldReihe = 10;

        feldgrafikAktualisieren(feldSpalte, feldReihe, Feld_Spieler1, Feld_Spieler2);

        //starte die Spielablauf-Klasse im Hintergrund
        SpielablaufFX s = new SpielablaufFX();
        s.start(textAusgabe);
        //s.SchiffeSetzenAblauf();
        //s.SchiessenAblauf();
    }

    /**
     * Die Spielfelder werden mit der Feld-Klasse verknüpft und im Spielefenster grafisch dargestellt
     *
     * @param feldSpalte
     * @param feldReihe
     */
    public void feldgrafikAktualisieren(int feldSpalte, int feldReihe, Feld feld, Feld kopieFeld) {

        //die for-Schleifen befüllen beide Spielfelder mit Grafiken
        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                Image feldGrafik = new Image("images/weltraum.png");
                Image raumschiffGrafik = new Image("images/raumschiff.png");
                Image danebenGrafik = new Image("images/daneben.png");
                Image trefferGrafik = new Image("images/treffer.png");

                if (feld.mapGroesse[x][y] == 0) {
                    ImageView grafik = new ImageView();
                    grafik.setFitWidth(24);
                    grafik.setFitHeight(24);
                    grafik.setImage(feldGrafik);
                    spielfeld1.add(grafik, x, y);
                }
                else if (feld.mapGroesse[x][y] == 1) {
                    ImageView grafik = new ImageView();
                    grafik.setFitWidth(24);
                    grafik.setFitHeight(24);
                    grafik.setImage(danebenGrafik);
                    spielfeld1.add(grafik, x, y);
                }
                else if (feld.mapGroesse[x][y] == 5) {
                    ImageView grafik = new ImageView();
                    grafik.setFitWidth(24);
                    grafik.setFitHeight(24);
                    grafik.setImage(raumschiffGrafik);
                    spielfeld1.add(grafik, x, y);
                }
                else if (feld.mapGroesse[x][y] == 6) {
                    ImageView grafik = new ImageView();
                    grafik.setFitWidth(24);
                    grafik.setFitHeight(24);
                    grafik.setImage(trefferGrafik);
                    spielfeld1.add(grafik, x, y);
                }
            }
        }

        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                Image feldGrafik = new Image("images/weltraum.png");
                Image raumschiffGrafik = new Image("images/raumschiff.png");
                Image danebenGrafik = new Image("images/daneben.png");
                Image trefferGrafik = new Image("images/treffer.png");

                if (kopieFeld.mapGroesse[x][y] == 0) {
                    ImageView grafik = new ImageView();
                    grafik.setFitWidth(24);
                    grafik.setFitHeight(24);
                    grafik.setImage(feldGrafik);
                    spielfeld2.add(grafik, x, y);
                }
                else if (kopieFeld.mapGroesse[x][y] == 1) {
                    ImageView grafik = new ImageView();
                    grafik.setFitWidth(24);
                    grafik.setFitHeight(24);
                    grafik.setImage(danebenGrafik);
                    spielfeld2.add(grafik, x, y);
                }
                else if (kopieFeld.mapGroesse[x][y] == 5) {
                    ImageView grafik = new ImageView();
                    grafik.setFitWidth(24);
                    grafik.setFitHeight(24);
                    grafik.setImage(raumschiffGrafik);
                    spielfeld2.add(grafik, x, y);
                }
                else if (kopieFeld.mapGroesse[x][y] == 6) {
                    ImageView grafik = new ImageView();
                    grafik.setFitWidth(24);
                    grafik.setFitHeight(24);
                    grafik.setImage(trefferGrafik);
                    spielfeld2.add(grafik, x, y);
                }
            }
        }
    }

    /**
     * Die Methode steuert die Textausgabe über das TextField-Feld unten im Fenster. Ihr kann Text als String übergeben
     * werden.
     *
     * @param textAusgabeText
     * @param textAusgabe
     */
    public static void textAusgabeSteuerung(String textAusgabeText, TextField textAusgabe) {

        //erstellt ein Textelement für das Textfeld
        Text text1 = new Text(textAusgabeText);
        textAusgabe.setText(textAusgabeText);

    }

}
