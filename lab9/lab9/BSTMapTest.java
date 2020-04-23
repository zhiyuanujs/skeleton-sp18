package lab9;
import org.junit.Test;
import static org.junit.Assert.*;


public class BSTMapTest {

    @Test
    public void testPutGet(){
        BSTMap<Integer,String> bstMap=new BSTMap<>();

        bstMap.put(10,"b");
        bstMap.put(1,"a");
        bstMap.put(100,"c");

        assertEquals("a",bstMap.get(1));
        assertEquals("b",bstMap.get(10));
        assertEquals("c",bstMap.get(100));

        assertNull(bstMap.get(0));
        assertEquals(3,bstMap.size());

        bstMap.put(200,"d");

        assertEquals("b",bstMap.remove(10));

        assertEquals(3,bstMap.size());

        assertEquals("c",bstMap.remove(100));

    }
}
