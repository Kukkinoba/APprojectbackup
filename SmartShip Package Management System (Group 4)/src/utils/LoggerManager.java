package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoggerManager {

    private static final String LOG_DIR = "logs";

    static {
        // Ensure the log directory exists before logging starts
        try {
            File logDirectory = new File(LOG_DIR);
            if (!logDirectory.exists()) {
                Files.createDirectories(Paths.get(LOG_DIR));
                System.out.println("[LoggerManager] Created log directory at: " + logDirectory.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("[LoggerManager] Failed to create log directory: " + e.getMessage());
        }
    }


    public static Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }


    public static void logException(Logger logger, String message, Exception e) {
        if (logger != null && e != null) {
            logger.error(message + " - Exception: " + e.getClass().getSimpleName() + " | " + e.getMessage(), e);
        } else if (logger != null) {
            logger.error(message + " - Exception was null");
        } else {
            System.err.println("[LoggerManager] Logger or exception was null while trying to log error.");
        }
    }

    public static void log(Logger logger, String level, String message) {
        if (logger == null) {
            System.err.println("[LoggerManager] Logger is null — cannot log message.");
            return;
        }

        switch (level.toUpperCase()) {
            case "INFO":
                logger.info(message);
                break;
            case "DEBUG":
                logger.debug(message);
                break;
            case "WARN":
                logger.warn(message);
                break;
            case "ERROR":
                logger.error(message);
                break;
            case "FATAL":
                logger.fatal(message);
                break;
            default:
                logger.trace(message);
        }
    }
}
