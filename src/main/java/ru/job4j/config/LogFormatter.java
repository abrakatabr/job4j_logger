package ru.job4j.config;

import ru.job4j.datamodel.LogLevel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFormatter {
    private String format;

    public LogFormatter(String format) {
        this.format = format;
    }

    public String format(LogLevel level, StackTraceElement stackTraceElement, String message) {
        return String.format(
                format,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SS")),
                level,
                stackTraceElement.getClassName(),
                stackTraceElement.getMethodName(),
                stackTraceElement.getLineNumber(),
                message
        );
    }
}
