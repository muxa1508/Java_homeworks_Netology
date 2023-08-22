package org.example;

import java.util.Iterator;
import java.util.Random;


public class Randoms implements Iterable<Integer> {
    private final int min;
    private final int max;
    protected Random random;

    public Randoms(int min, int max) {
        random = new Random();
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return random.nextInt(max + 1 - min) + min;
            }
        };
    }
}
