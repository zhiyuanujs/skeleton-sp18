
/** Tests the Sort class. */
public class TestSort {

    @org.junit.Test
    public void testFindSmallest(){
        String[] input={"an","i", "have","egg"};
        int expected=3;

        int actual=Sort.findSmallest(input,1);
        org.junit.Assert.assertEquals(expected,actual);

    }
    @org.junit.Test
    public void testSwap(){
        String[] input={"i", "have","an","egg"};
        Sort.swap(input,0,3);
        String []expected={"eg","have","an","i"};

        org.junit.Assert.assertArrayEquals(expected,input);

    }

    /** Test the Sort.sort method. */
    @org.junit.Test
    public void testSort(){
        String[] input={"i", "have","an","egg"};
        String[] expected={"an","egg","have","i"};

        Sort.sort(input);
        org.junit.Assert.assertArrayEquals(expected,input);
    }



}
