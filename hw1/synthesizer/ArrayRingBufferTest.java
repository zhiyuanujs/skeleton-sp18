package synthesizer;

import org.junit.Test;
import static org.junit.Assert.*;
public class ArrayRingBufferTest {

    @Test
    public void testAll(){

        ArrayRingBuffer<Integer> a=new ArrayRingBuffer<>(7);

        a.enqueue(10);
        a.enqueue(20);
        a.enqueue(30);


        assertEquals(3,a.fillCount());
        assertEquals(7,a.capacity());
        Integer out=a.dequeue();
        assertEquals((Integer)10,out);
        out=a.dequeue();
        assertEquals((Integer)20,out);
        assertEquals((Integer)30,a.peek());
        a.dequeue();

        for(int i=0;i<7;i++){
            a.enqueue(i);
        }

        for(Integer i: a){
            System.out.println(i);
        }
    }

}
