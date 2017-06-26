/**
 * @author Robert
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */

package doppeler9k;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
// PLEASE ADJUST THE CLASS -- ONLY SINE WAVE NOW
//IF YOU REALLY WANT YOU CAN MAKE CHARTS FOR OTHER FUNCTIONS -- K

//FUNCTION GENERATING CLASS
public class FunctionGenerator {
	//LINE COUNTER
	public int lineCounter() throws IOException {
		int counter =0;
		BufferedReader lineCounter = new BufferedReader(new FileReader("factorfile.txt"));
		while(lineCounter.readLine() != null) {
			counter++;
		}
		lineCounter.close();
		return counter;
	}
	//SINE GENERATING METHOD
	public void sine(double frequency , double volume) throws IOException, LineUnavailableException {
		BufferedReader fileReader = new BufferedReader(new FileReader("factorfile.txt"));
		AudioFormat af = new AudioFormat(44100, 8, 1, true, false);
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		int lines = lineCounter();
		int counter = 0;
		int theta = 0;
		double[] factor = new double[lines];
		byte[] buffer = new byte[(int)(lines*44.1)];
		for(int n=0; n<lines; n++) {
			factor[n] = Double.parseDouble(fileReader.readLine());
		}
		for(int a=0; a<(lines/10); a++) {
			for(int b=0; b<9; b++) {
				for(int c=0; c<44; c++) {
					double angle = (double)((2*Math.PI/44100)*frequency*(double)theta*factor[counter]);
					buffer[theta] = (byte)(Math.sin(angle)*volume);
					theta++;
				}
				if(counter<lines) {counter++;}
			}
			for(int c=0; c<45; c++) {
				double angle = (double)((2*Math.PI/44100)*frequency*(double)theta*factor[counter]);
				buffer[theta] = (byte)(Math.sin(angle)*volume);
				theta++;
			}
			if(counter<lines) {counter++;}
		}
		sdl.open();
		sdl.start();
		sdl.write(buffer, 0, theta);
		sdl.drain();
		sdl.stop();
		sdl.close();
		fileReader.close();
	}
	//SQUARE GENERATING METHOD
	public void square(double frequency, double volume) throws IOException, LineUnavailableException {
		BufferedReader fileReader = new BufferedReader(new FileReader("factorfile.txt"));
		AudioFormat af = new AudioFormat(44100, 8, 1, true, false);
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		int lines = lineCounter();
		int counter = 0;
		int theta = 0;
		double[] factor = new double[lines];
		byte[] buffer = new byte[lines*45];
		for(int n=0; n<lines; n++) {
			factor[n] = Double.parseDouble(fileReader.readLine());
		}
		for(int a=0; a<(lines/10); a++) {
			for(int b=0; b<9; b++) {
				for(int c=0; c<44; c++) {
					double angle = (double)((2*Math.PI/44100)*frequency*(double)theta*factor[counter]);
					if(Math.sin(angle) > 0) {
						buffer[theta]=(byte)(1*volume);
					}else if(Math.sin(angle) == 0){
						buffer[theta]=(byte)0;
					}else{
						buffer[theta]=(byte)((-1)*volume);
					}
					theta++;
				}
				if(counter<lines) {counter++;}
			}
			for(int c=0; c<45; c++) {
				double angle = (double)((2*Math.PI/44100)*frequency*(double)theta*factor[counter]);
				if(Math.sin(angle) > 0) {
					buffer[theta]=(byte)(1*volume);
				}else if(Math.sin(angle) == 0){
					buffer[theta]=(byte)0;
				}else{
					buffer[theta]=(byte)((-1)*volume);
				}
				theta++;
			}
			if(counter<lines) {counter++;}
		}
		sdl.open();
		sdl.start();
		sdl.write(buffer, 0, theta);
		sdl.drain();
		sdl.stop();
		sdl.close();
		fileReader.close();
	}
	//SINE EXP COSINE GENERATING METHOD
	public void sinexpcos(double frequency , double volume) throws IOException, LineUnavailableException {
		BufferedReader fileReader = new BufferedReader(new FileReader("factorfile.txt"));
		AudioFormat af = new AudioFormat(44100, 8, 1, true, false);
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
		int lines = lineCounter();
		int counter = 0;
		int theta = 0;
		double[] factor = new double[lines];
		byte[] buffer = new byte[lines*45];
		for(int n=0; n<lines; n++) {
			factor[n] = Double.parseDouble(fileReader.readLine());
		}
		for(int a=0; a<(lines/10); a++) {
			for(int b=0; b<9; b++) {
				for(int c=0; c<44; c++) {
					double angle = (double)((2*Math.PI/44100)*frequency*(double)theta*factor[counter]);
					buffer[theta] = (byte)(Math.sin(angle)*Math.exp(Math.cos(angle))*volume);
					theta++;
				}
				if(counter<lines) {counter++;}
			}
			for(int c=0; c<45; c++) {
				double angle = (double)((2*Math.PI/44100)*frequency*(double)theta*factor[counter]);
				buffer[theta] = (byte)(Math.sin(angle)*Math.exp(Math.cos(angle))*volume);
				theta++;
			}
			if(counter<lines) {counter++;}
		}
		sdl.open();
		sdl.start();
		sdl.write(buffer, 0, theta);
		sdl.drain();
		sdl.stop();
		sdl.close();
		fileReader.close();
	}
	//MAIN CONSTRUCTOR
	public FunctionGenerator(float frequency, float volume, int fType) throws LineUnavailableException, IOException {
		switch(fType){
			case 0:
			{
				sine(frequency, volume);
				break;
			}
			case 1:
			{
				square(frequency, volume);
				break;
			}
			case 2:
			{
				sinexpcos(frequency, volume);
				break;
			}
		}
	}
}
