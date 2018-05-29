package RaumSchiffeVersenken.Core;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

import static RaumSchiffeVersenken.Core.Spielablauf.Feld_Spieler1;
import static RaumSchiffeVersenken.Core.Spielablauf.Feld_Spieler2;


public class GUISpielFX implements Initializable {

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
        Image feldGrafik = new Image("images/weltraum.png");
        Image raumschiffGrafik = new Image("images/raumschiff.png");
        Image danebenGrafik = new Image("images/daneben.png");
        Image trefferGrafik = new Image("images/treffer.png");


        //die for-Schleifen befüllen beide Spielfelder mit Grafiken
        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                ImageView grafikFeld1 = new ImageView();
                grafikFeld1.setFitWidth(24);
                grafikFeld1.setFitHeight(24);
                grafikFeld1.setId(""+x+"|"+y);

                grafikFeld1.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        grafikFeld1.setImage(danebenGrafik);
                        System.out.println("Feld: " + grafikFeld1.getId());
                        GUISpielFX.textAusgabeSteuerung("Feld: " + grafikFeld1.getId(), textAusgabe);
                    }
                });

                if (feld.mapGroesse[x][y] == 0) {
                    grafikFeld1.setImage(feldGrafik);
                    spielfeld1.add(grafikFeld1, x, y);
                } else if (feld.mapGroesse[x][y] == 1) {
                    grafikFeld1.setImage(danebenGrafik);
                    spielfeld1.add(grafikFeld1, x, y);
                } else if (feld.mapGroesse[x][y] == 5) {
                    grafikFeld1.setImage(raumschiffGrafik);
                    spielfeld1.add(grafikFeld1, x, y);
                } else if (feld.mapGroesse[x][y] == 6) {
                    grafikFeld1.setImage(trefferGrafik);
                    spielfeld1.add(grafikFeld1, x, y);
                }
            }
        }

        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                ImageView grafikFeld2 = new ImageView();
                grafikFeld2.setFitWidth(24);
                grafikFeld2.setFitHeight(24);
                grafikFeld2.setId(""+x+"|"+y);

                grafikFeld2.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        grafikFeld2.setImage(danebenGrafik);
                        System.out.println("Feld: " + grafikFeld2.getId());
                        GUISpielFX.textAusgabeSteuerung("Feld: " + grafikFeld2.getId(), textAusgabe);
                    }
                });

                if (kopieFeld.mapGroesse[x][y] == 0) {
                    grafikFeld2.setImage(feldGrafik);
                    spielfeld2.add(grafikFeld2, x, y);
                } else if (kopieFeld.mapGroesse[x][y] == 1) {
                    grafikFeld2.setImage(danebenGrafik);
                    spielfeld2.add(grafikFeld2, x, y);
                } else if (kopieFeld.mapGroesse[x][y] == 5) {
                    grafikFeld2.setImage(raumschiffGrafik);
                    spielfeld2.add(grafikFeld2, x, y);
                } else if (kopieFeld.mapGroesse[x][y] == 6) {
                    grafikFeld2.setImage(trefferGrafik);
                    spielfeld2.add(grafikFeld2, x, y);
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
        //Text text1 = new Text(textAusgabeText);
        textAusgabe.setText(textAusgabeText);
    }
}
