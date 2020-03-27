package com.company;

/* Invariants:
 addLast: The next item we want to add, will go into position size.
 */

public class AList {
    private int[] items;
    private int size;

    /** Create an empty List. */
    public AList(){
        size=0;
        items=new int[100];
    }

    /** Inserts X into the back of the list*/
    public void addLast(int x){
        items[size]=x;
        size++;
    }

    /** Returns the item from the back of the list.*/
    public int getLast(){
        return items[size-1];
    }

    /** Gets the ith item in the list (0 is the front). */
    public int get(int i){
        return items[i];
    }

    /**Return the number of items in the list. */
    public int size(){
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast(){
        size--;
        return items[size];
    }

    public static void main(String[] args) {
        AList L=new AList();
        L.addLast(10);
        L.addLast(20);
        L.addLast(30);
        System.out.println(L.get(1));
        System.out.println(L.size());
        System.out.println(L.removeLast());
        System.out.println(L.getLast());

    }
}
