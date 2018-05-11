package RaumSchiffeVersenken.Core;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class SpielablaufFX extends Application{

    @Override
    public void start(Stage spielefenster) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("gui.fxml"));
        Parent root = loader.load();
        Scene szene1 = new Scene(root);
        szene1.getStylesheets().add("gestaltung.css");

        spielefenster.setScene(szene1);
        spielefenster.show();
     }

    public static void main(String[] args) {
        launch(args);
    }
}
