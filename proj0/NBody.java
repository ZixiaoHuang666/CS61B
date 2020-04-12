
public class NBody{ 

	public static String background = "images/starfield.jpg";
	//读取文件 返回radius 最开始没有申明静态方法，导致报错，Test文件类调用
	public static double readRadius(String addr){
        In in = new In(addr);
        in.readInt();
        double radius = in.readDouble();
        return radius;
    }
	public static Planet[] readPlanets(String addr){
        In in = new In(addr);
	    int size = in.readInt();
        double radius = in.readDouble();
		Planet[] universe = new Planet[size];
		for (int i=0;i<size;i++){
			Planet p = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
            universe[i]= p;
		}
		return universe;
	}
	public static void main(String[] args){
         double T = Double.parseDouble(args[0]);
		 double dt = Double.parseDouble(args[1]);
		 String filename = args[2];
		 double radius = readRadius(filename);
		 Planet[] universe = readPlanets(filename);
		 StdDraw.enableDoubleBuffering();
		 double t = 0;
		 while(t<T){
			 double[] xForces = new double[universe.length];
			 double[] yForces = new double[universe.length];
			 for (int j =0;j<universe.length;j++ ){
				 xForces[j] = universe[j].calcNetForceExertedByX(universe);
				 yForces[j] = universe[j].calcNetForceExertedByY(universe);
			 }
			 for(int k=0;k<universe.length;k++){
				universe[k].update(dt,xForces[k],yForces[k]);
			 }
			 StdDraw.setScale(-radius, radius);
			 StdDraw.clear();
			 StdDraw.picture(0, 0, background);
			 for (int i=0;i<universe.length;i++){
				universe[i].draw();
			 }		 		
			 StdDraw.show();
			 StdDraw.pause(10);
			 t = t+dt;
		 }
	}
}