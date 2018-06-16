package RaumSchiffeVersenken.GUISteuerung;

import RaumSchiffeVersenken.Core.FeldFX;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static RaumSchiffeVersenken.Core.SpielablaufFX.Feld_Spieler1;
import static RaumSchiffeVersenken.Core.SpielablaufFX.Feld_Spieler2;
import static RaumSchiffeVersenken.GUISteuerung.GUIStartFenster.spielerAktiv;
import static RaumSchiffeVersenken.GUISteuerung.GUIStartFenster.spieler1Leben;
import static RaumSchiffeVersenken.GUISteuerung.GUIStartFenster.spieler2Leben;


public class GUISpielrundeFenster implements Initializable {
    // TODO: 16.06.2018 Logger-Ausgabe bei Schießen
    private static final Logger log = LogManager.getLogger(GUISpielrundeFenster.class);

    private boolean spielfeldAktiv = true;

    GUIKlangSteuerung guiKlangSteuerung = new GUIKlangSteuerung();

    @FXML
    private GridPane spielfeld1;

    @FXML
    private GridPane spielfeld2;

    @FXML
    private Label textAusgabe;

    @FXML
    private VBox spielefensterVBox;

    /**
     * @throws IOException
     */
    @FXML
    private void szeneWechsel() throws IOException {
        try {
            if (!spielfeldAktiv) {
                guiKlangSteuerung.knopfDruecken();

                if (spielerAktiv == "1") {
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
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int feldSpalte = 10;
        int feldReihe = 10;

        if (spielerAktiv == "1") {
            feldgrafikAktualisieren(feldSpalte, feldReihe, Feld_Spieler2, Feld_Spieler1);
        } else {
            feldgrafikAktualisieren(feldSpalte, feldReihe, Feld_Spieler1, Feld_Spieler2);
        }

        GUISpielrundeFenster.textAusgabeSteuerung("ZIELE AUF EIN FELD!", textAusgabe);
    }

    /**
     * Die Spielfelder werden mit der Feld-Klasse verknüpft und im Spielefenster grafisch dargestellt
     *
     * @param feldSpalte
     * @param feldReihe
     */
    public void feldgrafikAktualisieren(int feldSpalte, int feldReihe, FeldFX großesFeld, FeldFX kleinesFeld) {
        spielfeld1.getChildren().clear();
        spielfeld2.getChildren().clear();

        Image feldGrafikGroß = new Image("bilder/weltraumGrafikGroß.png");
        Image danebenGrafikGroß = new Image("bilder/danebenGrafikGroß.png");
        Image trefferGrafikGroß = new Image("bilder/trefferGrafikGroß.png");
        Image feldGrafik = new Image("bilder/weltraumGrafik.png");
        Image raumschiffGrafik = new Image("bilder/raumschiffGrafik.png");
        Image danebenGrafik = new Image("bilder/danebenGrafik.png");
        Image trefferGrafik = new Image("bilder/trefferGrafik.png");

        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                ImageView grafikFeld1 = new ImageView();

                if (spielfeldAktiv) {
                    klickevent(großesFeld, grafikFeld1, danebenGrafikGroß, trefferGrafikGroß, feldSpalte, feldReihe);
                }

                arrayZeichner(spielfeld1, großesFeld, grafikFeld1, feldGrafikGroß, danebenGrafikGroß, feldGrafikGroß, trefferGrafikGroß, x, y, 50, 50);
            }
        }

        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                ImageView grafikFeld2 = new ImageView();

                arrayZeichner(spielfeld2, kleinesFeld, grafikFeld2, feldGrafik, danebenGrafik, raumschiffGrafik, trefferGrafik, x, y, 15, 15);
            }
        }
    }

    public void arrayZeichner(GridPane spielfeld, FeldFX feld, ImageView grafikFeld, Image feldGrafik, Image danebenGrafik, Image raumschiffGrafik, Image trefferGrafik, int x, int y, int höhe, int breite) {
        grafikFeld.setId("" + x + y);
        grafikFeld.setFitHeight(höhe);
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
     * @param textAusgabeText
     * @param textAusgabe
     */
    public static void textAusgabeSteuerung(String textAusgabeText, Label textAusgabe) {
        textAusgabe.setText(textAusgabeText);
    }

    /**
     * Dieser Event-Handler beinhalted die Funktionen des Spielfeldes.
     *
     * @param feld
     * @param grafikFeld1
     * @param danebenGrafikGroß
     * @param trefferGrafikGroß
     * @param feldSpalte
     * @param feldReihe
     */
    public void klickevent(FeldFX feld, ImageView grafikFeld1, Image danebenGrafikGroß, Image trefferGrafikGroß, int feldSpalte, int feldReihe) {
        grafikFeld1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (feld.mapGroesse[Character.getNumericValue(grafikFeld1.getId().charAt(0))][Character.getNumericValue(grafikFeld1.getId().charAt(1))] == 0) {
                    grafikFeld1.setImage(danebenGrafikGroß);
                    feld.mapGroesse[Character.getNumericValue(grafikFeld1.getId().charAt(0))][Character.getNumericValue(grafikFeld1.getId().charAt(1))] = 1;

                    GUISpielrundeFenster.textAusgabeSteuerung("DANEBEN!", textAusgabe);

                    guiKlangSteuerung.blaster();

                    spielfeldAktiv = false;

                    log.info("Spieler " + spielerAktiv + " Schuss auf: " + Character.getNumericValue(grafikFeld1.getId().charAt(0)) + "|" + Character.getNumericValue(grafikFeld1.getId().charAt(1)) + ", Ergebnis: Daneben!");

                    if (spielerAktiv == "1") {
                        feldgrafikAktualisieren(feldSpalte, feldReihe, Feld_Spieler2, Feld_Spieler1);
                    } else {
                        feldgrafikAktualisieren(feldSpalte, feldReihe, Feld_Spieler1, Feld_Spieler2);
                    }
                } else if (feld.mapGroesse[Character.getNumericValue(grafikFeld1.getId().charAt(0))][Character.getNumericValue(grafikFeld1.getId().charAt(1))] == 5) {
                    grafikFeld1.setImage(trefferGrafikGroß);
                    feld.mapGroesse[Character.getNumericValue(grafikFeld1.getId().charAt(0))][Character.getNumericValue(grafikFeld1.getId().charAt(1))] = 6;
                    GUISpielrundeFenster.textAusgabeSteuerung("TREFFER!", textAusgabe);

                    guiKlangSteuerung.blaster();

                    guiKlangSteuerung.explosion();

                    schuetteln(spielfeld1);

                    log.info("Spieler " + spielerAktiv + " Schuss auf: " + Character.getNumericValue(grafikFeld1.getId().charAt(0)) + "|" + Character.getNumericValue(grafikFeld1.getId().charAt(1)) + ", Ergebnis: Daneben!");

                    if (spielerAktiv == "1") {
                        feldgrafikAktualisieren(feldSpalte, feldReihe, Feld_Spieler2, Feld_Spieler1);
                        spieler2Leben -= 1;
                    } else {
                        feldgrafikAktualisieren(feldSpalte, feldReihe, Feld_Spieler1, Feld_Spieler2);
                        spieler1Leben -= 1;
                    }
                } else {
                    GUISpielrundeFenster.textAusgabeSteuerung("NICHT MÖGLICH!", textAusgabe);
                }
            }
        });
    }

    private static TranslateTransition tt;

    /**
     * @param node
     * @return
     */
    public static TranslateTransition schuetteln(Node node) {
        if (tt == null || tt.getNode() != node) {
            tt = new TranslateTransition(Duration.millis(50), node);
        }
        tt.setByX(10f);
        tt.setCycleCount(2);
        tt.setAutoReverse(true);
        if (tt.getStatus() == Animation.Status.STOPPED) {
            tt.playFromStart();
        }
        return tt;
    }

    /**
     *
     */
    @FXML
    private void knopfZielen() {
        guiKlangSteuerung.knopfZielen();
    }
}
