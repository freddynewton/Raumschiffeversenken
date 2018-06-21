package RaumSchiffeVersenken.GUISteuerung;

import RaumSchiffeVersenken.Core.FeldFX;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static RaumSchiffeVersenken.Core.SpielablaufFX.feldSpieler1;
import static RaumSchiffeVersenken.Core.SpielablaufFX.feldSpieler2;
import static RaumSchiffeVersenken.GUISteuerung.GUIStartFenster.spielerAktiv;
import static RaumSchiffeVersenken.GUISteuerung.GUIStartFenster.spieler1Leben;
import static RaumSchiffeVersenken.GUISteuerung.GUIStartFenster.spieler2Leben;


public class GUISpielrundeFenster implements Initializable {

    private static final Logger log = LogManager.getLogger(GUISpielrundeFenster.class);
    private boolean spielfeldAktiv = true;
    private GUIKlangSteuerung guiKlangSteuerung = new GUIKlangSteuerung();

    @FXML
    private GridPane spielfeld1;

    @FXML
    private GridPane spielfeld2;

    @FXML
    private Label textAusgabe;

    @FXML
    private VBox spielefensterVBox;

    /**
     *
     */
    @FXML
    private void szeneWechsel() {
        try {
            if (!spielfeldAktiv) {
                guiKlangSteuerung.knopfDruecken();

                if (spielerAktiv.equals("1")) {
                    spielerAktiv = "2";
                } else {
                    spielerAktiv = "1";
                }

                if (spieler1Leben == 0 | spieler2Leben == 0) {
                    Stage spielefenster = (Stage) spielefensterVBox.getScene().getWindow();
                    Parent quelle = FXMLLoader.load(getClass().getResource("/fxml/spielendeFenster.fxml"));
                    Scene szene2 = new Scene(quelle);
                    spielefenster.setScene(szene2);
                    szene2.getStylesheets().add("/gestaltung.css");
                } else {
                    Stage spielefenster = (Stage) spielefensterVBox.getScene().getWindow();
                    Parent quelle = FXMLLoader.load(getClass().getResource("/fxml/spielerwechselFenster.fxml"));
                    Scene szene2 = new Scene(quelle);
                    spielefenster.setScene(szene2);
                    szene2.getStylesheets().add("/gestaltung.css");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Die initialisierung des Fensters direkt vor dessen Aufrufen, verknüpft das GUI mit der Logik.
     *
     * @param location  ist der uebergebene Pfad
     * @param resources sind die benoetigten Ressourcen
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int feldSpalte = 10;
        int feldReihe = 10;

        if (spielerAktiv.equals("1")) {
            feldgrafikAktualisieren(feldSpalte, feldReihe, feldSpieler2, feldSpieler1);
        } else {
            feldgrafikAktualisieren(feldSpalte, feldReihe, feldSpieler1, feldSpieler2);
        }

        GUISpielrundeFenster.textAusgabeSteuerung("ZIELE AUF EIN FELD!", textAusgabe);
    }

    /**
     * Die Spielfelder werden mit der Feld-Klasse verknüpft und im Spielefenster grafisch dargestellt
     *
     * @param feldSpalte vertikale Array-Richtung
     * @param feldReihe  horizontale Array-Richtung
     */
    private void feldgrafikAktualisieren(int feldSpalte, int feldReihe, FeldFX grossesFeld, FeldFX kleinesFeld) {
        spielfeld1.getChildren().clear();
        spielfeld2.getChildren().clear();

        Image feldGrafikGross = new Image("bilder/weltraumGrafikGroß.png");
        Image danebenGrafikGross = new Image("bilder/danebenGrafikGroß.png");
        Image trefferGrafikGross = new Image("bilder/trefferGrafikGroß.png");
        Image feldGrafik = new Image("bilder/weltraumGrafik.png");
        Image raumschiffGrafik = new Image("bilder/raumschiffGrafik.png");
        Image danebenGrafik = new Image("bilder/danebenGrafik.png");
        Image trefferGrafik = new Image("bilder/trefferGrafik.png");

        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                ImageView grafikFeld1 = new ImageView();

                if (spielfeldAktiv) {
                    klickevent(grossesFeld, grafikFeld1, danebenGrafikGross, trefferGrafikGross, feldSpalte, feldReihe);
                }

                arrayZeichner(spielfeld1, grossesFeld, grafikFeld1, feldGrafikGross, danebenGrafikGross, feldGrafikGross, trefferGrafikGross, x, y, 50, 50);
            }
        }

        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                ImageView grafikFeld2 = new ImageView();

                arrayZeichner(spielfeld2, kleinesFeld, grafikFeld2, feldGrafik, danebenGrafik, raumschiffGrafik, trefferGrafik, x, y, 15, 15);
            }
        }
    }

    /**
     * @param spielfeld        GridPane Spielfeld
     * @param feld             Objekt der Feld-Klasse
     * @param grafikFeld       ImageView Element
     * @param feldGrafik       Grafik in der GridPane-Zelle
     * @param danebenGrafik    Grafik von Daneben-Schuss
     * @param raumschiffGrafik Grafik vom Raumschiff
     * @param trefferGrafik    Grafik von einem Treffer
     * @param x                X-Koordinate
     * @param y                Y-Koordinate
     * @param hoehe            Hoehe der Grafik
     * @param breite           Breite der Grafik
     */
    private void arrayZeichner(GridPane spielfeld, FeldFX feld, ImageView grafikFeld, Image feldGrafik, Image danebenGrafik, Image raumschiffGrafik, Image trefferGrafik, int x, int y, int hoehe, int breite) {
        grafikFeld.setId("" + x + y);
        grafikFeld.setFitHeight(hoehe);
        grafikFeld.setFitWidth(breite);

        if (feld.mapGroesse[x][y] == 0) {
            grafikFeld.setImage(feldGrafik);
            spielfeld.add(grafikFeld, x, y);
        } else if (feld.mapGroesse[x][y] == 1) {
            grafikFeld.setImage(danebenGrafik);
            spielfeld.add(grafikFeld, x, y);
        } else if (feld.mapGroesse[x][y] == 5) {
            grafikFeld.setImage(raumschiffGrafik);
            spielfeld.add(grafikFeld, x, y);
        } else if (feld.mapGroesse[x][y] == 6) {
            grafikFeld.setImage(trefferGrafik);
            spielfeld.add(grafikFeld, x, y);
        }
    }

    /**
     * Die Methode steuert die Textausgabe über das TextField-Feld unten im Fenster. Ihr kann Text als String übergeben
     * werden.
     *
     * @param textAusgabeText der ausgebene Text
     * @param textAusgabe     das zum Text gehoerige Label
     */
    public static void textAusgabeSteuerung(String textAusgabeText, Label textAusgabe) {
        textAusgabe.setText(textAusgabeText);
    }

    /**
     * Dieser Event-Handler beinhalted die Funktionen des Spielfeldes.
     *
     * @param feld               das uebergebene Objekt des Spielfeldes
     * @param grafikFeld1        die Grafik in der GridPane-Zelle
     * @param danebenGrafikGross die Grafik fuer das Daneben-Schiessen
     * @param trefferGrafikGross die GRafik fuer den Treffer
     * @param feldSpalte         vertikale Array-Richtung
     * @param feldReihe          horizontale Array-Richtung
     */
    private void klickevent(FeldFX feld, ImageView grafikFeld1, Image danebenGrafikGross, Image trefferGrafikGross, int feldSpalte, int feldReihe) {
        grafikFeld1.setOnMouseClicked(event -> {
            if (feld.mapGroesse[Character.getNumericValue(grafikFeld1.getId().charAt(0))][Character.getNumericValue(grafikFeld1.getId().charAt(1))] == 0) {
                grafikFeld1.setImage(danebenGrafikGross);
                feld.mapGroesse[Character.getNumericValue(grafikFeld1.getId().charAt(0))][Character.getNumericValue(grafikFeld1.getId().charAt(1))] = 1;

                GUISpielrundeFenster.textAusgabeSteuerung("DANEBEN!", textAusgabe);

                guiKlangSteuerung.blaster();

                spielfeldAktiv = false;

                log.info("Spieler " + spielerAktiv + " Schuss auf: " + Character.getNumericValue(grafikFeld1.getId().charAt(0)) + "|" + Character.getNumericValue(grafikFeld1.getId().charAt(1)) + ", Ergebnis: Daneben!");

                if (spielerAktiv.equals("1")) {
                    feldgrafikAktualisieren(feldSpalte, feldReihe, feldSpieler2, feldSpieler1);
                } else {
                    feldgrafikAktualisieren(feldSpalte, feldReihe, feldSpieler1, feldSpieler2);
                }
            } else if (feld.mapGroesse[Character.getNumericValue(grafikFeld1.getId().charAt(0))][Character.getNumericValue(grafikFeld1.getId().charAt(1))] == 5) {
                grafikFeld1.setImage(trefferGrafikGross);
                feld.mapGroesse[Character.getNumericValue(grafikFeld1.getId().charAt(0))][Character.getNumericValue(grafikFeld1.getId().charAt(1))] = 6;
                GUISpielrundeFenster.textAusgabeSteuerung("TREFFER!", textAusgabe);

                guiKlangSteuerung.blaster();

                guiKlangSteuerung.explosion();

                schuetteln(spielfeld1);

                log.info("Spieler " + spielerAktiv + " Schuss auf: " + Character.getNumericValue(grafikFeld1.getId().charAt(0)) + "|" + Character.getNumericValue(grafikFeld1.getId().charAt(1)) + ", Ergebnis: Treffer!");

                if (spielerAktiv.equals("1")) {
                    feldgrafikAktualisieren(feldSpalte, feldReihe, feldSpieler2, feldSpieler1);
                    spieler2Leben -= 1;
                } else {
                    feldgrafikAktualisieren(feldSpalte, feldReihe, feldSpieler1, feldSpieler2);
                    spieler1Leben -= 1;
                }
            } else {
                GUISpielrundeFenster.textAusgabeSteuerung("NICHT MÖGLICH!", textAusgabe);
            }
        });
    }

    private static TranslateTransition tt;

    /**
     * @param node ist das Kind-Element
     */
    private static void schuetteln(Node node) {
        if (tt == null || tt.getNode() != node) {
            tt = new TranslateTransition(Duration.millis(50), node);
        }
        tt.setByX(10f);
        tt.setCycleCount(2);
        tt.setAutoReverse(true);
        if (tt.getStatus() == Animation.Status.STOPPED) {
            tt.playFromStart();
        }
    }

    /**
     *
     */
    @FXML
    private void knopfZielen() {
        guiKlangSteuerung.knopfZielen();
    }
}
