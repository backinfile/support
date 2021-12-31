package com.backinfile.support.event;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public abstract class AbstractEventHandler<Param> {
    protected final HashMap<Integer, PriorityQueue<Event>> eventMap = new HashMap<>();


    protected static class Event {
        public int key;
        public Object subKey; // 当不为空时，与key一起组成事件的键值
        public int priority;
        public Object observer;
    }

    /**
     * 触发事件
     *
     * @param subKey 不为空时，与eventKey一起组成键值
     * @return ture if any observer invoked
     */
    public boolean fire(int eventKey, Object subKey, Param param) {
        if (!eventMap.containsKey(eventKey)) {
            return false;
        }
        boolean handled = false;
        Queue<Event> queue = eventMap.get(eventKey);
        for (Event event : queue) {
            if (checkSubKey(event.subKey, subKey)) {
                handled = true;
                if (handleEvent(event.observer, param)) {
                    break;
                }
            }
        }
        return handled;
    }

    protected boolean checkSubKey(Object origin, Object fire) {
        if (origin == fire) {
            return true;
        }
        if (origin != null) {
            return origin.equals(fire);
        }
        return false;
    }

    /**
     * 注册事件
     */
    public void register(int eventKey, Object observer) {
        register(eventKey, null, 1000, observer);
    }

    /**
     * 注册事件
     *
     * @param subKey   不为空时，与eventKey一起组成键值
     * @param priority 从小到大触发
     */
    public void register(int eventKey, Object subKey, int priority, Object observer) {
        Queue<Event> queue = eventMap.computeIfAbsent(eventKey,
                key -> new PriorityQueue<>(Comparator.comparingInt(a -> a.priority)));
        Event event = new Event();
        event.key = eventKey;
        event.subKey = subKey;
        event.priority = priority;
        event.observer = observer;
        queue.add(event);
    }

    /**
     * @return true-阻止之后的事件继续触发
     */
    protected abstract boolean handleEvent(Object observer, Param param);

}
