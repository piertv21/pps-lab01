package model;

import tdd.CircularQueue;

import java.util.ArrayList;
import java.util.List;

public class CircolarQueue implements CircularQueue {

    private static final int INITIAL_INDEX = 0;

    List<Integer> queue;
    int capacity;
    int currentIndex;
    int headIndex;

    public CircolarQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayList<>();
        this.initQueueIndexes();
    }

    private void initQueueIndexes() {
        this.currentIndex = INITIAL_INDEX;
        this.headIndex = INITIAL_INDEX;
    }

    @Override
    public void add(int element) {
        if (this.queue.size() < this.capacity) {
            this.queue.add(element);
        } else {
            this.queue.set(this.currentIndex, element);
            this.headIndex = (this.headIndex + 1) % this.capacity;
        }
        this.currentIndex = (this.currentIndex + 1) % this.capacity;
    }

    @Override
    public int remove() {
        if (this.queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int removedElement = this.queue.get(this.headIndex);
        this.queue.remove(this.headIndex);
        if (this.queue.isEmpty()) {
            this.initQueueIndexes();
        } else {
            this.headIndex = this.headIndex % this.queue.size();
        }
        return removedElement;
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
