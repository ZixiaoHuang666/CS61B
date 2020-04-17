
public class ArrayDeque<T> {

    /**
     * item[nextfirst]=addfirst
     * item[nextlast]= addlast
     * if (nextlast == items.length){nextlast = 0;}
     * if(nextfirst == -1 ){nextfirst = items.length-1}
     */
    private int size;
    private T[] items;
    private int nextfirst;
    private int nextlast;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextfirst = 0;
        nextlast = 1;
    }

    // Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        if (nextfirst == -1) {
            nextfirst = items.length - 1;
        }
        items[nextfirst] = item;
        nextfirst--;
        size++;
    }

    //Adds an item of type T to the back of the deque
    public void addLast(T item) {

        if (nextlast == items.length) {
            nextlast = 0;
        }
        items[nextlast] = item;
        nextlast++;
        size++;
    }

    //Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return (size == 0);
    }

    //Returns the number of items in the deque.
    public int size() {
        return size <= 0 ? 0 : size;
    }

    // Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        int j = nextfirst + 1;
        for (int i = 0; i < size; i++) {
            if (j == items.length) {
                j = 0;
            }
            System.out.println(items[j] + " ");
        }
    }

    //Removes and returns the item at the front of the deque.
    // If no such item exists, returns null.
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size == items.length) {
            resize();
        }
        nextfirst++;
        T result = items[nextfirst];
        items[nextfirst] = null;
        size--;
        return result;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextlast--;
        T result = items[nextlast];
        items[nextlast] = null;
        size--;
        return result;
    }

    //Gets the item at the given index, where 0 is the front,
    // 1 is the next item, and so forth. If no such item exists,
    // returns null. Must not alter the deque!
    public T get(int index) {
        if (index + 1 + nextfirst >= items.length) {
            return (items[index + nextfirst + 1 - items.length]);
        }
        return items[nextfirst + 1 + index];
    }

    private void resize() {
        T[] resizedArray = (T[]) new Object[items.length * 2];
        System.arraycopy(items, 0, resizedArray, 0, nextfirst + 1);
        if ((nextfirst + 1) != items.length) {
            System.arraycopy(items, nextfirst + 1, resizedArray, items.length + nextfirst + 1,
                    items.length - nextfirst - 1);
        }
        items = resizedArray;
        nextfirst = nextfirst + resizedArray.length / 2;
    }


}
