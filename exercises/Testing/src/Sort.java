public class Sort {
    /**
     * Sorts string destructively
     */
    /**
     * find the smallest from some index
     */
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i++) {
            if (x[i].compareTo(x[smallestIndex]) < 0)
                smallestIndex = i;
        }

        return smallestIndex;

    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    /**
     * Sorts x starting at position start.
     */
    public static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }

        int smallest = findSmallest(x,start);
        swap(x, smallest, start);
        sort(x, start + 1);
    }

    public static void sort(String[] x) {
        sort(x, 0);


    }


    /*
    public static void sort(String[] x) {
        int min;
        String exchange;
        int i,j;
        for (i = 1; i < x.length; i++){
            min=i-1;
            for (j = i; j < x.length; j++) {
                if (x[min].compareTo(x[j]) > 0)
                    min = j;
            }
            exchange=x[min];
            x[min]=x[i-1];
            x[i-1]=exchange;
            }
    }

     */

}
