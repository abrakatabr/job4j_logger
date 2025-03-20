package ru.job4j.config;

import ru.job4j.datamodel.LogLevel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoggerConfig {
    private Properties properties;

    public LoggerConfig(String filePath) {
        properties = new Properties();
        String path = "src/main/resources/" + filePath;
        try (FileInputStream input = new FileInputStream(path)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLogLevel() {
        return properties.getProperty("logLevel", "INFO");
    }

    public String getLogFormat() {
        return properties.getProperty("logFormat", "%s [%s] %s:%s:%d %s");
    }

    public String getOutput() {
        return properties.getProperty("output", "console");
    }

    public String getFileLoggerPath() {
        return properties.getProperty("outputPath", "logs.log");
    }
}
