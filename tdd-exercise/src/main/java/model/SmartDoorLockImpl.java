package model;

import tdd.SmartDoorLock;

public class SmartDoorLockImpl implements SmartDoorLock {

    private static final int MAX_ATTEMPTS = 3;
    private static final int DEFAULT_PIN = -1;

    private boolean doorLockedState;
    private boolean doorBlockedState;
    private int pin;
    private int failedAttempts;

    public SmartDoorLockImpl() {
        this.doorLockedState = false;
    }

    @Override
    public void setPin(int pin) {
        if(!this.doorLockedState && !this.doorBlockedState) {
            this.pin = pin;
        }
    }

    @Override
    public void unlock(int pin) {
        if (this.pin == pin) {
            this.doorLockedState = false;
            this.failedAttempts = 0;
        } else {
            this.failedAttempts++;
            if (this.failedAttempts >= MAX_ATTEMPTS) {
                this.doorBlockedState = true;
            }
        }
    }

    @Override
    public void lock() {
        if(this.pin != DEFAULT_PIN) {
            this.doorLockedState = true;
        } else throw new IllegalStateException("PIN is not set");
    }

    @Override
    public boolean isLocked() {
        return this.doorLockedState;
    }

    @Override
    public boolean isBlocked() {
        return this.doorBlockedState;
    }

    @Override
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {
        this.pin = DEFAULT_PIN;
        this.failedAttempts = 0;
        this.doorBlockedState = false;
        this.doorLockedState = false;
    }
}
