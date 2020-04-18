
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
        ArrayDeque<Integer> p = new ArrayDeque<>(); //12,10,3,4,11,15,16,17,20
        p.addLast(2);
        p.addLast(3);
        p.addLast(4);
        p.addLast(5);
        p.removeFirst();     //==> 2
        int result3 = p.removeLast();      //==> 5
        p.addFirst(10);
        p.addLast(11);
        p.addFirst(12);
        p.addLast(15);
        p.addLast(16);
        p.addLast(17);
        p.addLast(18);
        int result6 = p.removeLast();      //==> 18
        p.addLast(20);
        p.addFirst(21);
        int result7 = p.removeFirst();     //==> 21
        int result8 = p.get(0);
        assertEquals(12, result8);
    }
    @Test
    public void testresize() {
        ArrayDeque<Integer> p = new ArrayDeque<>();
        p.addFirst(1);
        p.addFirst(1);
        p.addFirst(1);
        p.addFirst(1);
        p.addFirst(1);
        p.addFirst(1);
        p.addFirst(1);
        p.addFirst(1);
        p.addFirst(1);
        p.addFirst(1);
        p.addFirst(1);
        p.addFirst(1);
        p.addFirst(1);
        p.addFirst(1);
        p.addLast(2);
        p.addLast(3);
        p.removeLast();
        p.removeLast();
        p.removeLast();
        p.removeLast();
        p.removeLast();
        p.removeLast();
        p.removeLast();
        p.removeLast();
        p.removeLast();
        p.removeLast();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        p.removeFirst();
        int result = p.removeFirst();
        assertEquals(1, result);
    }
}
