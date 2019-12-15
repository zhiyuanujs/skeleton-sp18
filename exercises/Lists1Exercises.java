public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
		IntList[] intListArray=new IntList[L.size()];
		for(int i=0;i<L.size();i++){
			intListArray[i]=new IntList(L.get(i)+10,null);
			
		}
		for(int i=0;i<L.size()-1;i++){
			intListArray[i].rest=intListArray[i+1];
			}

        return intListArray[0];        
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        IntList p=L;
		do{
			p.first+=x;
			p=p.rest;
		}
		while(p!=null);
        return L;        
		
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());
		
		System.out.println(L.get(2));
		
		
		IntList p=incrList(L,10);
		for(int i=0;i<p.size();i++)
			System.out.println(p.get(i));
		

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        // System.out.println(L.get(1));
        // System.out.println(incrList(L, 3));
        // System.out.println(dincrList(L, 3));        
    }
}