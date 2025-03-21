package ru.job4j.logerfactory;

import ru.job4j.config.LogFormatter;
import ru.job4j.config.LoggerConfig;
import ru.job4j.datamodel.LogLevel;
import ru.job4j.loggers.ConsoleLogger;
import ru.job4j.loggers.Logger;

public class ConsoleLoggerFactory implements LoggerFactory {
    @Override
    public Logger getLogger(LoggerConfig config) {
        return new ConsoleLogger(new LogFormatter(config.getLogFormat()), config.getLogLevel());
    }
}
