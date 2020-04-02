import org.junit.Test;
import static org.junit.Assert.*;
public class MyLinkedListDequeTest {

    @Test
    public void testAddFirst(){
        LinkedListDeque<Integer> L=new LinkedListDeque<>();
        int expected=2;
        L.addFirst(2);
        int actual=L.get(0);
        assertEquals(expected,actual);
        L.addFirst(3);
        expected=3;
        actual=L.get(0);
        assertEquals(expected,actual);
    }

    @Test
    public void testAddLast(){
        LinkedListDeque<Integer> L=new LinkedListDeque<>();
        int expected=2;
        L.addLast(2);
        int actual=L.get(0);
        assertEquals(expected,actual);
        L.addFirst(30);
        L.addLast(3);
        expected=3;
        actual=L.get(2);
        assertEquals(expected,actual);
    }

    @Test
    public void testIsEmpty(){
        LinkedListDeque<Integer> L=new LinkedListDeque<>();

        assertTrue(L.isEmpty());

        L.addLast(10);
        assertFalse(L.isEmpty());

    }

    @Test
    public void testSize(){
        LinkedListDeque<Integer> L=new LinkedListDeque<>();
        assertEquals(0,L.size());

        L.addFirst(10);
        assertEquals(1,L.size());

        L.addLast(20);
        assertEquals(2,L.size());
    }

    @Test
    public void testRemoveFirst(){
        LinkedListDeque<Integer> L=new LinkedListDeque<>();
        L.addFirst(10);
        L.addLast(20);
        L.addLast(30);
        L.addFirst(1);

        int actual=L.removeFirst();
        assertEquals(1,actual);

        actual=L.get(0);
        assertEquals(10,actual);

        LinkedListDeque<Integer> N=new LinkedListDeque<>();
        Integer act=N.removeFirst();
        assertNull(act);

    }

    @Test
    public void testRemoveLast() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(10);
        L.addLast(20);
        L.addLast(30);
        L.addFirst(1);

        int actual=L.removeLast();
        assertEquals(30,actual);
        actual=L.get(L.size()-1);
        assertEquals(20,actual);

        LinkedListDeque<Integer> N=new LinkedListDeque<>();
        Integer act=N.removeLast();
        assertNull(act);

    }

    @Test
    public void testGet(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        Integer act=L.get(3);
        assertNull(act);

        L.addFirst(10);
        L.addLast(20);
        L.addLast(30);
        L.addFirst(1);

        act=L.get(4);
        assertNull(act);

        int actual=L.get(3);
        assertEquals(30,actual);

    }

    @Test
    public void testGetRecursive(){
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        Integer act=L.getRecursive(3);
        assertNull(act);

        L.addFirst(10);
        L.addLast(20);
        L.addLast(30);
        L.addFirst(1);

        act=L.getRecursive(4);
        assertNull(act);

        int actual=L.getRecursive(3);
        assertEquals(30,actual);

    }

    public static void main(String [] args){
        LinkedListDeque<Integer> L=new LinkedListDeque<>();
        L.addFirst(20);
        L.addLast(30);
        L.addFirst(10);
        L.addLast(40);
        L.printDeque();
        L.removeFirst();
        L.printDeque();

        System.out.println(L.getRecursive(0));

        LinkedListDeque<Integer> N=new LinkedListDeque<>();
        N.addFirst(10);
        System.out.println(N.removeFirst());
        N.printDeque();


    }

}
