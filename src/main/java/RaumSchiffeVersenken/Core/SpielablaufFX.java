package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.Entwicklungskonsole.Spielablauf;
import RaumSchiffeVersenken.GUISteuerung.GUISpielrundeFenster;
import RaumSchiffeVersenken.Interface_Factory.RaumSchiff;
import RaumSchiffeVersenken.Interface_Factory.SchiffFactory;
import javafx.scene.control.Label;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SpielablaufFX {

    Lock lock = new ReentrantLock();

    /**
     * Logger erstellung.
     */
    private static final Logger log = LogManager.getLogger(Spielablauf.class);

    private int DerzeitigeSchiffslänge = 0;
    public static Feld Feld_Spieler1 = new Feld(10, 10);
    public static Feld Feld_Spieler2 = new Feld(10, 10);

    /**
     * Die Spieleinstruktionen werden im Textfeld des GUI über eine Methode in der GUISpielrundeFenster ausgegeben
     *
     * @param textAusgabe
     * @return
     */
    public String start(Label textAusgabe) {

        GUISpielrundeFenster.textAusgabeSteuerung("Schieße auf ein Feld!", textAusgabe);

        return "Start";
    }

    /**
     *
     */
    public void SchiffeSetzenAblauf() {

        HashMap<Integer, RaumSchiff> SchiffsMap = new HashMap<>();
        log.info("HashMap<Integer, RaumSchiff> SchiffsMap = new HashMap<>()" + SchiffsMap);

        // Jaeger erstellen mit 1 Lebenspunkt
        log.info("Jager 1" + SchiffsMap.put(1, Objects.requireNonNull(SchiffFactory.getRaumschiff("1"))));
        log.info("Jager 2" + SchiffsMap.put(2, Objects.requireNonNull(SchiffFactory.getRaumschiff("1"))));
        log.info("Jager 3" + SchiffsMap.put(3, Objects.requireNonNull(SchiffFactory.getRaumschiff("1"))));
        log.info("Jager 4" + SchiffsMap.put(4, Objects.requireNonNull(SchiffFactory.getRaumschiff("1"))));
        log.info("Jager 5" + SchiffsMap.put(5, Objects.requireNonNull(SchiffFactory.getRaumschiff("1"))));
        SchiffsMap.put(1, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        SchiffsMap.put(2, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        SchiffsMap.put(3, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        SchiffsMap.put(4, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        SchiffsMap.put(5, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));

        //Bomber erstellen mit 2 Lebenspunkten
        log.info("Bomber 1" + SchiffsMap.put(6, Objects.requireNonNull(SchiffFactory.getRaumschiff("2"))));
        log.info("Bomber 2" + SchiffsMap.put(7, Objects.requireNonNull(SchiffFactory.getRaumschiff("2"))));
        log.info("Bomber 3" + SchiffsMap.put(8, Objects.requireNonNull(SchiffFactory.getRaumschiff("2"))));
        log.info("Bomber 4" + SchiffsMap.put(9, Objects.requireNonNull(SchiffFactory.getRaumschiff("2"))));
        SchiffsMap.put(6, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        SchiffsMap.put(7, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        SchiffsMap.put(8, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        SchiffsMap.put(9, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));

        //Fregatte erstellen mit 4 Lebenspunkten
        log.info("Fregatte 1" + SchiffsMap.put(10, Objects.requireNonNull(SchiffFactory.getRaumschiff("4"))));
        log.info("Fregatte 2" + SchiffsMap.put(11, Objects.requireNonNull(SchiffFactory.getRaumschiff("4"))));
        SchiffsMap.put(10, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));
        SchiffsMap.put(11, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));

        //Zerstörer erstellen mit 5 Lebenspunkten
        log.info("Zerstörer" + SchiffsMap.put(12, Objects.requireNonNull(SchiffFactory.getRaumschiff("5"))));
        SchiffsMap.put(12, Objects.requireNonNull(SchiffFactory.getRaumschiff("5")));

        spieler1SchiffeSetzenAblauf(SchiffsMap, 1);

        spieler2SchiffeSetzenAblauf(SchiffsMap, 1);
    }

    /**
     * @param feld
     * @param SchiffTypsLaenge
     * @return
     */
    public boolean randomSchiffeSetzen(Feld feld, int SchiffTypsLaenge) {

        int randomX = ThreadLocalRandom.current().nextInt(10);
        int randomY = ThreadLocalRandom.current().nextInt(10);
        int randomRichtung = ThreadLocalRandom.current().nextInt(2) + 1;

        return feld.schiffSetzenAutomatisch(randomY, randomX, randomRichtung, SchiffTypsLaenge);
    }

    /**
     * @param SchiffsMap
     * @param rmInt
     * @return
     */
    public String spieler1SchiffeSetzenAblauf(HashMap SchiffsMap, int rmInt) {

        try {
            for (int i = 1; i <= 12; i++) {
                RaumSchiff schiff = (RaumSchiff) SchiffsMap.get(i);
                DerzeitigeSchiffslänge = schiff.getLaenge();
                boolean stand = randomSchiffeSetzen(Feld_Spieler1, DerzeitigeSchiffslänge);

                if (!stand) {
                    i -= 1;
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return "";
    }

    /**
     * @param SchiffsMap
     * @param rmInt2
     * @return
     */
    public String spieler2SchiffeSetzenAblauf(HashMap SchiffsMap, int rmInt2) {

        try {
            for (int i = 1; i <= 12; i++) {
                RaumSchiff schiff = (RaumSchiff) SchiffsMap.get(i);
                DerzeitigeSchiffslänge = schiff.getLaenge();
                boolean stand = randomSchiffeSetzen(Feld_Spieler2, DerzeitigeSchiffslänge);

                if (!stand) {
                    i -= 1;
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return "";
    }
}
