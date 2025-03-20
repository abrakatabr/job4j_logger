package ru.job4j.loggers;

import ru.job4j.config.LogFormatter;
import ru.job4j.datamodel.LogLevel;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    private LogFormatter formatter;
    private String filePath;
    private LogLevel currentLevel;

    public FileLogger(LogFormatter formatter, String filePath, String currentLevel) {
        this.formatter = formatter;
        this.filePath = filePath;
        this.currentLevel = LogLevel.valueOf(LogLevel.class, currentLevel);
    }

    @Override
    public void log(LogLevel level, String message) {
        if (currentLevel.ordinal() <= level.ordinal()) {
            StackTraceElement[] stackFrames = Thread.currentThread().getStackTrace();
            StackTraceElement frame = stackFrames[stackFrames.length - 1];
            String formattedMessage = formatter.format(level, frame, message);
            String path = "src/logs/" + filePath;
            try (FileWriter writer = new FileWriter(path, true)) {
                writer.write(formattedMessage + System.lineSeparator());
            } catch (IOException e) {
                System.err.println("Failed to write to log file: " + e.getMessage());
            }
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
