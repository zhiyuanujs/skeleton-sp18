import org.junit.Test;
import static org.junit.Assert.*;

public class OffByOne implements CharacterComparator{

    /** Returns true if characters are equal by the rules of the implementing class. */
    public boolean equalChars(char x, char y){
        int difference=Math.abs(x-y);
        if(difference==1)
            return true;

        return false;
    }
}
