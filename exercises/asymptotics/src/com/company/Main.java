package com.company;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
public class Main {

    @Test
    public void testMergeSortHelper(){
        int[] a=new int[]{1,2,3,4,5};
        int[] b=new int[]{6,7,8};
        int[] expected=new int[]{1,2,3,4,5,6,7,8};
        assertArrayEquals(expected,Sorting.mergeSortHelper(a,b));

        a=new int[]{1,20,30,40,50};
        b=new int[]{3,24,36,37,58};
        expected=new int[]{1,3,20,24,30,36,37,40,50,58};
        assertArrayEquals(expected,Sorting.mergeSortHelper(a,b));


    }


    public static void main(String[] args) {

        Random random=new Random(656545);

        Integer[] a =new Integer[100000];

        for(int i=0;i<a.length;i++){
            a[i]=random.nextInt(100);
        }


        /*
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"    ");
        }

        System.out.println();

*/
        Sorting.selectSort(a);


        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"    ");
        }




    }
}
