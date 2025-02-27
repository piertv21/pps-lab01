package model;

import tdd.CircularQueue;
import java.util.ArrayList;
import java.util.List;

public class CircolarQueue implements CircularQueue {

    private final int capacity;
    private final List<Integer> queue;

    public CircolarQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        if (this.size() >= this.capacity) {
            this.queue.removeFirst();
        }
        this.queue.add(element);
    }

    @Override
    public int remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return this.queue.removeFirst();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
