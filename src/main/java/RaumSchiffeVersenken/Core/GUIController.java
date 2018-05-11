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

public class GUIController implements Initializable {

    //referentziert GUI-Elemente der FXML-Datei
    @FXML private GridPane spielfeld1;

    @FXML private GridPane spielfeld2;

    @FXML private TextFlow textAusgabe;

    //Initialisierung des Fensters direkt nach dessen Start führt GUI-Methoden aus
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int feldSpalte = 10;
        int feldReihe = 10;

        //erstellt ein Textelement für das Textfeld
        Text text1 = new Text("Willkommen zu Raumschiffe Versenken! \nSpieler 1 beginnt.");

        //erstellt Liste der Textfeld-Elemente
        ObservableList list = textAusgabe.getChildren();

        //Textkoeper wird dem Textfeld hizugefügt
        list.addAll(text1);

        //die for-Schleifen befüllen beide Spielfelder mit Grafiken
        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                Image feldGrafik = new Image("images/weltraum.png");
                ImageView grafik = new ImageView();
                grafik.setFitWidth(24);
                grafik.setFitHeight(24);
                grafik.setImage(feldGrafik);
                spielfeld1.add(grafik,x,y);
            }
        }

        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                Image feldGrafik = new Image("images/weltraum.png");
                ImageView grafik = new ImageView();
                grafik.setFitWidth(24);
                grafik.setFitHeight(24);
                grafik.setImage(feldGrafik);
                spielfeld2.add(grafik,x,y);
            }
        }

        //Methoden aus anderen Klassen implementieren
        //Spielablauf spielablauf = new Spielablauf();
        //spielablauf.SchiffeSetzen();
    }
}
