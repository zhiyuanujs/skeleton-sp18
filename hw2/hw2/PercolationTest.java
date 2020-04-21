package hw2;
import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationTest {

    @Test
    public void testAll(){
        Percolation p=new Percolation(100);

        p.open(30,40);
        p.open(40,50);
        p.open(0,20);
        p.open(1,20);
        p.open(2,20);
        p.open(4,20);

        p.open(2,20);

        assertTrue(p.isOpen(0,20));
        assertFalse(p.isOpen(0,21));
        assertTrue(p.isOpen(30,40));
        assertTrue(p.isOpen(40,50));
        assertFalse(p.isOpen(50,40));

        assertTrue(p.isFull(0,20));
        assertTrue(p.isFull(2,20));
        assertFalse(p.isFull(4,20));
        assertFalse(p.isFull(32,40));
        assertFalse(p.isFull(0,0));

        assertEquals(6,p.numberOfOpenSites());


        assertFalse(p.percolates());

        for(int i=0;i<100;i++)
            p.open(i,55);

        assertTrue(p.percolates());




    }
}
