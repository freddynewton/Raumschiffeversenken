package RaumSchiffeVersenken.Core;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.DoubleToLongFunction;

public class GUIController implements Initializable {

    @FXML
    private GridPane spielfeld1;

    @FXML
    private GridPane spielfeld2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int feldSpalte = 10;
        int feldReihe = 10;

        //for-Schleife befüllt Spielfeld mit Buttons
        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                Image feldGrafik = new Image("File:images/weltraum.png");
                ImageView grafik = new ImageView();
                grafik.setFitWidth(24);
                grafik.setFitHeight(24);
                grafik.setImage(feldGrafik);
                spielfeld1.add(grafik,x,y);
            }
        }

        for (int y = 0; y < feldSpalte; y++) {
            for (int x = 0; x < feldReihe; x++) {
                Image feldGrafik = new Image("File:images/weltraum.png");
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
