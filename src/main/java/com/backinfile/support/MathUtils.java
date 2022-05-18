package com.backinfile.support;

public class MathUtils {
    static public final float FLOAT_ROUNDING_ERROR = 0.000001f; // 32 bits
    static public final float PI = (float) Math.PI;
    static public final float PI2 = PI * 2;
    static public final float HALF_PI = PI / 2;


    static public float lerp(float fromValue, float toValue, float progress) {
        return fromValue + (toValue - fromValue) * progress;
    }

    public static float lerpInv(float cur, float from, float to) {
        if (cur < from) {
            return 0f;
        }
        if (cur > to) {
            return 1f;
        }
        return (cur - from) / (to - from);
    }


    static public short clamp(short value, short min, short max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    static public int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    static public long clamp(long value, long min, long max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    static public float clamp(float value, float min, float max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    static public double clamp(double value, double min, double max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    static public boolean isEqual(float a, float b) {
        return Math.abs(a - b) <= FLOAT_ROUNDING_ERROR;
    }

    static public boolean isZero(float value) {
        return Math.abs(value) <= FLOAT_ROUNDING_ERROR;
    }
}
