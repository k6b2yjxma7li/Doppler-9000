/**
 * @author Karol
 */
package doppeler9k;

public class SimulationObject {
	float x,y;
	int angle;
	float v;
	
	public double vx(int angle, float v) {
		return v*Math.cos((Math.toRadians(angle)));
	}
	
	public double vy(int angle, float v) {
		return v*Math.sin((Math.toRadians(angle)));
	}
	
	public void setV (float velocity) {
		v = velocity;
	}
	public void setAngle (int angl) {
		angle = angl;
	}
	public void setX (float coords) {
		x = coords;
	}
	
	public SimulationObject() {	//domyslny
		x = 0;
		y = 0;
		v = 0;
		angle = 0;
	}
	
	public SimulationObject(float coordX,float coordY) {	//do drag&drop
		x = coordX;
		y = coordY;
		v = 0;
		angle = 0;
	}
}
