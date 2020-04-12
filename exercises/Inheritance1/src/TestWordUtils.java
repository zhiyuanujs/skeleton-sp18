import org.junit.Test;
import static org.junit.Assert.*;
public class TestWordUtils {

    @Test
    public void testFindLonges(){

        List61B<String> s=new SLList<>();
        s.addLast("Hello");
        s.addLast("Nice to meet you");
        s.addFirst("This");

        assertEquals("Nice to meet you",WordUtils.findLongest(s));

        List61B<String> aList=new AList<>();
        s.addLast("Hello");
        s.addLast("Nice to meet you");
        s.addLast("tHIS");

        assertEquals("Nice to meet you",WordUtils.findLongest(s));


    }

    public static void main(String [] args){
        List61B <String> s=new SLList<>();
        s.addLast("Hello");
        s.addLast("Nice to meet you");
        s.addFirst("This");

        s.print();

    }

}
