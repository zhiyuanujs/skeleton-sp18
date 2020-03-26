public class IntList{
	public int first;
	public IntList rest;
	
	public IntList(int f, IntList r){
		first=f;
		rest=r;
	}
	
	public int size(){
		if(rest!=null)
			return rest.size()+1;
		else
			return 1;
		
	}
	
	public int iterativeSize(){
		IntList temp=this;
		int s=0;
		while(temp!=null){
			s++;
			temp=temp.rest;
		}
		return s;
	}
	
	public int get(int n){
		IntList p=this;
		while(n>0){
			p=p.rest;
			n--;
			
		}
		return p.first;
		
	}
	
	public static void main(String [] args){
		IntList L=new IntList(15,null);
		L=new IntList(10,L);
		L=new IntList(5,L); 
		
		System.out.println(L.size());
		System.out.println(L.iterativeSize());
		System.out.println(L.get(0)+","+L.get(2));
	}
	
}