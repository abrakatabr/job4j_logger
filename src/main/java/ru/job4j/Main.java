package ru.job4j;

import ru.job4j.config.LoggerConfig;
import ru.job4j.loggers.Logger;
import ru.job4j.loggers.LoggerManager;

public class Main {
    public static void main(String[] args) {
        LoggerConfig config = new LoggerConfig("log.properties");
        LoggerManager logger = new LoggerManager(config);
        logger.info("info message.");
        logger.debug("debug massage");
        logger.error("error message.");
    }
}