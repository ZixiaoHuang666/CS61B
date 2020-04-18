
import org.junit.Test;

import static org.junit.Assert.*;

public class TestArray {
    @Test
    public void testaddget() {
        ArrayDeque<Integer> p = new ArrayDeque<>(); //0,1,2,3,4,5,6,7,8
        p.addLast(0);
        p.addLast(1);
        p.addLast(2);
        p.addLast(3);
        p.addLast(4);
        p.addLast(5);
        p.addLast(6);
        p.addLast(7);
        p.addLast(8);
        int result1 = p.removeFirst();
        int result3 = p.removeFirst();
        int result2 = p.removeLast();
        int expected = 0;
        int expected2 = 8;
        int expected3 = 1;
        assertEquals(expected, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
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

    @Test
    public void testremove() {
        ArrayDeque<Integer> p = new ArrayDeque<>();
        p.addFirst(0);
        p.addFirst(1);
        int result1 = p.removeFirst();
        p.addFirst(3);
        int result2 = p.removeFirst();
        int result3 = p.removeFirst();
        assertEquals(1, result1);
        assertEquals(3, result2);
        assertEquals(0, result3);



    }
}
