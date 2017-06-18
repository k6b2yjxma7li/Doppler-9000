/**
 * @author Robert
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */
package doppeler9k;

public class WaveObject {
	double x;
	double y;
	double diameter;
	double velocity;
	//
	public WaveObject(double X, double Y, double D, double V) {
		x = X;
		y = Y;
		diameter = D;
		velocity = V;
	}
	public WaveObject() {
		x = 0;
		y = 0;
		diameter = 0;
		velocity = 0;
	}
	//
	public void setV(double V) {
		velocity = V;
	}
	public void setX(double X) {
		x = X;
	}
	public void setY(double Y) {
		y = Y;
	}
	public void setXY(double X, double Y) {
		x = X;
		y = Y;
	}
	//
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	//
	public double calculateDia(double dt, double maxRad, int timestep) {
		diameter = velocity * (dt % maxRad) *timestep* 0.002;
		return diameter;
	}
}
