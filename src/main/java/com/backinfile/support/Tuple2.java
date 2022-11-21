package com.backinfile.support;

public class Tuple2<T1, T2> {
    public final T1 value1;
    public final T2 value2;

    public Tuple2(T1 value1, T2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public static <T1, T2> Tuple2<T1, T2> of(T1 value1, T2 value2) {
        return new Tuple2<>(value1, value2);
    }


    public T1 getValue1() {
        return value1;
    }

    public T2 getValue2() {
        return value2;
    }

    @Override
    public String toString() {
        return "<" + value1.toString() + "," + value2.toString() + ">";
    }
}
