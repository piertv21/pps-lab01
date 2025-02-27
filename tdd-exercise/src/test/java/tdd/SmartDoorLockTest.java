package tdd;

import model.SmartDoorLockImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final int TEST_PIN = 1234;
    public static final int WRONG_TEST_PIN = 4321;

    private SmartDoorLock smartDoorLock;

    @BeforeEach
    void beforeEach(){
        smartDoorLock = new SmartDoorLockImpl();
    }

    @Test
    public void testDoorIsInitiallyUnlocked() {
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testSetPin() {
        smartDoorLock.setPin(TEST_PIN);
        smartDoorLock.unlock(TEST_PIN);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testDoorIsLocked() {
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    public void testDoorIsUnlocked() {
        smartDoorLock.unlock(TEST_PIN);
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    public void testUnlockWithWrongPin() {
        smartDoorLock.lock();
        smartDoorLock.unlock(WRONG_TEST_PIN);
        assertAll(
                () -> assertTrue(smartDoorLock.isLocked()),
                () -> assertEquals(1, smartDoorLock.getFailedAttempts())
        );
    }

    @Test
    public void testBlockTheDoor() {
        smartDoorLock.lock();
        int maxAttempts = smartDoorLock.getMaxAttempts();
        for (int i = 0; i < maxAttempts; i++) {
            smartDoorLock.unlock(WRONG_TEST_PIN);
        }
        assertAll(
                () -> assertTrue(smartDoorLock.isBlocked()),
                () -> assertEquals(maxAttempts, smartDoorLock.getFailedAttempts())
        );
    }

    @Test
    public void testResetDoor() {
        smartDoorLock.reset();
        assertAll(
                () -> assertFalse(smartDoorLock.isLocked()),
                () -> assertEquals(0, smartDoorLock.getFailedAttempts())
        );
        smartDoorLock.unlock(TEST_PIN);
        assertAll(
                () -> assertNotEquals(0, smartDoorLock.getFailedAttempts()),
                () -> assertFalse(smartDoorLock.isBlocked())
        );
    }
}
