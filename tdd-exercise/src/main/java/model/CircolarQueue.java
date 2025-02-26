package model;

import tdd.CircularQueue;

import java.util.ArrayList;
import java.util.List;

public class CircolarQueue implements CircularQueue {

    private static final int CAPACITY = 3;
    List<Integer> queue;
    int currentIndex;

    public CircolarQueue() {
        this.queue = new ArrayList<>();
        this.currentIndex = 0;
    }

    @Override
    public void add(int element) {
        queue.add(element);
        this.currentIndex = (this.currentIndex + 1) % CAPACITY;
    }

    @Override
    public int remove() {
        if(queue.get(this.currentIndex + 1) != null) {
            return queue.remove(this.currentIndex + 1);
        }
    }

    @Override
    public int getOldest() {
        return 0;
    }

    @Override
    public int getNewest() {
        return 0;
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
