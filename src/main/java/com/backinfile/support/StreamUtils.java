package com.backinfile.support;

import com.backinfile.support.func.Action1;
import com.backinfile.support.func.Function1;
import com.backinfile.support.func.Predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class StreamUtils {
    public static <T, R> List<R> map(Collection<T> collection, Function1<R, T> function) {
        List<R> result = new ArrayList<>(collection.size());
        for (T t : collection) {
            result.add(function.invoke(t));
        }
        return result;
    }

    public static <T, R> void map(Collection<T> collection, Action1<T> function) {
        for (T t : collection) {
            function.invoke(t);
        }
    }

    public static <T> List<T> filter(Collection<T> collection, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : collection) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static <T> boolean any(Collection<T> collection, Predicate<T> predicate) {
        for (T t : collection) {
            if (predicate.test(t)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean all(Collection<T> collection, Predicate<T> predicate) {
        for (T t : collection) {
            if (!predicate.test(t)) {
                return false;
            }
        }
        return true;
    }

    public static <T> T get(Collection<T> collection, int index) {
        if (collection instanceof List) {
            return ((List<T>) collection).get(index);
        }
        Iterator<T> iterator = collection.iterator();
        for (int i = 0; i < index; i++) {
            iterator.next();
        }
        return iterator.next();
    }

    public static <T> T getAny(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        return get(collection, 0);
    }

    public static int sum(Collection<Integer> integers) {
        int result = 0;
        for (Integer integer : integers) {
            result += integer;
        }
        return result;
    }

    public static <T> ArrayList<T> slice(List<T> list, int fromIndex) {
        return slice(list, fromIndex, list.size());
    }

    public static <T> ArrayList<T> slice(List<T> list, int fromIndex, int toIndex) {
        ArrayList<T> result = new ArrayList<>();
        if (fromIndex >= list.size()) {
            return result;
        }
        toIndex = Math.min(toIndex, list.size());
        for (; fromIndex < toIndex; fromIndex++) {
            result.add(list.get(fromIndex));
        }
        return result;
    }

}
