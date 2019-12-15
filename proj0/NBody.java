/**
*  NBody is a class that will actually run your simulation
*  The goal of this class is  to simulate a universe specified in one of the data files.

*/

public class NBody{
	
	public static double readRadius(String s){
		In in=new In(s);
		
		int firstItem=in.readInt();
		double secondItem=in.readDouble();
		
		return secondItem;
		
		
	}
	
	public static Planet[] readPlanets(String s){
		In in=new In(s);
		int numOfPlanets=in.readInt();
		
		double secondItem=in.readDouble();
		Planet[] pArray=new Planet[numOfPlanets];
		int i=0;
		while(i<numOfPlanets){
			double xxPos=in.readDouble();
			double yyPos=in.readDouble();
			double xxVel=in.readDouble();
			double yyVel=in.readDouble();
			double mass=in.readDouble();
			String imgFileName=in.readString(); 
			pArray[i]=new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
			i++;
		}
		
		return pArray;
		
		
	}
	
}