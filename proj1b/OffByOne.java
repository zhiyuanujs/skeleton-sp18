import org.junit.Test;
import static org.junit.Assert.*;

public class OffByOne implements CharacterComparator{

    private char toLowerCase(char x){
        if(x>='A' && x<='Z')
            return (char)(x+('a'-'A'));
        return x;
    }

    /** Returns true if characters are equal by the rules of the implementing class. */
    public boolean equalChars(char x, char y){
        x=toLowerCase(x);
        y=toLowerCase(y);
        int difference=Math.abs(x-y);
        if(difference==1)
            return true;

        return false;
    }
}
