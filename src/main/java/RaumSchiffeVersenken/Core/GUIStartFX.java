package RaumSchiffeVersenken.Core;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;
import static RaumSchiffeVersenken.Core.Spielablauf.Feld_Spieler1;
import static RaumSchiffeVersenken.Core.Spielablauf.Feld_Spieler2;


public class GUIStartFX implements Initializable {

    @FXML
    private ImageView titelanimation;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titelanimation.setImage(new Image("images/titelanimation2.gif"));
    }

}
