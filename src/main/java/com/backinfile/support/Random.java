package com.backinfile.support;

import java.util.Collection;
import java.util.List;

public class Random {
    private static final Random _instance = new Random();

    public static Random getInstance() {
        return _instance;
    }

    private final java.util.Random random;
    private int counter = 0;
    private final long seed;

    public Random() {
        this(Time.getCurMillis());
    }

    public Random(long seed) {
        this.random = new java.util.Random(seed);
        this.seed = seed;
    }

    public Random(long seed, int counter) {
        this.random = new java.util.Random(seed);
        this.seed = seed;

        for(int i = 0; i < counter; i++) {
            next(1);
        }
    }

    public int next(int bound) {
        counter++;
        return random.nextInt(bound);
    }

    public int next(int a, int b) {
        return next(b - a) + a;
    }

    public boolean nextBool() {
        return next(2) == 0;
    }

    public <T> T randItem(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        return StreamUtils.get(collection, next(collection.size()));
    }

    /**
     * 输入权重，输出一个随机的Index
     * 要求权重不小于0
     */
    public int randWeightIndex(List<Integer> weights) {
        int sum = StreamUtils.sum(weights);
        int rand = next(sum);
        for (int i = 0; i < weights.size(); i++) {
            Integer w = weights.get(i);
            if (rand < w) {
                return i;
            }
            rand -= w;
        }
        return weights.size() - 1;
    }

    public <T> T randWeight(List<Integer> weight, List<T> list) {
        return list.get(randWeightIndex(weight));
    }

    public int getCounter() {
        return counter;
    }

    public long getSeed() {
        return seed;
    }

    public Random copy() {
        return new Random(getSeed(), getCounter());
    }
}
