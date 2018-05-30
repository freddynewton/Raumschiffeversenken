package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.Core.Logic.Spielablauf;

import static javafx.application.Application.launch;

public class SpielSystemMain {

    public static void main(String[] args) {

        Spielablauf s = new Spielablauf();

        s.start();
        s.SchiffeSetzenAblauf();
        s.SchiessenAblauf();
    }
}
