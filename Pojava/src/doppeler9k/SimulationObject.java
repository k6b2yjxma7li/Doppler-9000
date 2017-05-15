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
	public double vy() {
		return v*Math.sin((Math.toRadians(angle)));
	}
	public void setV (double velocity) {
		v = velocity;
	}
	public void setAngle (double angl) {
		angle = angl;
	}
	public void setX (double coords) {
		x = coords;
	}
	public SimulationObject() {
		x = 0;
		y = 0;
		v = 0;
		angle = 0;
	}
	public SimulationObject(float coordX,float coordY) {
		x = coordX;
		y = coordY;
		v = 0;
		angle = 0;
	}
}
