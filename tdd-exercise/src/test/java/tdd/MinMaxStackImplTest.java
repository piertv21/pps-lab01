package tdd;

import model.MinMaxStackImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    private static final int TEST_VALUE = 1;
    private MinMaxStack minMaxStack;

    @BeforeEach
    void beforeEach(){
        minMaxStack = new MinMaxStackImpl();
    }

    @Test
    public void testStackEmpty(){
        assertTrue(minMaxStack.isEmpty());
    }

    @Test
    public void testPush(){
        minMaxStack.push(TEST_VALUE);
        assertFalse(minMaxStack.isEmpty());
    }

    @Test
    public void testPeek(){
        minMaxStack.push(TEST_VALUE);
        int firstPeek = minMaxStack.peek();
        int secondPeek = minMaxStack.peek();
        assertEquals(firstPeek, secondPeek);
    }

    @Test
    public void testPop(){
        minMaxStack.push(TEST_VALUE);
        int poppedValue = minMaxStack.pop();
        assertTrue(minMaxStack.isEmpty());
        assertEquals(TEST_VALUE, poppedValue);
    }

    @Test
    public void testGetMin(){
        minMaxStack.push(2);
        minMaxStack.push(1);
        minMaxStack.push(3);
        assertEquals(1, minMaxStack.getMin());
    }

    @Test
    public void testGetMax(){
        minMaxStack.push(2);
        minMaxStack.push(1);
        minMaxStack.push(3);
        assertEquals(3, minMaxStack.getMax());
    }

    @Test
    public void testGetMinAndMaxWithEmptyStack(){
        assertEquals(Integer.MIN_VALUE, minMaxStack.getMin());
        assertEquals(Integer.MAX_VALUE, minMaxStack.getMax());
    }
}