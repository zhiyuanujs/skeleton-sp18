
public class SLList<T> implements List61B<T>{
	private class IntNode{
		public T item;
		public IntNode next;
	
		public IntNode(T i, IntNode n){
			item=i;
			next=n;
		}
	}
	
	/* The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;
	
	public SLList(){
		size=0;
		sentinel=new IntNode(null,null);
	}
	
	public SLList(T x){
		sentinel=new IntNode(null,null);
		sentinel.next=new IntNode(x,null);
		size=1;
	}

	public void addFirst(T x){
		sentinel.next=new IntNode(x,sentinel.next);
		size++;
	}
	
	public void addLast(T x){
		IntNode p=sentinel;
		while(p.next!=null){
			p=p.next;
		}
		p.next= new IntNode(x,null);
		size++;
	}
	
	public T getFirst(){
		return sentinel.next.item;
	}
	
	public int size(){
		return size;
	}

	public T get(int i){
		IntNode tempNode=sentinel.next;

		for(int j=0;j<i;j++)
			tempNode=tempNode.next;

		return tempNode.item;

	}

	@Override
	public void print() {
		IntNode tempNode = sentinel;
		System.out.println("An efficient print for SSList");
		while (tempNode.next != null) {
			tempNode = tempNode.next;
			System.out.print(tempNode.item + "  ");
		}
		System.out.println();
	}


	
	public static void main(String[] args){
		
		SLList L=new SLList();
		L.addLast(100);
		L.addFirst(5);
		L.addFirst(1);
		L.addLast(15);
		System.out.println(L.getFirst());

	
		System.out.println(L.size());
		System.out.println(L.get(3));
		
	}
}