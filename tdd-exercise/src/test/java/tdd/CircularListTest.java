package tdd;

import model.CircolarQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int CAPACITY = 3;
    CircolarQueue queue;

    @BeforeEach
    void beforeEach(){
        queue = new CircolarQueue(CAPACITY);
    }

    @Test
    public void testEmptyQueue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testAddElement() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        assertEquals(CAPACITY, queue.size());
    }

    @Test
    public void testRemoveElement() {
        queue.add(1);
        queue.remove();
        assertEquals(0, queue.size());
    }

    @Test
    public void testRemoveOldestElements() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        assertAll(
                () -> assertEquals(3, queue.remove()),
                () -> assertEquals(4, queue.remove()),
                () -> assertEquals(5, queue.remove())
        );
    }

}
