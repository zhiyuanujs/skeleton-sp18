
/* Invariants:
 addLast: The next item we want to add, will go into position size.
 */

public class AList<Type> implements List61B<Type>{
    private Type[] items;
    private int size;

    /** Create an empty List. */
    public AList(){
        size=0;
        items=(Type[]) new Object[100];
    }

    /** Resize the underlying array to the target capacity.*/
    private void resize(){
        Type [] a=(Type[]) new Object [size*2];
        System.arraycopy(items,0,a,0,size);
        items=a;
    }

    /** add a value to the front of the  array**/
    public void addFirst(Type x){



    }

    /** return the value in the front of the array **/
    public Type getFirst(){

        return null;
    }


    /** Inserts X into the back of the list*/
    public void addLast(Type x){
        if(size==items.length)
            resize();
        items[size] = x;
        size++;
    }

    /** Returns the item from the back of the list.*/
    public Type getLast(){
        return items[size-1];
    }

    /** Gets the ith item in the list (0 is the front). */
    public Type get(int i){
        return items[i];
    }

    /**Return the number of items in the list. */
    public int size(){
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public Type removeLast(){
        items[size-1]=null;
        size--;
        return items[size];
    }

    public static void main(String[] args) {
        AList<Double> L=new AList<>();
        /*
        L.addLast(10);
        L.addLast(20);
        L.addLast(30);
        System.out.println(L.get(1));
        System.out.println(L.size());
        System.out.println(L.removeLast());
        System.out.println(L.getLast());
       */
        for(int i=0;i<101;i++)
            L.addLast(i*1.0);
        System.out.println(L.get(100));
        System.out.println(L.size());
    }
}
