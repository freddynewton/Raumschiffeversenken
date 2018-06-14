package RaumSchiffeVersenken.Core;

import RaumSchiffeVersenken.Entwicklungskonsole.Spielablauf;
import RaumSchiffeVersenken.Interface_Factory.RaumSchiff;
import RaumSchiffeVersenken.Interface_Factory.SchiffFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;


public class SpielablaufFX {

    /**
     * <p>Hier wird der Logger für die Klasse SpielablaufFX erstellt sowie alle Static-Variablen der Klasse.</p>
     */
    private static final Logger log = LogManager.getLogger(Spielablauf.class);

    public static Feld Feld_Spieler1 = new Feld(10, 10);
    public static Feld Feld_Spieler2 = new Feld(10, 10);

    private int DerzeitigeSchiffslaenge = 0;

    /**
     * <p>Die Methode SchiffeSetzenablauf definiert zuerst eine HashMap der unterschiedlichen Schiffsarten, welche für
     * das Platzieren dieser auf dem Spielfeld bereitgestellt werden. Die einzelnen Schiffe werden über die Factory
     * "SchiffFactory" generiert. Das anschließende platzieren der einzelnen Schiffe wird über zwei Threads,
     * je einer für jede Spielerflotte, abgehandelt.</p>
     */
    public void SchiffeSetzenAblauf() {

        HashMap<Integer, RaumSchiff> SchiffsMap = new HashMap<>();
        log.info("HashMap<Integer, RaumSchiff> SchiffsMap = new HashMap<>()" + SchiffsMap);

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

        log.info("Bomber 1" + SchiffsMap.put(6, Objects.requireNonNull(SchiffFactory.getRaumschiff("2"))));
        log.info("Bomber 2" + SchiffsMap.put(7, Objects.requireNonNull(SchiffFactory.getRaumschiff("2"))));
        log.info("Bomber 3" + SchiffsMap.put(8, Objects.requireNonNull(SchiffFactory.getRaumschiff("2"))));
        log.info("Bomber 4" + SchiffsMap.put(9, Objects.requireNonNull(SchiffFactory.getRaumschiff("2"))));
        SchiffsMap.put(6, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        SchiffsMap.put(7, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        SchiffsMap.put(8, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        SchiffsMap.put(9, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));

        log.info("Fregatte 1" + SchiffsMap.put(10, Objects.requireNonNull(SchiffFactory.getRaumschiff("4"))));
        log.info("Fregatte 2" + SchiffsMap.put(11, Objects.requireNonNull(SchiffFactory.getRaumschiff("4"))));
        SchiffsMap.put(10, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));
        SchiffsMap.put(11, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));

        log.info("Zerstörer" + SchiffsMap.put(12, Objects.requireNonNull(SchiffFactory.getRaumschiff("5"))));
        SchiffsMap.put(12, Objects.requireNonNull(SchiffFactory.getRaumschiff("5")));

        Thread t1 = new Thread() {
            public void run() {
                spieler1SchiffeSetzenAblauf(SchiffsMap, 1);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                spieler2SchiffeSetzenAblauf(SchiffsMap, 1);
            }
        };

        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            log.error("Interrupted exception");
        }
    }

    /**
     *
     *
     * @param feld :)
     * @param SchiffTypsLaenge :)
     * @return boolean ob es funktioniert hat mit dem Schiffe setzen
     */
    public boolean randomSchiffeSetzen(Feld feld, int SchiffTypsLaenge) {

        int randomX = ThreadLocalRandom.current().nextInt(10);
        int randomY = ThreadLocalRandom.current().nextInt(10);
        int randomRichtung = ThreadLocalRandom.current().nextInt(2) + 1;

        return feld.schiffSetzenAutomatisch(randomY, randomX, randomRichtung, SchiffTypsLaenge);
    }

    /**
     *
     * @param SchiffsMap :)
     * @param rmInt :)
     */
    public synchronized void spieler1SchiffeSetzenAblauf(HashMap SchiffsMap, int rmInt) {

        try {
            for (int i = 1; i <= 12; i++) {
                RaumSchiff schiff = (RaumSchiff) SchiffsMap.get(i);
                DerzeitigeSchiffslaenge = schiff.getLaenge();
                boolean stand = randomSchiffeSetzen(Feld_Spieler1, DerzeitigeSchiffslaenge);

                if (!stand) {
                    i -= 1;
                }
            }
        } catch (Exception ex) {
            log.error("Exception: " + ex);
            throw ex;
        }
    }

    /**
     *
     * @param SchiffsMap :)
     * @param rmInt2 :)
     */
    public synchronized void spieler2SchiffeSetzenAblauf(HashMap SchiffsMap, int rmInt2) {

        try {
            for (int i = 1; i <= 12; i++) {
                boolean stand = randomSchiffeSetzen(Feld_Spieler2, ((RaumSchiff) SchiffsMap.get(i)).getLaenge());

                if (!stand) {
                    i -= 1;
                }
            }
        } catch (Exception ex) {
            log.error("Exception: " + ex);
            throw ex;
        }
    }
}
