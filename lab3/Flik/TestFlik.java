import static org.junit.Assert.*;
import org.junit.Test;
public class TestFlik {
    @Test
    public void testFlik(){
        int i =128;
        int j =128;
        boolean result = Flik.isSameNumber(i, j);
        boolean expected = true;
        assertEquals(expected,result);

    }
}
