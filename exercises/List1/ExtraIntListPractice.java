public class ExtraIntListPractice{
	
	public static IntList incrList(IntList L, int x){
		int size=L.size();
		IntList L2=null;
		for(int i=size-1;i>=0;i--){
			L2=new IntList(L.get(i)-x,L2);
		}
		return L2;
		
		
	}
	
	public static IntList dincrList(IntList L, int x){
		int size=L.size();
		IntList p=L;

		for(int i=0;i<size;i++){
			p.first-=x;
			p=p.rest;
			
		}
		return L;
	}
	
	public static void main(String [] args){
		IntList L=new IntList(15,null);
		L=new IntList(10,L);
		L=new IntList(5,L); 
		
		IntList L2=incrList(L,2);
		
		System.out.println(L.get(0)+","+L.get(2));
		System.out.println(L2.get(0)+","+L2.get(2));
		
		IntList L3=dincrList(L,3);
		System.out.println(L.get(0)+","+L.get(2));
		System.out.println(L3.get(0)+","+L3.get(2));
	}
	
}