package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.Core.Logic.Spielablauf;
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


    //Die Spieleinstruktionen werden im Textfeld des GUI über eine Methode in der GUISpielrundeFenster ausgegeben
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
     *
     */
    public void SchiessenAblauf() {
        GUISpielrundeFenster gui = new GUISpielrundeFenster();

        for (int i = 0; i <= 99; i++) {
            Feld Kopie_Feld_Spieler1 = new Feld(Feld_Spieler1);
            log.info("Kopie erstellung Feld_Spieler1" + Kopie_Feld_Spieler1);
            Feld Kopie_Feld_Spieler2 = new Feld(Feld_Spieler2);
            log.info("Kopie erstellung Feld_Spieler2" + Kopie_Feld_Spieler2);

            Kopie_Feld_Spieler1.kriegsnebel();
            Kopie_Feld_Spieler2.kriegsnebel();
            log.info("Kopie Kriegsnebel Feld_Spieler1" + Kopie_Feld_Spieler1);
            log.info("Kopie Kriegsnebel Feld_Spieler2" + Kopie_Feld_Spieler2);

            // TODO: 07.06.2018 Feld aktualisieren spieler1 kopie_feld_spieler2
            gui.feldgrafikAktualisieren(10, 10, Kopie_Feld_Spieler2, Feld_Spieler1);

            // Spieler 1 Schießablauf

            // TODO: 07.06.2018 Georgs grafik klick gui änderung EVENT HÄNDLER
            //Feld_Spieler2.schießen();

            // TODO: 07.06.2018 Fensterwechsel zu spieler n+1
            // TODO: 07.06.2018 Feld aktualisieren spieler2 kopiespieler1
            // Spieler 2 Schießablauf
            // TODO: 07.06.2018 Georgs grafik klick gui änderung EVENT HÄNDLER
            Feld_Spieler1.zielenZumSchiessen();


            Feld_Spieler2.TrefferZaehler(Feld_Spieler2, 2);
            Feld_Spieler1.TrefferZaehler(Feld_Spieler1, 1);
        }
    }

    // --------------------------------------------------------------------------------

    /**
     * @param i
     * @param map
     * @return
     */
    public String derzeitigerSchiffSetzer(int i, HashMap map) {
        RaumSchiff schiff = (RaumSchiff) map.get(i);
        DerzeitigeSchiffslänge = schiff.getLaenge();
        String DerzeitigerSchiffsName = "";

        if (DerzeitigeSchiffslänge == 1) {
            DerzeitigerSchiffsName = "Jäger";
        } else if (DerzeitigeSchiffslänge == 2) {
            DerzeitigerSchiffsName = "Bomber";
        } else if (DerzeitigeSchiffslänge == 4) {
            DerzeitigerSchiffsName = "Fregatte";
        } else if (DerzeitigeSchiffslänge == 5) {
            DerzeitigerSchiffsName = "Zertörer";
        }

        System.out.println("\nDerzeitiger Schiffstyp: " + DerzeitigerSchiffsName + "\n" +
                "Es hat die Länge: " + DerzeitigeSchiffslänge + "\n");

        return "";
    }

    // ----------------------------------------------------------------------------------

    public boolean randomSchiffeSetzen(Feld feld, int SchiffTypsLaenge) {

        int randomX = ThreadLocalRandom.current().nextInt(10);
        int randomY = ThreadLocalRandom.current().nextInt(10);
        int randomRichtung = ThreadLocalRandom.current().nextInt(2) + 1;

        return feld.schiffSetzenAutomatisch(randomY, randomX, randomRichtung, SchiffTypsLaenge);
    }

    // ------------------------------------------------------------------------------------

    public String spieler1SchiffeSetzenAblauf(HashMap SchiffsMap, int rmInt) {

        if (rmInt == 1) {

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

        } else {
            for (int i = 1; i <= 12; i++) {
                RaumSchiff schiff = (RaumSchiff) SchiffsMap.get(i);
                DerzeitigeSchiffslänge = schiff.getLaenge();
                derzeitigerSchiffSetzer(i, SchiffsMap);
                Feld_Spieler1.zielenZumSchiffeSetzen(DerzeitigeSchiffslänge);
            }
        }

        return "";
    }

    public String spieler2SchiffeSetzenAblauf(HashMap SchiffsMap, int rmInt2) {

        if (rmInt2 == 1) {
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

        } else {
            for (int i = 1; i <= 12; i++) {
                RaumSchiff schiff = (RaumSchiff) SchiffsMap.get(i);
                DerzeitigeSchiffslänge = schiff.getLaenge();
                derzeitigerSchiffSetzer(i, SchiffsMap);
                Feld_Spieler2.zielenZumSchiffeSetzen(DerzeitigeSchiffslänge);
            }
        }

        return "";
    }
}
