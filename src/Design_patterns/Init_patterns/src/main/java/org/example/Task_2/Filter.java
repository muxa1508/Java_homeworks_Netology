package org.example.Task_2;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");
        List<Integer> result = new ArrayList<>();
        for (Integer i : source) {
            if (i < treshold) {
                result.add(i);
                logger.log("Элемент \"" + i + "\" проходит");
            } else {
                logger.log("Элемент \"" + i + "\" не проходит");
            }
        }
        logger.log("Прошло фильтр " + result.size() + " элемента из " + source.size());
        return result;
    }
}
