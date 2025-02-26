package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Add an element to the queue.
     *
     * @param element the element to add.
     */
    void add(int element);

    /**
     * Remove the oldest element from the queue.
     *
     * @return the oldest element.
     */
    int remove();

    /**
     * Get the oldest element from the queue.
     *
     * @return the oldest element.
     */
    int getOldest();

    /**
     * Get the newest element from the queue.
     *
     * @return the newest element.
     */
    int getNewest();

    /**
     * Get the size of the queue.
     *
     * @return the size of the queue.
     */
    int size();

    /**
     * Check if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();

}