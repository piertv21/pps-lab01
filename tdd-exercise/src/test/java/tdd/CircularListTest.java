package tdd;

import model.CircolarQueue;
import model.MinMaxStackImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircolarQueue queue;

    @BeforeEach
    void beforeEach(){
        queue = new CircolarQueue();
    }

    @Test
    public void testEmptyQueue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testAddElement() {
        queue.add(1);
        assertEquals(1, queue.size());
    }

    @Test
    public void testRemoveElement() {
        queue.add(1);
        queue.remove();
        assertEquals(0, queue.size());
    }

}
