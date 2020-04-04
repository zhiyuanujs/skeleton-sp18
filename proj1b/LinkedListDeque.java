public class LinkedListDeque<Item> implements Deque<Item> {
    private class LinkedList{
        public LinkedList pre,next;
        public Item items;

        public LinkedList(){
            pre=null;
            next=null;
            items=null;
        }

        public Item getItem(int index){
            if(index==0)
                return this.items;
            return this.next.getItem(index-1);

        }
    }

    private int size;
    private LinkedList sentinel;

    /**
     * Create an empty linked list deque.
     */
    public LinkedListDeque(){
        sentinel=new LinkedList();
        sentinel.pre=sentinel;
        sentinel.next=sentinel;
        size=0;
    }

    /**
     * adds an item of type T to the front of the deque.
     * MUST not involve any looping or recursion.
     * Execution SHOULD NOT depend on the size of the deque.
     */

    @Override
    public void addFirst(Item i){
        LinkedList rest=sentinel.next;

        LinkedList L=new LinkedList();
        L.items=i;
        L.pre=sentinel;
        sentinel.next=L;

        L.next=rest;
        rest.pre=L;

        size=size+1;
    }

    /**
     * adds an item of type T to the back of the deque.
     * MUST not involve any looping or recursion.
     * Execution SHOULD NOT depend on the size of the deque.
     */
    @Override
    public void addLast(Item i){
        LinkedList oldLast=sentinel.pre;

        LinkedList L=new LinkedList();
        L.items=i;
        L.pre=oldLast;
        oldLast.next=L;

        L.next=sentinel;
        sentinel.pre=L;

        size=size+1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    @Override
    public boolean isEmpty(){
        if(size==0)
            return true;

        return false;
    }

    /**
     * returns teh number of items in the deque.
     * MUST take constant time.
     */
    @Override
    public int size(){
        return size;
    }

    /**
     * prints the items in the deque from  first to last,
     * separated by a space.
     */
    @Override
    public void printDeque(){
        LinkedList printingItem=sentinel.next;
        while(printingItem!=sentinel){
            System.out.print(printingItem.items);
            System.out.print(" ");
            printingItem=printingItem.next;
        }
        System.out.print("\n");

    }

    /**
     * removes and returns the item at the front of the deque.
     * if no such item exists, return null.
     * MUST not involve any looping or recursion.
     * Execution SHOULD NOT depend on the size of the deque.
     */
    @Override
    public Item removeFirst(){
        if(size==0)
            return null;

        Item i=sentinel.next.items;

        sentinel.next=sentinel.next.next;
        sentinel.next.pre=sentinel;

        size=size-1;

        return i;
    }

    /**
     * removes and returns the item at the back of the deque.
     * if no such item exists, return null.
     * MUST not involve any looping or recursion.
     * Execution SHOULD NOT depend on the size of the deque.
     */
    @Override
    public Item removeLast(){
        if(size==0)
            return null;

        Item i=sentinel.pre.items;
        sentinel.pre.pre.next=sentinel;
        sentinel.pre=sentinel.pre.pre;

        size=size-1;

        return i;
    }

    /**
     * gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth. if no such item exists,
     * return null.
     * MUST use iteration, not recursion.
     */
    @Override
    public Item get(int index){
        if(size==0 || index>=size)
            return null;

        LinkedList temp=sentinel;
        int n=-1;
        while(n<index){
            temp=temp.next;
            n++;
        }
        return temp.items;

    }


    /**
     * gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth. if no such item exists,
     * return null.
     * MUST use recursion.
     */
    @Override
    public Item getRecursive(int index){
        if(size==0 || index>=size)
            return null;
        return sentinel.next.getItem(index);
    }
}
