package RaumSchiffeVersenken.Exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SchiffSetzenException extends Exception {

    private static final Logger log = LogManager.getLogger(SchiffSetzenException.class);

    public SchiffSetzenException(String nachricht) {
        super(nachricht);
        log.error("Schiffe Setzen hat nicht funktioniert, melden sie sich bei ihrem Spieleentwickler. (Eigene Exception)");
        System.exit(0);
    }

}
