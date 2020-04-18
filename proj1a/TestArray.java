
import org.junit.Test;

import static org.junit.Assert.*;

public class TestArray {
    @Test
    public void testaddget() {
        ArrayDeque<Integer> p = new ArrayDeque<>(); //3,2,1,4,5
        p.addFirst(0);
        p.addFirst(0);
        p.addFirst(0);
        p.addLast(0);
        p.addLast(0);
        p.addLast(0);
        p.addLast(0);
        p.addLast(0);
        int result = p.get(0);
        int result2 = p.get(7);
        int expected = 0;
        int expected2 = 0;
        assertEquals(expected, result);
        assertEquals(expected2, result2);
    }

    @Test
    public void testget() {
        ArrayDeque<Integer> p = new ArrayDeque<>();
        p.addFirst(0);
        p.addLast(1);
        p.removeFirst();
        p.removeFirst();
        p.addFirst(4);
        p.removeLast();
        p.addLast(6);
        p.addFirst(7);
        p.removeLast();
        p.get(0);
        p.addLast(10);
        p.removeFirst();
        int result = p.get(0);
        int expected = 10;
        assertEquals(expected, result);
    }
}
