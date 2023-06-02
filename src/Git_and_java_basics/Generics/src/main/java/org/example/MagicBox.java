package org.example;

import java.util.Random;

public class MagicBox<T> {

    protected T[] box;

    public MagicBox(int count) {
        this.box = (T[]) new Object[count];
    }


    protected boolean add(T item) {
        for (int i = 0; i < box.length; i ++) {
            if (box[i] == null) {
                box[i] = item;
                return true;
            }
        }
        return false;
    }

    protected T pick() {
        int count = 0;
        for (T boxItem : box) {
            if (boxItem == null) {
                count++;
            }
        }
        if (count > 0) {
            throw new RuntimeException("Коробка не полна, осталось " + count + " ячеек");
        } else {
            return box[new Random().nextInt(box.length)];
        }
    }

}
