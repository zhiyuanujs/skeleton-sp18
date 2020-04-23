package lab9;

import org.junit.Test;
import static org.junit.Assert.*;
public class MyHashMap_Test {

    @Test
    public void test(){

        MyHashMap<Integer, Integer> m=new MyHashMap<>();
        for(int i=0;i<23;i++){
            m.put(i,i+1);
        }

        assertEquals(new Integer(2),m.get(1));
        assertEquals(new Integer(12),m.get(11));

        assertNull(m.get(-1));
        assertEquals(23,m.size());

    }
}
