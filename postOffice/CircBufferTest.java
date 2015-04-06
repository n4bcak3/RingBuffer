package postOffice;

import junit.framework.TestCase;
import postOffice.CircBuffer;

public class CircBufferTest extends TestCase {

    public void testStoreAndRead() throws Exception {
        CircBuffer ring = new CircBuffer(8);

        for(int i = 0; i<10; i++)
            ring.store("item"+i);

        assertEquals("item0", ring.read());
        ring.store("new item");
        ring.store("new item2");
        assertEquals("item1", ring.read());
        ring.store("new item3");
        assertEquals("item2", ring.read());
        assertEquals("item3", ring.read());
        assertEquals("item4", ring.read());
        assertEquals("item5", ring.read());
        assertEquals("item6", ring.read());

        assertEquals("new item", ring.read());
        assertEquals("new item3", ring.read());
    }

}