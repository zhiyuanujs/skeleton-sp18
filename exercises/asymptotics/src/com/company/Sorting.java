package com.company;

public class Sorting{
    public static <T extends Comparable<T>> void selectSort(T[] s){
        for(int i=0;i<s.length;i++){
            int minPos=i;
            for(int j=i+1;j<s.length;j++){
                if(s[minPos].compareTo(s[j])>0){
                    minPos=j;
                }
            }
            T temp=s[i];
            s[i]=s[minPos];
            s[minPos]=temp;
        }

    }

    // s1 and s2 are sorted
    public static int[] mergeSortHelper(int[] s1, int[] s2){
        int [] sortS=new int[s1.length+s2.length];

        for(int i=0,j=0,k=0;k<sortS.length;) {
            if (s1[i] < s2[j]) {
                sortS[k] = s1[i];
                i++;
            } else {
                sortS[k] = s2[j];
                j++;
            }
            k++;
            if (i == s1.length) {
                do {
                    sortS[k] = s2[j];
                    j++;
                    k++;
                } while (k < sortS.length);
            } else if (j == s2.length) {
                do {
                    sortS[k] = s1[i];
                    i++;
                    k++;
                } while (k < sortS.length);
            }

        }
        return sortS;
    }

    public static void mergeSort(int[] s){
        int i=0;
        int [][] a2=new int[100][];
        for(int j=0;j<s.length;j++) {
            a2[j] = mergeSortHelper(new int[]{s[i]}, new int[]{s[i + 1]});
            i = i + 2;
        }



    }
}
