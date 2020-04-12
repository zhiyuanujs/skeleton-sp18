public interface List61B <T>{


    public void addFirst(T x);

    public void addLast(T x);

    public T getFirst();

    public int size();

    public T get(int i);

    /** prints out the entire list */
    default public void print(){
        for(int i=0;i<size();i++){
            System.out.print(get(i)+"   ");
        }
        System.out.println();

    };

}
