package RaumSchiffeVersenken.GUISteuerung;

import RaumSchiffeVersenken.Core.Feld;
import RaumSchiffeVersenken.Core.SpielablaufFX;
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
                    //spielefenster.setFullScreen(true);
                } else {
                    Stage spielefenster = (Stage) spielefensterVBox.getScene().getWindow();
                    Parent quelle = FXMLLoader.load(getClass().getResource("/fxml/spielerwechselFenster.fxml"));
                    Scene szene2 = new Scene(quelle);
                    spielefenster.setScene(szene2);
                    szene2.getStylesheets().add("/gestaltung.css");
                    //spielefenster.setFullScreen(true);
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

        SpielablaufFX sfx = new SpielablaufFX();


        //führt die Methode zum Bau des Spielfeldes auf je nachdem welcher Spieler gerade dran ist
        if (spielerAktiv == "1") {
            feldgrafikAktualisieren(feldSpalte, feldReihe, Feld_Spieler2, Feld_Spieler1);
        } else {
            feldgrafikAktualisieren(feldSpalte, feldReihe, Feld_Spieler1, Feld_Spieler2);
        }

        //starte die Spielablauf-Klasse im Hintergrund
        GUISpielrundeFenster.textAusgabeSteuerung("ZIELE AUF EIN FELD!", textAusgabe);
    }

    // TODO: 14.06.2018 doppelten code eleganter lösen (variablen)
    /**
     * Die Spielfelder werden mit der Feld-Klasse verknüpft und im Spielefenster grafisch dargestellt
     *
     * @param feldSpalte
     * @param feldReihe
     */
    public void feldgrafikAktualisieren(int feldSpalte, int feldReihe, Feld großesFeld, Feld kleinesFeld) {
        spielfeld1.getChildren().clear();
        spielfeld2.getChildren().clear();

        Image feldGrafikGroß = new Image("bilder/weltraumGrafikGroß.png");
        Image danebenGrafikGroß = new Image("bilder/danebenGrafikGroß.png");
        Image trefferGrafikGroß = new Image("bilder/trefferGrafikGroß.png");

        Image feldGrafik = new Image("bilder/weltraumGrafik.png");
        Image raumschiffGrafik = new Image("bilder/raumschiffGrafik.png");
        Image danebenGrafik = new Image("bilder/danebenGrafik.png");
        Image trefferGrafik = new Image("bilder/trefferGrafik.png");


        //die for-Schleifen befüllen beide Spielfelder mit Grafiken
        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                ImageView grafikFeld1 = new ImageView();
                grafikFeld1.setId("" + x + y);
                grafikFeld1.setFitHeight(50);
                grafikFeld1.setFitWidth(50);

                if (spielfeldAktiv) {
                    klickevent(großesFeld, grafikFeld1, danebenGrafikGroß, trefferGrafikGroß, feldSpalte, feldReihe);
                }

                if (großesFeld.mapGroesse[x][y] == 0) {
                    grafikFeld1.setImage(feldGrafikGroß);
                    spielfeld1.add(grafikFeld1, x, y);
                } else if (großesFeld.mapGroesse[x][y] == 1) {
                    grafikFeld1.setImage(danebenGrafikGroß);
                    spielfeld1.add(grafikFeld1, x, y);
                } else if (großesFeld.mapGroesse[x][y] == 5) {
                    grafikFeld1.setImage(feldGrafikGroß);
                    spielfeld1.add(grafikFeld1, x, y);
                } else if (großesFeld.mapGroesse[x][y] == 6) {
                    grafikFeld1.setImage(trefferGrafikGroß);
                    spielfeld1.add(grafikFeld1, x, y);
                }
            }
        }

        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                ImageView grafikFeld2 = new ImageView();
                grafikFeld2.setId("" + x + y);

                if (kleinesFeld.mapGroesse[x][y] == 0) {
                    grafikFeld2.setImage(feldGrafik);
                    spielfeld2.add(grafikFeld2, x, y);
                } else if (kleinesFeld.mapGroesse[x][y] == 1) {
                    grafikFeld2.setImage(danebenGrafik);
                    spielfeld2.add(grafikFeld2, x, y);
                } else if (kleinesFeld.mapGroesse[x][y] == 5) {
                    grafikFeld2.setImage(raumschiffGrafik);
                    spielfeld2.add(grafikFeld2, x, y);
                } else if (kleinesFeld.mapGroesse[x][y] == 6) {
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
    public static void textAusgabeSteuerung(String textAusgabeText, Label textAusgabe) {

        //erstellt ein Textelement für das Label
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
    public void klickevent(Feld feld, ImageView grafikFeld1, Image danebenGrafikGroß, Image trefferGrafikGroß, int feldSpalte, int feldReihe) {
        grafikFeld1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (feld.mapGroesse[Character.getNumericValue(grafikFeld1.getId().charAt(0))][Character.getNumericValue(grafikFeld1.getId().charAt(1))] == 0) {
                    grafikFeld1.setImage(danebenGrafikGroß);
                    feld.mapGroesse[Character.getNumericValue(grafikFeld1.getId().charAt(0))][Character.getNumericValue(grafikFeld1.getId().charAt(1))] = 1;

                    GUISpielrundeFenster.textAusgabeSteuerung("DANEBEN!", textAusgabe);

                    guiKlangSteuerung.blaster();

                    spielfeldAktiv = false;

                    if (spielerAktiv == "1") {
                        feldgrafikAktualisieren(feldSpalte, feldReihe, Feld_Spieler2, Feld_Spieler1);
                    } else {
                        feldgrafikAktualisieren(feldSpalte, feldReihe, Feld_Spieler1, Feld_Spieler2);
                    }
                } else if (feld.mapGroesse[Character.getNumericValue(grafikFeld1.getId().charAt(0))][Character.getNumericValue(grafikFeld1.getId().charAt(1))] == 5) {
                    grafikFeld1.setImage(trefferGrafikGroß);
                    feld.mapGroesse[Character.getNumericValue(grafikFeld1.getId().charAt(0))][Character.getNumericValue(grafikFeld1.getId().charAt(1))] = 6;
                    GUISpielrundeFenster.textAusgabeSteuerung("TREFFER!", textAusgabe);


                    Thread t1 = new Thread() {
                        public void run() {
                            guiKlangSteuerung.blaster();
                        }
                    };

                    Thread t2 = new Thread() {
                        public void run() {
                            guiKlangSteuerung.explosion();
                        }
                    };

                    try {
                        t1.start();
                        t2.start();
                        t1.join();
                        t2.join();
                    } catch (InterruptedException e) {
                        log.error("Interrupted exception");
                    }

                    schuetteln(spielfeld1);

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
