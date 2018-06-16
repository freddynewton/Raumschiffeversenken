package RaumSchiffeVersenken.Core;


import RaumSchiffeVersenken.Interface_Factory.RaumSchiff;
import RaumSchiffeVersenken.Interface_Factory.SchiffFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;


public class SpielablaufFX {

    /**
     * <p>Hier wird der Logger für die Klasse SpielablaufFX erstellt sowie alle Static-Variablen der Klasse.</p>
     */
    private static final Logger log = LogManager.getLogger(SpielablaufFX.class);

    public static FeldFX Feld_Spieler1 = new FeldFX(10, 10);
    public static FeldFX Feld_Spieler2 = new FeldFX(10, 10);

    ReentrantLock variablenLock = new ReentrantLock();

    private int derzeitigeSchiffslänge = 0;

    /**
     * <p>Die Methode SchiffeSetzenablauf definiert zuerst eine HashMap der unterschiedlichen Schiffsarten, welche für
     * das Platzieren dieser auf dem Spielfeld bereitgestellt werden. Die einzelnen Schiffe werden über die Factory
     * "SchiffFactory" generiert. Das anschließende platzieren der einzelnen Schiffe wird über zwei Threads,
     * je einer für jede Spielerflotte, abgehandelt.</p>
     */
    public void SchiffeSetzenAblauf() {

        HashMap<Integer, RaumSchiff> schiffsMap = new HashMap<>();
        log.info("HashMap<Integer, RaumSchiff> schiffsMap = new HashMap<>()" + schiffsMap);

        log.info("Jager 1" + schiffsMap.put(1, Objects.requireNonNull(SchiffFactory.getRaumschiff("1"))));
        log.info("Jager 2" + schiffsMap.put(2, Objects.requireNonNull(SchiffFactory.getRaumschiff("1"))));
        log.info("Jager 3" + schiffsMap.put(3, Objects.requireNonNull(SchiffFactory.getRaumschiff("1"))));
        log.info("Jager 4" + schiffsMap.put(4, Objects.requireNonNull(SchiffFactory.getRaumschiff("1"))));
        log.info("Jager 5" + schiffsMap.put(5, Objects.requireNonNull(SchiffFactory.getRaumschiff("1"))));
        schiffsMap.put(1, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        schiffsMap.put(2, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        schiffsMap.put(3, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        schiffsMap.put(4, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));
        schiffsMap.put(5, Objects.requireNonNull(SchiffFactory.getRaumschiff("1")));

        log.info("Bomber 1" + schiffsMap.put(6, Objects.requireNonNull(SchiffFactory.getRaumschiff("2"))));
        log.info("Bomber 2" + schiffsMap.put(7, Objects.requireNonNull(SchiffFactory.getRaumschiff("2"))));
        log.info("Bomber 3" + schiffsMap.put(8, Objects.requireNonNull(SchiffFactory.getRaumschiff("2"))));
        log.info("Bomber 4" + schiffsMap.put(9, Objects.requireNonNull(SchiffFactory.getRaumschiff("2"))));
        schiffsMap.put(6, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        schiffsMap.put(7, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        schiffsMap.put(8, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));
        schiffsMap.put(9, Objects.requireNonNull(SchiffFactory.getRaumschiff("2")));

        log.info("Fregatte 1" + schiffsMap.put(10, Objects.requireNonNull(SchiffFactory.getRaumschiff("4"))));
        log.info("Fregatte 2" + schiffsMap.put(11, Objects.requireNonNull(SchiffFactory.getRaumschiff("4"))));
        schiffsMap.put(10, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));
        schiffsMap.put(11, Objects.requireNonNull(SchiffFactory.getRaumschiff("4")));

        log.info("Zerstörer" + schiffsMap.put(12, Objects.requireNonNull(SchiffFactory.getRaumschiff("5"))));
        schiffsMap.put(12, Objects.requireNonNull(SchiffFactory.getRaumschiff("5")));

        Thread t1 = new Thread() {
            public void run() {
                spielerSchiffeSetzenAblauf(Feld_Spieler1, schiffsMap, 1);
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                spielerSchiffeSetzenAblauf(Feld_Spieler2, schiffsMap, 1);
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
     * @param feld
     * @param SchiffTypsLaenge
     * @return
     */
    public boolean randomSchiffeSetzen(FeldFX feld, int SchiffTypsLaenge) {

        int randomX = ThreadLocalRandom.current().nextInt(10);
        int randomY = ThreadLocalRandom.current().nextInt(10);
        int randomRichtung = ThreadLocalRandom.current().nextInt(2) + 1;

        return feld.schiffSetzenAutomatisch(randomY, randomX, randomRichtung, SchiffTypsLaenge);
    }

    /**
     * @param schiffsMap
     * @param rmInt
     * @return
     */
    public String spielerSchiffeSetzenAblauf(FeldFX Feld_Spieler, HashMap schiffsMap, int rmInt) {

        try {
            variablenLock.lock();
            for (int i = 1; i <= 12; i++) {
                RaumSchiff schiff = (RaumSchiff) schiffsMap.get(i);
                derzeitigeSchiffslänge = schiff.getLaenge();
                boolean stand = randomSchiffeSetzen(Feld_Spieler, derzeitigeSchiffslänge);

                if (!stand) {
                    i -= 1;
                }
            }
        } finally {
            variablenLock.unlock();
        }
        return "";
    }
}
