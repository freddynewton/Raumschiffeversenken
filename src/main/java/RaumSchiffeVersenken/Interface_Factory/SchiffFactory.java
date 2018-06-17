package RaumSchiffeVersenken.Interface_Factory;

import RaumSchiffeVersenken.Core.FeldFX;
import RaumSchiffeVersenken.SchiffsArten.Bomber;
import RaumSchiffeVersenken.SchiffsArten.Jaeger;
import RaumSchiffeVersenken.SchiffsArten.Zerstoerer;
import RaumSchiffeVersenken.SchiffsArten.Fregatte;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SchiffFactory {

    /**
     * Logger erstellung.
     */
    private static final Logger log = LogManager.getLogger(FeldFX.class);

    /**
     * @param kriterium String
     * @return je nach Kriterium ein Schiff
     */
    public static RaumSchiff getRaumschiff(String kriterium) {

        switch (kriterium) {
            case "1":
                log.info("Jaeger wurde erstellt in der Factory");
                return new Jaeger();
            case "2":
                log.info("Bomber wurde erstellt in der Factory");
                return new Bomber() {
                };
            case "4":
                log.info("Fregatte wurde erstellt in der Factory");
                return new Fregatte() {
                };
            case "5":
                log.info("Zerstörer wurde erstellt in der Factory");
                return new Zerstoerer() {
                };
        }

        return null;
    }

}
