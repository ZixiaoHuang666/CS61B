/**
 * CS61B project 1a
 *
 * @author:ZixiaoHuang
 */
public class LinkedListDeque<T> implements Deque<T>{
    private class LinkedNode {
        private T item;
        private LinkedNode next;
        private LinkedNode previous;

        LinkedNode(T item, LinkedNode next, LinkedNode previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    /**
     * sentinal.previous = first
     * sentinal.next = last
     */
    private int size;
    private LinkedNode sentinal;

    public LinkedListDeque() {
        this.sentinal = new LinkedNode(null, null, null);
        sentinal.previous = sentinal.next = sentinal;
        size = 0;
    }


    // Adds an item of type T to the front of the deque.
    @Override
    public void addFirst(T item) {

        sentinal.next = new LinkedNode(item, sentinal.next, sentinal);
        //update
        sentinal.next.next.previous = sentinal.next;
        if (size == 0) {
            sentinal.previous = sentinal.next;
        }

        size++;
    }

    //Adds an item of type T to the back of the deque
    @Override
    public void addLast(T item) {
        sentinal.previous = new LinkedNode(item, sentinal, sentinal.previous);
        sentinal.previous.previous.next = sentinal.previous;
        if (size == 0) {
            sentinal.next = sentinal.previous;
        }
        size++;
    }

    //Returns true if deque is empty, false otherwise.
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    //Returns the number of items in the deque.
    @Override
    public int size() {
        return size <= 0 ? 0 : size;
    }

    // Prints the items in the deque from first to last, separated by a space.
    @Override
    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        LinkedNode p = sentinal;
        for (int i = 0; i < size; i++) {
            System.out.println(p.next.item + " ");
            p = p.next;
        }
    }

    //Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    @Override
    public T removeFirst() {
        if (sentinal.next == null) {
            return null;
        }
        T result = sentinal.next.item;
        sentinal.next = sentinal.next.next;
        sentinal.next.previous = sentinal;
        size--;
        return result;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    @Override
    public T removeLast() {
        if (sentinal.previous == null) {
            return null;
        }
        T result = sentinal.previous.item;
        sentinal.previous = sentinal.previous.previous;
        sentinal.previous.next = sentinal;
        size--;
        return result;
    }

    //Gets the item at the given index, where 0 is the front,
    // 1 is the next item, and so forth. If no such item exists,
    // returns null. Must not alter the deque!
    @Override
    public T get(int index) {
        if (index >= size || size == 0) {
            return null;
        }
        LinkedNode p = sentinal.next;
        while (index != 0) {
            p = p.next;
            index--;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index >= size || size == 0) {
            return null;
        }
        return getRecursive(index, sentinal.next);
    }

    private T getRecursive(int r, LinkedNode A) {
        if (r == 0) {
            return A.item;
        }
        return getRecursive(r - 1, A.next);
    }

}
