
public class SLList{
	private class IntNode{
		public int item;
		public IntNode next;
	
		public IntNode(int i, IntNode n){
			item=i;
			next=n;
		}
	}
	
	/* The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;
	
	public SLList(){
		size=0;
		sentinel=new IntNode(8240,null);
	}
	
	public SLList(int x){
		sentinel=new IntNode(8240,null);
		sentinel.next=new IntNode(x,null);
		size=1;
	}

	public void addFirst(int x){
		sentinel.next=new IntNode(x,sentinel.next);
		size++;
	}
	
	public void addLast(int x){
		IntNode p=sentinel;
		while(p.next!=null){
			p=p.next;
		}
		p.next= new IntNode(x,null);
		size++;
	}
	
	public int getFirst(){
		return sentinel.next.item;
	}
	
	public int size(){
		return size;
	}
	
	public static void main(String[] args){
		
		SLList L=new SLList();
		L.addLast(100);
		L.addFirst(5);
		L.addFirst(1);
		L.addLast(15);
		System.out.println(L.getFirst());
	
		System.out.println(L.size());
		
	}
}