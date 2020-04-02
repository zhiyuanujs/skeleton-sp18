public class ArrayDeque<T> {

        private T [] item;
        private int size;
        /*nextFirst is the place where addFirst goes*/
        /*nextLast is the place where  addLast goes*/
        private int nextFirst, nextLast;

        /**
         * Invariants
         * The first value in the array is at nextFirst+1; (if size!=0)
         * The last value in the array is at nextLast-1; (if size!=0)
         */
        public ArrayDeque(){
                size=0;
                item=(T [])new Object[8];
                nextFirst=4;
                nextLast=5;
        }

        /**
         * increase space in the front of item.
         */
        private void increaseSizeInFront(){
                int biggerSize=(int)(item.length*1.5);
                int sizeIncreased=biggerSize-size;
                T[] array=(T[]) new Object[biggerSize];

                System.arraycopy(item,0,array,sizeIncreased,size);
                item=array;
                nextFirst=nextFirst+sizeIncreased;
                nextLast=nextLast+sizeIncreased;

        }

        /**
         * adds an item of type T to the front of the deque.
         */
        public void addFirst(T i){
                if(nextFirst<0)
                        increaseSizeInFront();
                item[nextFirst]=i;
                size=size+1;
                nextFirst=nextFirst-1;
        }

        /**
         * increase space at the end of item
         */
        private void increaseSizeInEnd(){
                int biggerSize=(int)(item.length*1.5);
                T[] array=(T[]) new Object[biggerSize];

                System.arraycopy(item,nextFirst+1,array,nextFirst+1,size);
                item=array;
        }

        /**
         * adds an item of type T to the back of the deque.
         */
        public void addLast(T i){
                if(nextLast==item.length)
                        increaseSizeInEnd();
                item[nextLast]=i;
                nextLast=nextLast+1;
                size=size+1;

        }

        /**
         * Returns true if deque is empty, false otherwise.
         */
        public boolean isEmpty(){
                if(size==0)
                        return true;

            return false;
        }

        /**
         * returns teh number of items in the deque.
         * @return
         */
        public int size(){
                return size;
        }

        /**
         * prints the items in the deque from  first to last,
         * separated by a space.
         */
        public void printDeque(){
                for(int i=nextFirst+1;i<nextLast;i++)
                {
                        System.out.print(item[i]);
                        System.out.print(" ");
                }
                System.out.print("\n");

        }

        /**
         * To decrease the length of the array to save the memory
         */
        private void shrinkSize(){
                int emptyFront=nextFirst+1;
                int emptyEnd=item.length-nextLast;

                int shrinkFront=emptyFront/2;
                int shrinkEnd=emptyEnd/2;

                int oldNextFirst=nextFirst;

                nextFirst=nextFirst-shrinkFront;
                nextLast=nextLast-shrinkFront;

                int newLength=item.length-shrinkFront-shrinkEnd;

                T [] array=(T[]) new Object[newLength];

                System.arraycopy(item,oldNextFirst+1,array,nextFirst+1,size);

                item=array;

        }


        /**
         * removes and returns the item at the front of the deque.
         * if no such item exists, return null.
         * @return
         */
        public T removeFirst(){
                if(nextLast==nextFirst+1)
                        return null;
                nextFirst=nextFirst+1;
                T returnValue=item[nextFirst];
                item[nextFirst]=null;
                size=size-1;
                double usageRate=(1.0*size)/item.length;
                if(usageRate<0.25 && item.length>=16)
                        shrinkSize();
            return returnValue;
        }

        /**
         * removes and returns the item at the back of the deque.
         * if no such item exists, return null.
         * @return
         */
        public T removeLast(){
                if(nextLast==nextFirst+1)
                        return null;
                nextLast=nextLast-1;
                size=size-1;

                T returnValue=item[nextLast];
                item[nextLast]=null;

                double usageRate=(1.0*size)/item.length;
                if(usageRate<0.25 && item.length>=16)
                        shrinkSize();

                return returnValue;
        }

        /**
         * gets the item at the given index, where 0 is the front,
         * 1 is the next item, and so forth. if no such item exists,
         * return null.
         * @param index
         * @return
         */
        public T get(int index){
                if(index<0 || index>=size)
                        return null;
                return item[nextFirst+1+index];
        }
}
