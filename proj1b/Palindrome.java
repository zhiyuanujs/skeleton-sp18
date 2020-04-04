import static org.junit.Assert.assertFalse;

public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> L=new LinkedListDeque<>();
        int size=word.length();
        for(int i=0;i<size;i++){
            L.addLast(word.charAt(i));
        }

        return L;
    }

    public boolean isPalindrome(String word){
        Deque<Character> L = wordToDeque(word);

        Character front,back;
        while(L.size()>1){
            front=L.removeFirst();
            back=L.removeLast();

            if(front!=back)
                return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> L = wordToDeque(word);

        Character front,back;
        while(L.size()>1){
            front=L.removeFirst();
            back=L.removeLast();

            if(front<'A' || front>'z')
                return false;
            if(back<'A' || back>'z')
                return false;

            if(cc.equalChars(front,back)==false)
                return false;
        }
        return true;
        
    }
}
