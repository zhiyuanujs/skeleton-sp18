public interface Deque<Item> {

    public void addFirst(Item i);

    public void addLast(Item i);

    public boolean isEmpty();

    public int size();

    public void printDeque();

    public Item removeFirst();

    public Item removeLast();

    public Item get(int index);

    public Item getRecursive(int index);

}
