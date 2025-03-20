package ru.job4j;

import ru.job4j.config.LoggerConfig;
import ru.job4j.loggers.Logger;
import ru.job4j.loggers.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        LoggerConfig config = new LoggerConfig("log.properties");
        Logger logger = LoggerFactory.createLogger(config);
        logger.info("info message.");
        logger.error("error message.");
    }
}