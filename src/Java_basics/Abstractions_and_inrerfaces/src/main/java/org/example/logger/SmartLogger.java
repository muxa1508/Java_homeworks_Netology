package org.example.logger;

import java.time.LocalDateTime;

public class SmartLogger implements Logger{

    private int counter = 1;
    private String type;
    @Override
    public void log(String msg) {
        if (msg.toLowerCase().contains("error")) {
            type = "ERROR";
        } else {
            type = "INFO";
        }
        System.out.println(type + "#" + counter + " [" +
                LocalDateTime.now() + "]" + " " + msg);
        counter ++;
    }
}
