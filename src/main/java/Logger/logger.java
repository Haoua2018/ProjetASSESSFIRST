package Logger;

import org.apache.logging.log4j.*;

public class Example {
    private static final Logger logger;

    static {
        logger = Logger.getLogger(Example.class);
        logger.getName();
    }

    public static void main(String[] args) {
        // To generate debug logs
        logger.debug("");
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
