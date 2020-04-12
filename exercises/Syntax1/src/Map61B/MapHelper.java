package Map61B;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
public class MapHelper {

    /** returns the value corresponding to the given key,
     * if it does not exists, return null;
     */
    public static <K,V> V get(Map61B<K,V> sim, K key ){
        if(sim.containsKey(key))
            return sim.get(key);
        return null;
    }

    /**Return the maximum of all keys in the given arrayMap*/
    public static <K extends Comparable<K>,V> K maxKey(Map61B<K,V> m){
        List<K> keylist=m.keys();
        K largest=keylist.get(0);
        for(K k: keylist){
            if(largest.compareTo(k)<0)
                largest=k;
        }
        return largest;
    }


    @Test
    public void testMaxKey(){
        Map61B<String, Integer> arrayMap=new ArrayMap<String,Integer>();
        arrayMap.put("horse",3);
        arrayMap.put("fish",9);
        String actual=MapHelper.maxKey(arrayMap);
        assertEquals("horse",actual);
    }

    @Test
    public void testGet(){
        Map61B<String, Integer> arrayMap=new ArrayMap<String,Integer>();
        arrayMap.put("horse",3);
        arrayMap.put("fish",9);

        assertEquals((Integer)9,MapHelper.get(arrayMap,"fish"));
        assertEquals(null,MapHelper.get(arrayMap,"fdsf a"));

    }



}
