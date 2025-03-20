package ru.job4j.loggers;

import ru.job4j.config.LogFormatter;
import ru.job4j.datamodel.LogLevel;

public class ConsoleLogger implements Logger {
    private LogFormatter formatter;
    private LogLevel currentLevel;

    public ConsoleLogger(LogFormatter formatter, String currentLevel) {
        this.formatter = formatter;
        this.currentLevel = LogLevel.valueOf(LogLevel.class, currentLevel);
    }

    @Override
    public void log(LogLevel level, String message) {
        if (currentLevel.ordinal() <= level.ordinal()) {
            StackTraceElement[] stackFrames = Thread.currentThread().getStackTrace();
            StackTraceElement frame = stackFrames[stackFrames.length - 1];
            String formattedMessage = formatter.format(level, frame, message);
            System.out.println(formattedMessage);
        }
    }

    @Override
    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    @Override
    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    @Override
    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}
