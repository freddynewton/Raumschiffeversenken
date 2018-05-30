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

    @FXML
    private ImageView titelanimation;

    @FXML
    private StackPane stackpane;

    @FXML
    private void szeneWechsel() throws IOException {
        try {
            Stage spielefenster = (Stage) stackpane.getScene().getWindow();
            Parent quelle = FXMLLoader.load(getClass().getResource("/fxml/spiel.fxml"));
            Scene szene2 = new Scene(quelle);
            spielefenster.setScene(szene2);
            szene2.getStylesheets().add("/gestaltung.css");
            spielefenster.setFullScreen(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
