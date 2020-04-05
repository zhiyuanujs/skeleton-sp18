import org.junit.Test;
import static org.junit.Assert.*;


public class TestArrayDequeGold {

    @Test
    public void testStudentArrayDeque(){
        StudentArrayDeque<Integer> sad=new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> expectedAnswer=new ArrayDequeSolution<>();

        Integer expected,actual;
        String message="\n";

        for(int i=0;i<100;i++){
            double randNumber=StdRandom.uniform();
            if(randNumber<0.5) {
                sad.addFirst(i);
                expectedAnswer.addFirst(i);
                message=message+"addFirst(" + i+")\n";
            }else{
                sad.addLast(i);
                expectedAnswer.addLast(i);
                message=message+"addLast(" + i+")\n";
            }
        }

        for(int i=0;i<100;i++){
            double randNumber=StdRandom.uniform();
            if(randNumber<0.5) {
                actual=sad.removeFirst();
                expected=expectedAnswer.removeFirst();
                message=message+"removeFirst()\n";

            }else{
                actual=sad.removeLast();
                expected=expectedAnswer.removeLast();
                message=message+"removeLast()\n";

            }
            assertEquals(message,expected, actual);

        }

    }
}
