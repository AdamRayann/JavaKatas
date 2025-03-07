package katas.exercises;

public class CircularBuffer {
    /**
     * Design a circular buffer (ring buffer).
     *
     * The buffer should operate in constant time.
     * When the buffer is full, adding a new element should overwrite the oldest element.
     *
     */

    private int[] buffer;
    private int head;
    private int tail;
    private int size;

    /**
     * Initializes the circular buffer with a fixed capacity.
     *
     * @param capacity the maximum number of elements the buffer can hold
     */
    public CircularBuffer(int capacity) {
        buffer=new int[capacity];
        this.head=0;
        this.tail=0;
        this.size=0;

    }

    /**
     * Adds an element to the buffer.
     *
     * @param val the value to add
     */
    public void add(int val) {
        if (size == buffer.length) {
            head = (head + 1) % buffer.length;
        } else {
            size++;
        }

        buffer[tail] = val;
        tail = (tail + 1) % buffer.length;
    }

    /**
     * Retrieves the oldest element from the buffer.
     *
     * @return the oldest element, or -1 if the buffer is empty
     */
    public int get() {
        if (isEmpty()) {
            return -1;
        }

        int value = buffer[head];
        head = (head + 1) % buffer.length;
        size--;
        return value;
    }

    /**
     * Checks if the buffer is full.
     *
     * @return true if the buffer is full, false otherwise
     */
    public boolean isFull() {

        return size==buffer.length;
    }

    /**
     * Checks if the buffer is empty.
     *
     * @return true if the buffer is empty, false otherwise
     */
    public boolean isEmpty() {

        return size==0;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        System.out.println(buffer.get()); // Output: 1
        buffer.add(4);
        System.out.println(buffer.get()); // Output: 2
        buffer.add(5);
        System.out.println(buffer.isFull()); // Output: true
    }
}


