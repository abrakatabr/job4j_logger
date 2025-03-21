package ru.job4j.logerfactory;

import ru.job4j.config.LogFormatter;
import ru.job4j.config.LoggerConfig;
import ru.job4j.loggers.FileLogger;
import ru.job4j.loggers.Logger;

public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger getLogger(LoggerConfig config) {
        return new FileLogger(new LogFormatter(config.getLogFormat()),
                config.getFileLoggerPath(), config.getLogLevel());
    }
}
