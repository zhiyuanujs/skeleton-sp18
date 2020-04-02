import org.junit.Test;
import static org.junit.Assert.*;
public class MyArrayDequeTest {

    @Test
    public void testAddFirst() {
        ArrayDeque L = new ArrayDeque();
        int expected = 2;
        L.addFirst(2);
        int actual = (int)L.get(0);
        assertEquals(expected, actual);
        L.addFirst(3);
        expected = 3;
        actual = (int)L.get(0);
        assertEquals(expected, actual);

        L.addFirst(4);
        L.addFirst(5);
        L.addFirst(6);//at 0;
        L.addFirst(7);

    }

    @Test
    public void testAddLast(){
        ArrayDeque L=new ArrayDeque();
        L.addLast(10);
        assertEquals(10,L.get(L.size()-1));

        L.addLast(11);
        assertEquals(11,L.get(L.size()-1));

        L.addLast(12);

        L.addLast(13); //nextLast is 9

        assertEquals(4,L.size());

    }

    @Test
    public void testRemoveFirst(){

        ArrayDeque L=new ArrayDeque();
        for(int i=1;i<10;i++){
            L.addFirst(i);
            L.addLast(i);
        }
        assertEquals(18,L.size());

        int temp;
        int returnValue;
        for(int i=1;i<15;i++){
            temp=(int)L.get(0);
            returnValue=(int)L.removeFirst();
            assertEquals(temp,returnValue);
        }


    }

}
