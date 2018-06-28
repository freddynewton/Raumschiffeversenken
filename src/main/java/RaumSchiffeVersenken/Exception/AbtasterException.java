package RaumSchiffeVersenken.Exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AbtasterException extends Exception {

    private static final Logger log = LogManager.getLogger(AbtasterException.class);

    public AbtasterException(String nachricht) {
        super(nachricht);
        log.error("Abtaster Fehlgeschlagen in der Methode schiffSetzenAutomatisch() in der Klasse FeldFX. (Eigene Exception)");
    }
}
