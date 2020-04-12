package Map61B;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;


public class ArrayMap <K,V> implements Map61B<K,V>, Iterable<K> {

    private K[] keys;
    private V[] values;
    private int size;

    public ArrayMap(){
        keys=(K[]) new Object[100];
        values=(V[])new Object[100];
        size=0;
    }

    public Iterator<K> iterator(){
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<K>{
        private int position;

        public KeyIterator(){
            position=0;
        }

        public boolean hasNext(){
            return position<size;
        }

        public K next(){
            K returnVal=keys[position];
            position++;
            return returnVal;
        }

    }

    /** Returns the index of the given key if it exists,
     * -1 otherwise. */
    private int keyIndex(K key){
        for(int i=0;i<size;i++){
            if(key.equals(keys[i])){
                return i;
            }
        }
        return -1;
    }

    /** Check to see if arrayMap contains the key*/
    public boolean containsKey(K key){
        return keyIndex(key)>=0;
    }

    /** Associate key with value*/
    public void put(K key, V value){
        int index=keyIndex(key);
        if(index>=0){
            values[index]=value;
        }else{
            keys[size]=key;
            values[size]=value;
            size++;
        }
    }

    /** Returns the value, assuming key exists */
    public V get(K key){
        int index=keyIndex(key);
        return values[index];
    }

    public List<K> keys(){
        List<K> keylist=new ArrayList<K>();
        for(int i=0;i<size;i++){
            keylist.add(keys[i]);
        }
        return keylist;
    }

    public int size(){
        return size;
    }

    public void print(){
        for(int i=0;i<size;i++){
            System.out.println(keys[i]+": "+values[i]);
        }
    }

    public static void main(String[] args){
        Map61B<String, Integer> arrayMap=new ArrayMap<String,Integer>();
        arrayMap.put("horse",3);
        arrayMap.put("fish",9);
        arrayMap.put("horse",19);
        arrayMap.print();

    }

    @Test
    public void test(){
        Map61B<String, Integer> arrayMap=new ArrayMap<String,Integer>();
        arrayMap.put("horse",3);
        arrayMap.put("fish",9);
        assertEquals(9,(int)arrayMap.get("fish"));

    }


}
