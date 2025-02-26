package model;

import tdd.MinMaxStack;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackImpl implements MinMaxStack {

    List<Integer> stack;
    int min;
    int max;

    public MinMaxStackImpl() {
        this.stack = new ArrayList<>();
        this.resetMinMax();
    }

    private void resetMinMax() {
        this.min = Integer.MIN_VALUE;
        this.max = Integer.MAX_VALUE;
    }

    private void updateMinMax(int value) {
        this.min = Math.min(this.min, value);
        this.max = Math.max(this.max, value);
    }

    @Override
    public void push(int value) {
        this.stack.add(value);
        if (this.stack.size() == 1) { // First element
            this.min = value;
            this.max = value;
        } else {
            this.updateMinMax(value);
        }
    }

    @Override
    public int pop() {
        int removed = this.stack.removeLast();
        if (this.stack.isEmpty()) { // Empty stack
            this.resetMinMax();
        } else if (removed == this.min || removed == this.max) {
            this.resetMinMax();
            for (int num : this.stack) {
                this.updateMinMax(num);
            }
        }
        return removed;
    }

    @Override
    public int peek() {
        return this.stack.getLast();
    }

    @Override
    public int getMin() {
        return this.min;
    }

    @Override
    public int getMax() {
        return this.max;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
