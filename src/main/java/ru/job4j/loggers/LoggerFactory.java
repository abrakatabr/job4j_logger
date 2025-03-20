package ru.job4j.loggers;

import ru.job4j.config.LogFormatter;
import ru.job4j.config.LoggerConfig;

public class LoggerFactory {
    public static Logger createLogger(LoggerConfig config) {
        LogFormatter formatter = new LogFormatter(config.getLogFormat());
        Logger logger = new ConsoleLogger(formatter, config.getLogLevel());
        if ("file".equals(config.getOutput())) {
            logger = new FileLogger(formatter, config.getFileLoggerPath(), config.getLogLevel());
        }
        return logger;
    }
}
