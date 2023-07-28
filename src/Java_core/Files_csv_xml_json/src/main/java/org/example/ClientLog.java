package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ClientLog {

    List<int[]> log = new ArrayList<>();

    public void log(int productNum, int amount) {
        log.add(new int[]{productNum, amount});
    }


    public void exportAsCSV(File textFile) throws FileNotFoundException {

        try (PrintWriter printWriter = new PrintWriter(textFile)) {
            printWriter.println("productNum, amount");
            for (int[] l : log) {
                printWriter.println(l[0] + ", " + l[1]);
            }
        }
    }
}
