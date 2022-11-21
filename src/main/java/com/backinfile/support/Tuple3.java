package com.backinfile.support;

public class Tuple3<T1, T2, T3> {
    public final T1 value1;
    public final T2 value2;
    public final T3 value3;

    public Tuple3(T1 value1, T2 value2, T3 value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 value1, T2 value2, T3 value3) {
        return new Tuple3<>(value1, value2, value3);
    }

    public T1 getValue1() {
        return value1;
    }

    public T2 getValue2() {
        return value2;
    }

    public T3 getValue3() {
        return value3;
    }

    @Override
    public String toString() {
        return "<" + value1.toString() + "," + value2.toString() + "," + value3.toString() + ">";
    }
}
