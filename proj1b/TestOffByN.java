import org.junit.Test;
import static org.junit.Assert.*;


public class TestOffByN {

    @Test
    public void testEqualCharsByN(){

        OffByN offByN=new OffByN(5);

        assertTrue(offByN.equalChars('a','f'));
        assertTrue(offByN.equalChars('f','a'));
        assertFalse(offByN.equalChars('a','z'));
        assertFalse(offByN.equalChars(' ','m'));

    }

}
