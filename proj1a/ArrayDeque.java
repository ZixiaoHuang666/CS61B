
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
        if (nextfirst == nextlast) {
            resize(2 * items.length);
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
        if (nextfirst == nextlast) {
            resize(2 * items.length);
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

        nextfirst++;
        if (nextfirst >= items.length) {
            nextfirst = nextfirst - items.length;
        }
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
        if (nextlast < 0) {
            nextlast = nextlast + items.length;
        }
        T result = items[nextlast];
        items[nextlast] = null;
        size--;
        return result;
    }

    //Gets the item at the given index, where 0 is the front,
    // 1 is the next item, and so forth. If no such item exists,
    // returns null. Must not alter the deque!
    public T get(int index) {
        if (index > items.length || items == null) {
            return null;
        }
        if (nextfirst + index < items.length) {
            return items[nextfirst + index + 1];
        } else {
            return items[nextfirst + index + 1 - items.length];
        }

    }

    private void resize(int compacity) {
        T[] items2 = (T[]) new Object[compacity];
        if (nextfirst != 0) {
            System.arraycopy(items, 0, items2, 0, nextlast);
            int number = items.length - nextfirst - 1;
            System.arraycopy(items, nextfirst + 1, items2, items2.length - number, number);
            nextfirst = nextfirst + items2.length - items.length;
        } else {
            System.arraycopy(items, 0, items2, 0, items.length);
            nextlast = items.length;
        }
        items = items2;
    }


}
