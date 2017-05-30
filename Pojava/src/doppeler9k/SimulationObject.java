/**
 * @author Karol
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */
package doppeler9k;

//SIMULATION OBJECTS - BOTH OBSERVER AND SOURCE
public class SimulationObject {
	double x,y;
	double angle;
	double v;
	//
	public double vx() {
		return v*Math.cos((Math.toRadians(angle)));
	}
	//
	public double vy() {
		return v*Math.sin((Math.toRadians(angle)));
	}
	//
	public void calculateCoords(double dt)
	{
		x += (vx()*dt*0.001);
		y += (vy()*dt*0.001);
	}
	//
	public void setV(double velocity) {
		v = velocity;
	}
	//
	public void setAngle(double angl) {
		angle = angl;
	}
	public double getAngle() {
		return angle;
	}
	//
	public void setX(double coordX) {
		x = coordX;
		//initX = coordX;
	}
	//
	public void setY(double coordY) {
		y = coordY;
		//initY = coordY;
	}
	//
	public void setXY(double X, double Y) {
		x = X;
		y = Y;
	}
	//
	public double getX()
	{
		return x;
	}
	//
	public double getY()
	{
		return y;
	}
	//
	public SimulationObject() {
		x = 0;
		y = 0;
		v = 0;
		angle = 0;
	}
	public SimulationObject(double coordX,double coordY) {
		x = coordX;
		y = coordY;
		v = 0;
		angle = 0;
	}

	public SimulationObject(double coordX,double coordY,double vel, double angl) {
		x = coordX;
		y = coordY;
		v = vel;
		angle = angl;
	}
}
