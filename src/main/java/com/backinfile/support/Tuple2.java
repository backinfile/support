package com.backinfile.support;

public class Tuple2<T1, T2> {
	public final T1 value1;
	public final T2 value2;

	public Tuple2(T1 value1, T2 value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	@Override
	public String toString() {
		return "<" + value1.toString() + "," + value2.toString() + ">";
	}
}
