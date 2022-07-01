package com.backinfile.support;

import java.util.Collection;
import java.util.List;

public class Random {
    private static final Random _instance = new Random();

    public static Random getInstance() {
        return _instance;
    }

    private final java.util.Random random;

    public Random() {
        this(Time.getCurMillis());
    }

    public Random(long seed) {
        random = new java.util.Random(seed);
    }

    public int next(int b) {
        return random.nextInt(b);
    }

    public int next(int a, int b) {
        return random.nextInt(b - a) + a;
    }

    public <T> T randItem(Collection<T> collection) {
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
}
