package RaumSchiffeVersenken.GUISteuerung;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import java.io.File;


public class GUIKlangSteuerung {

    public void knopfZielen() {
        String musikDatei = "src/main/resources/geräusche/knopfZielen.wav";
        Media knopfZielen = new Media(new File(musikDatei).toURI().toString());
        AudioClip musikSpieler = new AudioClip(knopfZielen.getSource());
        musikSpieler.play();
    }

    public void knopfDruecken() {
        String musikDatei = "src/main/resources/geräusche/knopfDruecken.wav";
        Media knopfZielen = new Media(new File(musikDatei).toURI().toString());
        AudioClip musikSpieler = new AudioClip(knopfZielen.getSource());
        musikSpieler.play();
    }

    public void blaster() {
        String musikDatei = "src/main/resources/geräusche/blaster.wav";
        Media knopfZielen = new Media(new File(musikDatei).toURI().toString());
        AudioClip musikSpieler = new AudioClip(knopfZielen.getSource());
        musikSpieler.play();
    }

    public void explosion() {
        String musikDatei = "src/main/resources/geräusche/explosion.wav";
        Media knopfZielen = new Media(new File(musikDatei).toURI().toString());
        AudioClip musikSpieler = new AudioClip(knopfZielen.getSource());
        musikSpieler.play();
    }
}
