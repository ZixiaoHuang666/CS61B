import org.junit.Test;
import static org.junit.Assert.*;

public class TestLinkedlist {
    @Test(timeout = 500)
    public void testget() {
        LinkedListDeque<Integer> p = new LinkedListDeque<>();
        p.addFirst(1);
        p.addFirst(2); //3,2,1,4
        p.addFirst(3);
        p.addLast(4);
        int result = p.get(2);
        int expected = 1;
        int result2 = p.getRecursive(2);
        assertEquals(expected, result);
        assertEquals(expected, result2);
    }
}


