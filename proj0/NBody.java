/**
*  NBody is a class that will actually run your simulation
*  The goal of this class is  to simulate a universe specified in one of the data files.

*/

public class NBody{
	
	public static void main(String[] args){
		
		if(args.length<3)
			System.out.println("Not enough command line arguments");
		else {
		
			double T, dt;
			T=Double.parseDouble(args[0]);
			dt=Double.parseDouble(args[1]);
		
			String filename=args[2];
		
			double uniRadius=readRadius(filename);
			System.out.println(uniRadius);
			Planet[] allPlanets=readPlanets(filename);
			
			
			StdDraw.enableDoubleBuffering();
			
			String backGround=".//images//starfield.jpg";
			StdDraw.setScale(-uniRadius,uniRadius);
			StdDraw.picture(0,0,backGround);
			StdDraw.show();
			for(Planet p: allPlanets){
				p.draw();
			}
			
			double time=0.0;
			
			while(time<T){
				StdDraw.clear();
				for(Planet p: allPlanets){
					
					double xForces=p.calcNetForceExertedByX(allPlanets);
					double yForces=p.calcNetForceExertedByY(allPlanets);
					p.update(dt, xForces, yForces);
				}
				StdDraw.picture(0,0,backGround);
				for(Planet p: allPlanets){
					p.draw();
				}
				StdDraw.show();
				StdDraw.pause(10);
				
				time+=dt;
			}
			
			StdOut.printf("%d\n", allPlanets.length);
			StdOut.printf("%.2e\n", uniRadius);
			for (int i = 0; i < allPlanets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                  allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
			}
		
		}
		
	}
	
	
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
			imgFileName=".\\images\\"+imgFileName;
			pArray[i]=new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
			i++;
		}
		
		return pArray;
		
		
	}
	
}