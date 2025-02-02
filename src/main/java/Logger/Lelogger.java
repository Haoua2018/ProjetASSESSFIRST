package Logger;

import org.apache.logging.log4j.*;

import static org.apache.logging.log4j.Logger.*;

public class Lelogger {
    private static final Logger logger;

    static {
        logger = LogManager.getLogger(Lelogger.class);
       // logger.getName();
    }

    public static void main(String[] args) {
        // To generate debug logs
        logger.debug("Debug message");
        // To generate info logs
        logger.info("Info message");
        // To generate warning logs
        logger.warn("Warn message");
        // To generate error logs
        logger.error("Error message");
        // To generate fatal logs
        logger.fatal("Fatal message");
    }
}
