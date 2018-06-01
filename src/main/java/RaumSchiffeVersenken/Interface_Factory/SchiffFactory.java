package RaumSchiffeVersenken.Interface_Factory;

import RaumSchiffeVersenken.Core.Feld;
import RaumSchiffeVersenken.SchiffsArten.Bomber;
import RaumSchiffeVersenken.SchiffsArten.Jaeger;
import RaumSchiffeVersenken.SchiffsArten.Zerstoerer;
import RaumSchiffeVersenken.SchiffsArten.Fregatte;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class SchiffFactory {


    Lock lock = new ReentrantLock();

    /**
     * Logger erstellung.
     */
    private static final Logger log = LogManager.getLogger(Feld.class);


    /**
     * @param kriterium
     * @return je nach Kriterium ein Schiff
     */
    public static RaumSchiff getRaumschiff(String kriterium) {


        if (kriterium.equals("1")) {
            log.info("Jaeger wurde erstellt in der Factory");
            return new Jaeger();

        } else if (kriterium.equals("2")) {
            log.info("Bomber wurde erstellt in der Factory");
            return new Bomber() {
            };

        } else if (kriterium.equals("4")) {
            log.info("Fregatte wurde erstellt in der Factory");
            return new Fregatte() {
            };

        } else if (kriterium.equals("5")) {
            log.info("Zerstörer wurde erstellt in der Factory");
            return new Zerstoerer() {
            };
        }

        return null;
    }

}
