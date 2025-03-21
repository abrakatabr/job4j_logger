package ru.job4j.loggers;

import ru.job4j.config.LogFormatter;
import ru.job4j.config.LoggerConfig;
import ru.job4j.datamodel.LogLevel;
import ru.job4j.logerfactory.ConsoleLoggerFactory;
import ru.job4j.logerfactory.FileLoggerFactory;
import ru.job4j.logerfactory.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class LoggerManager {
    private Map<LogLevel, Logger> loggers;

    public LoggerManager(LoggerConfig config) {
        loggers = new HashMap<>();
        loadConfiguration(config);
    }

    private void loadConfiguration(LoggerConfig config) {
        for (LogLevel level : LogLevel.values()) {
            String loggerType = config.getOutput(level);
            if (loggerType != null) {
                switch (loggerType) {
                    case "console":
                        loggers.put(level, new ConsoleLoggerFactory().getLogger(config));
                        break;
                    case "file":
                        loggers.put(level, new FileLoggerFactory().getLogger(config));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid properties");
                }
            }
        }
    }

    public void log(LogLevel level, String message) {
        Logger logger = loggers.get(level);
        if (logger != null) {
            logger.log(level, message);
        } else {
            throw new IllegalArgumentException("No output for level" + level.name());
        }
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}
