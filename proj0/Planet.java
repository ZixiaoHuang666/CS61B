/** CS61B Planet Simulation 
* @author ZixiaoHuang
*/
public class Planet{

	//Field
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double G = 6.67e-11;

	//Constructor
    public Planet(double xP, double yP,double xV, double yV,double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	
	public double calcDistance(Planet p){
		return Math.sqrt((this.xxPos - p.xxPos)*(this.xxPos - p.xxPos)+(this.yyPos - p.yyPos)*(this.yyPos - p.yyPos));
	}
	
	public double calcForceExertedBy(Planet p){
		double r = this.calcDistance(p);
		return G*this.mass*p.mass/(r*r);
	}
	
	public double calcForceExertedByX(Planet p){
            double F = this.calcForceExertedBy(p);
			double r = this.calcDistance(p);
			double dx = p.xxPos-this.xxPos;
			return F*dx/r;
	}
	
	public double calcForceExertedByY(Planet p){
            double F = this.calcForceExertedBy(p);
			double r = this.calcDistance(p);
			double dy = p.yyPos-this.yyPos;
			return F*dy/r;
	}
	
	public double calcNetForceExertedByX(Planet[] p){
            double sum =0;
			for(int i=0;i<p.length;i++){
				if(!this.equals(p[i])){
					sum = sum + calcForceExertedByX(p[i]);
				}
			}
	        return sum;
	}
	
	public double calcNetForceExertedByY(Planet[] p){
            double sum =0;
			for(int i=0;i<p.length;i++){
				if(!this.equals(p[i])){
					sum = sum + calcForceExertedByY(p[i]);
				}
			}
	        return sum;
	}
	
	public void update(double dt,double fX,double fY){
		double ax = fX/this.mass;
		double ay = fY/this.mass;
		this.xxVel = xxVel + ax*dt;
		this.yyVel = yyVel + ay*dt;
		this.xxPos = xxPos + dt*xxVel;
		this.yyPos = yyPos + dt*yyVel;
	}
	
   public void draw(){
	   StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
   }
}
