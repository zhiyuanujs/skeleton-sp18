public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
		
	}
	
	public Planet(Planet p){
		xxPos=p.xxPos;
		yyPos=p.yyPos;
		xxVel=p.xxVel;
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName;
	}
	
	
	public double calcDistance(Planet p){
		double dx=p.xxPos-xxPos;
		double dy=p.yyPos-yyPos;
		
		return Math.sqrt(dx*dx+dy*dy); 
	}
	
	public double calcForceExertedBy(Planet p){
		double distance=calcDistance(p);
		double force=6.67e-11*mass*p.mass/distance/distance;
		return force;
		
	}
	
	public double calcForceExertedByX(Planet p){
		double force=calcForceExertedBy(p);
		double dx=p.xxPos-xxPos;
		double distance=calcDistance(p);
		double forceX=force*dx/distance;
		return forceX;
		
	}
	
	public double calcForceExertedByY(Planet p){
		double force=calcForceExertedBy(p);
		double dy=p.yyPos-yyPos;
		double distance=calcDistance(p);
		double forceY=force*dy/distance;
		return forceY;
		
	}
	
	public double calcNetForceExertedByX(Planet[] pArray){
		double netForceX=0.0;
		for(Planet p: pArray){
			if(this.equals(p))
				continue;
			netForceX+=calcForceExertedByX(p);
		}
		
		return netForceX;
		
	}
	
	public double calcNetForceExertedByY(Planet[] pArray){
		double netForceY=0.0;
		for(Planet p: pArray){
			if(this.equals(p))
				continue;
			netForceY+=calcForceExertedByY(p);
		}
		
		return netForceY;
		
	}
	
	public void update(double dt, double netForceX, double netForceY){
		
		double accX=netForceX/mass;
		double accY=netForceY/mass;
		
		xxVel+=accX*dt;
		yyVel+=accY*dt;
		
		xxPos+=xxVel*dt;
		yyPos+=yyVel*dt;	
	}
	
	public void draw(){
		StdDraw.picture(xxPos,yyPos,imgFileName);
		StdDraw.show();
		
	}
	
	
	
}