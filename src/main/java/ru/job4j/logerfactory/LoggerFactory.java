package ru.job4j.logerfactory;

import ru.job4j.config.LogFormatter;
import ru.job4j.config.LoggerConfig;
import ru.job4j.datamodel.LogLevel;
import ru.job4j.loggers.Logger;

public interface LoggerFactory {
    Logger getLogger(LoggerConfig config);
}
