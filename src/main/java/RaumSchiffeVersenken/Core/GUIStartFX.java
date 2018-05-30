package RaumSchiffeVersenken.Core;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GUIStartFX implements Initializable {

    private Stage quelle;

    @FXML
    private ImageView titelanimation;

    @FXML
    private StackPane stackpane;

    @FXML
    private void szeneWechsel() throws IOException {
        Parent quelle;
        try {
            Stage spielefenster;
            spielefenster = SpielSystemMainFX.start(Stage spielefenster);
            quelle = FXMLLoader.load(getClass().getResource("/fxml/spiel.fxml"));
            Scene szene2 = new Scene(quelle);
            spielefenster.setScene(szene2);
            szene2.getStylesheets().add("resources/gestaltung.css");
            spielefenster.setFullScreen(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titelanimation.setImage(new Image("images/titelanimation2.gif"));
    }

}
