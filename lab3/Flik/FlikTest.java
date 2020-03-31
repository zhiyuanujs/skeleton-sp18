import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void testIsSameNumber(){

        Integer a=new Integer(10);
        Integer b=new Integer(10);



        int c=128,d=128;
        assertTrue(Flik.isSameNumber(c,d));
        assertTrue(Flik.isSameNumber(a,b));

    }

}
