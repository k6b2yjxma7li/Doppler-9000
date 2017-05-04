/**
 * @author Robert
 * @version 16.04.2017
 */

package doppeler9k;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class FunctionGenerator {

	public FunctionGenerator() {
	}
	
	public FunctionGenerator(float hz, int fType) throws LineUnavailableException{
		switch(fType){
			case 0:
			{
				//SINE WIVE
				byte[] buf;
				AudioFormat af;
				buf = new byte[1];
				af = new AudioFormat(44100,8,1,true,false);
				SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
				sdl = AudioSystem.getSourceDataLine(af);
				sdl.open(af);
				sdl.start();
				for(int i=0; i<2*44100; i++){
					double angle = i/((float)44100/hz)*2.0*Math.PI;
					buf[0]=(byte)(Math.sin(angle)*100);
					sdl.write(buf,0,1);
				}
				sdl.drain();
				sdl.stop();
				sdl.close();
				break;
			}
			case 1:
			{
				//SQUARE WAVE
				byte[] buf;
				AudioFormat af;
				buf = new byte[1];
				af = new AudioFormat(44100,8,1,true,false);
				SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
				sdl = AudioSystem.getSourceDataLine(af);
				sdl.open(af);
				sdl.start();
				for(int i=0; i<2*44100; i++){
					double angle = i/((float)44100/hz)*2.0*Math.PI;
					if(Math.sin(angle) > 0) {
						buf[0]=(byte)(1*100);
					}else if(Math.sin(angle) == 0){
						buf[0]=(byte)0;
					}else{
						buf[0]=(byte)((-1)*100);
					}
					sdl.write(buf,0,1);
				}
				sdl.drain();
				sdl.stop();
				sdl.close();
				break;
			}
			case 2:
			{
				//OTHER FUNCTION
				byte[] buf;
				AudioFormat af;
				buf = new byte[1];
				af = new AudioFormat(44100,8,1,true,false);
				SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
				sdl = AudioSystem.getSourceDataLine(af);
				sdl.open(af);
				sdl.start();
				for(int i=0; i<2*44100; i++){
					double angle = i/((float)44100/hz)*2.0*Math.PI;
					buf[0]=(byte)(Math.cos(angle)*Math.exp(Math.sin(angle))*100);
					sdl.write(buf,0,1);
				}
				sdl.drain();
				sdl.stop();
				sdl.close();
				break;
			}
		}
	}

	public static void main(String[] args) {
		FunctionGenerator generator = new FunctionGenerator();

	}

}
