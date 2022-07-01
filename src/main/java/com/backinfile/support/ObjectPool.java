package com.backinfile.support;

import java.util.LinkedList;

public abstract class ObjectPool<T> {
    private final LinkedList<T> freeObjects = new LinkedList<>();

    public ObjectPool() {
    }

    public int getFreeCount() {
        return freeObjects.size();
    }

    protected abstract T newObject();

    public T obtain() {
        return freeObjects.isEmpty() ? newObject() : freeObjects.pollLast();
    }

    public void free(T obj) {
        freeObjects.addLast(obj);
    }

}
