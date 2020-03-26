
public class SLList{
	private class IntNode{
		public int item;
		public IntNode next;
	
		public IntNode(int i, IntNode n){
			item=i;
			next=n;
		}
	}
	
	private IntNode first;
	
	public SLList(int x){
		first=new IntNode(x,null);
	}

	public void addFirst(int x){
		first=new IntNode(x,first);
	}
	
	public void addLast(int x){
		IntNode p=this.first;
		while(p.next!=null){
			p=p.next;
		}
		p.next= new IntNode(x,null);
	}
	
	public int getFirst(){
		return this.first.item;
	}
	
	public int size(){
		int n=0;
		IntNode p=first;
		while(p!=null){
			n++;
			p=p.next;
		}
		return n;
	}
	
	public static void main(String[] args){
		
		SLList L=new SLList(10);
		L.addFirst(5);
		L.addFirst(1);
		L.addLast(15);
		System.out.println(L.getFirst());
		System.out.println(L.size());
		
	}
}