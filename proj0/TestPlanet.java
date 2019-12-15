/**
 *  Tests Planet class
 */


public class TestPlanet{
	
	public static void main(String[] args){
		
		checkPlanet();
		
	}
	
	public static void checkPlanet(){
		Planet a=new Planet(3e10,4e10,20,30,1e20,"jupiter.gif");
		Planet b=new Planet(0,0,59,100,1e22,"earth.gif");
		
		
		checkEquals(2.668e10,a.calcForceExertedBy(b), "checkForce",0.01);
		checkEquals(2.668e10,b.calcForceExertedBy(a), "checkForce",0.01);
		
		
		
		
		
	}
	
	public static void checkEquals(double expected, double actual, String label, double eps){
		
		if(Math.abs(expected-actual)<=eps*Math.max(expected,actual))
			System.out.println("Pass: "+label+": Expected "+ expected+ " and You give "+ actual);
		else
			System.out.println("Fail: "+label+": Expected "+ expected+ " and You give "+ actual);
			
		
	}
	
}