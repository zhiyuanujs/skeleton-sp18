public class VengefulSLList<T> extends SLList<T> {

    SLList<T> deletedItems;

    public VengefulSLList(){
        deletedItems=new SLList<T>();
    }

    @Override
    public T removeLast(){
        T x=super.removeLast();
        deletedItems.addFirst(x);
        return x;
    }


    public void printLostItem(){
        deletedItems.print();
    }

    public static void main(String[] args){

        VengefulSLList<Integer> vsl=new VengefulSLList<>();

        vsl.addLast(1);
        vsl.addLast(5);
        vsl.addLast(10);
        vsl.addLast(13);
        vsl.print();

        vsl.removeLast();
        vsl.removeLast();

        System.out.print("The fallen are: ");
        vsl.printLostItem();
    }


}
