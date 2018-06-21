package RaumSchiffeVersenken.Exception;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EigeneException extends java.lang.Exception {

    private static final Logger log = LogManager.getLogger(EigeneException.class);

    // TODO: 21.06.2018 Eigene Exception schreiben für nicht setzbaren schiff für die Random


    public EigeneException() {
    }

    public void EigeneExceptionArrayOutOfBounds(String nachricht, Exception ex) {
        log.error("Schiff konnte nicht gesetzt werden (außerhalb des Feldes).\n", ex);
    }

}
