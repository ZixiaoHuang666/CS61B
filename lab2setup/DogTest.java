import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DogTest {    
    @Test
    public void testSmall() {
        Dog d = new Dog(3);
        assertEquals("yip", d.noise());
    }

    @Test
    public void testLarge() {
        Dog d = new Dog(20);
        assertEquals("bark", d.noise());
    }

    @Test
    public void testStatic() {
        Dog poppa = new Dog(3);
        poppa.bark();
//        Dog.bark();
        poppa.runFast();
        Dog.runFast();
    }

}
