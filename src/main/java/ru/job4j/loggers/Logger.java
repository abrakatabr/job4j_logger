package ru.job4j.loggers;

import ru.job4j.datamodel.LogLevel;

public interface Logger {
    void log(LogLevel level, String message);
    void info(String message);
    void debug(String message);
    void error(String message);
}
