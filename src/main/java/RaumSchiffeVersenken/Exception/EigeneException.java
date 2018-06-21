package RaumSchiffeVersenken.Exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EigeneException extends java.lang.Exception {

    private static final Logger log = LogManager.getLogger(EigeneException.class);

    public EigeneException(String nachricht) {
        super(nachricht);
        log.error("Abtaster Fehlgeschlagen in der Methode schiffSetzenAutomatisch() in der Klasse FeldFX. (Eigene Exception)");
    }

}
