package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.Interface.RaumSchiff;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;
import static javafx.application.Application.launch;

public class SpielSystemMain {

    public static void main(String[] args) {

        Spielablauf s = new Spielablauf();

        s.start();
        s.SchiffeSetzenAblauf();
        s.SchiessenAblauf();
    }
}
