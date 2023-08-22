package org.example.Task_2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static Logger logger;
    protected int num = 1;

    protected SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public void log(String msg) {
//        Date date = new Date();
        System.out.println("[" + formatter.format(new Date()) + " " + num++ + "] " + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}
