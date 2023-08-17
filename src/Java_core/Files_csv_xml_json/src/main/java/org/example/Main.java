package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static String[] products = {"Хлеб", "Молоко", "Масло", "Крупа"};
    static long[] prices = {25, 60, 100, 20};

    //    static File textFile = new File("src/Java_core/Files_csv_xml_json/src/main/java/org/example/basket.txt");
//    static File textFileCSV = new File("src/Java_core/Files_csv_xml_json/src/main/java/org/example/basket.csv");
//    static File textFileJson = new File("src/Java_core/Files_csv_xml_json/src/main/java/org/example/basket.json");
    static File settingsFile = new File("src/Java_core/Files_csv_xml_json/src/main/java/org/example/shop.xml");

    public static void main(String[] args) throws IOException {


        ClientLog log = new ClientLog();
        Basket basket;
        XMLSettings xmlSettings = new XMLSettings();
        xmlSettings.checkSettingsXML(settingsFile);

        if (xmlSettings.isLoadEnabled()) {
            File loadFile = new File("src/Java_core/Files_csv_xml_json/src/main/java/org/example/" + xmlSettings.getLoadFileName());
            if (loadFile.exists()) {
                basket = Basket.loadFromTxtFile(loadFile);
            } else {
                basket = new Basket(products, prices);
            }
        } else {
            basket = new Basket(products, prices);
        }

        for (int i = 0; i < basket.getProducts().length; i++) {
            System.out.println(i + 1 + ". " + basket.getProducts()[i] + " " + basket.getPrices()[i] + " руб/шт");
        }
        while (true) {
            System.out.println("Введите порядковый номер продукта и требуемое количество или введите 'end'");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                basket.printCart();
                break;
            }
            int productNum = Integer.parseInt(input.split(" ")[0]);
            int amount = Integer.parseInt(input.split(" ")[1]);
            log.log(productNum, amount);
            basket.addToCart(productNum, amount);

            File saveFile = new File("src/Java_core/Files_csv_xml_json/src/main/java/org/example/" + xmlSettings.getSaveFileName());
            File logFile = new File("src/Java_core/Files_csv_xml_json/src/main/java/org/example/" + xmlSettings.getLogFileName());

            if (xmlSettings.isSaveEnabled()) {
                basket.saveTxt(saveFile);
            }
            if (xmlSettings.isLogEnabled()) {
                log.exportAsCSV(logFile);
            }
        }
    }
}