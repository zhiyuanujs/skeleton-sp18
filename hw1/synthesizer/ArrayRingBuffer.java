package synthesizer;
import java.util.Iterator;


public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.

        this.capacity=capacity;
        this.fillCount=0;
        rb=(T[]) new Object[capacity];
        last=capacity/2;
        first=last;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if(fillCount()==capacity()) {
            throw new RuntimeException("cannot enqueue a full BoundedQueue");
        }
        rb[last]=x;
        last++;
        if(last==rb.length){
            last=0;
        }
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if(fillCount()==0){
            throw new RuntimeException("Cannot dequeue an empty BoundedQueue");
        }

        T returnValue=rb[first];
        rb[first]=null;
        first++;
        if(first==rb.length)
            first=0;
        fillCount--;

        return returnValue;
    }

    @Override
    public Iterator<T> iterator(){
        return this.new ArrayRingBufferIterator<T>();
    }

    private class ArrayRingBufferIterator<T> implements Iterator<T>{

        private int count;

        public ArrayRingBufferIterator(){
            count=0;
        }

        @Override
        public boolean hasNext(){
            if(count<fillCount())
                return true;
            return false;
        }

        @Override
        public T next(){
            int temp=count+first;
            if(temp>=capacity())
                temp=temp-capacity();
            count++;
            return (T) rb[temp];
        }

    }

    public void print(){
        int point=first;
        for(int i=0;i<fillCount();i++){
            System.out.print(rb[point]+"  ");
            point++;
            if(point==capacity()){
                point=0;
            }
        }
        System.out.println();

    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if(fillCount()==0){
            throw new RuntimeException("Cannot peek an empty BoundedQueue");
        }
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
}
