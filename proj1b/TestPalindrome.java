import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){

        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));

        assertFalse(palindrome.isPalindrome("abc"));
        assertFalse(palindrome.isPalindrome("horseh"));

    }

    @Test
    public void testIsPalindromeByOneOff(){
        OffByOne offByOne=new OffByOne();
        assertTrue(palindrome.isPalindrome("flake",offByOne));
        assertTrue(palindrome.isPalindrome("a",offByOne));
        assertTrue(palindrome.isPalindrome("",offByOne));
        assertFalse(palindrome.isPalindrome("flakez",offByOne));
        assertFalse(palindrome.isPalindrome("abc",offByOne));
        assertFalse(palindrome.isPalindrome("&%",offByOne));

    }
}
