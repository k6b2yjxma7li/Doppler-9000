package doppeler9k;
/**
 * @author Karol
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class ChartWin extends JFrame {
	public SimulationObject source = new SimulationObject();
	public SimulationObject observer = new SimulationObject();
	public double soundVelocity = 343.8;
	public double timestep = 1;
	double freq;
	int functionChoice = 0;
	//
	public void setValues (SimulationObject sou, SimulationObject obs, double soundV, double frequency, double step)
	{
		source = sou;
		observer = obs;
		soundVelocity = soundV;
		timestep = step;
		freq = frequency;
	}
	//
	public double getFactor() {
		double value;
		double rx = observer.getX()-source.getX();
		double ry = observer.getY()-source.getY();
		double cosObs = 1;
		double cosSou = 1;
		if (source.getV() != 0) {
			cosSou = ((rx*source.vx()) + (ry*source.vy())) / ((Math.sqrt(rx*rx+ry*ry) * source.getV()));
		}
		if(observer.getV() != 0) {
			cosObs = ((rx*observer.vx()) + (ry*observer.vy())) / ((Math.sqrt(rx*rx+ry*ry) * observer.getV()));
		}
		value = (soundVelocity + (observer.getV()* cosObs)) / (soundVelocity - (source.getV() * cosSou));
		return value;
	}
	
	public ChartWin(SimulationObject sou, SimulationObject obs, double soundV, double frequ, double step, int fC) throws HeadlessException {
		setValues(sou, obs, soundV, frequ, step);
		functionChoice = fC;
		JPanel wykres = new JPanel();
		this.setSize(640,480);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(wykres,BorderLayout.CENTER);
		//		               
		final XYSeries series = new XYSeries("f(x)");
		switch(functionChoice) {
		case 0:
		{
			for (int j = 0; j<25; j++) {
				source.calculateCoords(timestep*33);
				observer.calculateCoords(timestep*33);
				double actualFreq = freq*getFactor();
				for (int i = 0; i<33; i++) {
					double time = j*33*timestep*0.001+i*timestep*0.001;
					series.add(time,Math.sin(2*Math.PI*actualFreq*time));
				}
			}
			break;
		}
		case 1:
		{
			for (int j = 0; j<25; j++) {
				source.calculateCoords(timestep*33);
				observer.calculateCoords(timestep*33);
				double actualFreq = freq*getFactor();
				for (int i = 0; i<33; i++) {
					double time = j*33*timestep*0.001+i*timestep*0.001;
					series.add(time,Math.sin(2*Math.PI*actualFreq*time));
					if(Math.sin(2*Math.PI*actualFreq*time) > 0) {
						series.add(time, 1);
					} else if(Math.sin(2*Math.PI*actualFreq*time) == 0) {
						series.add(time, 0);
					} else if(Math.sin(2*Math.PI*actualFreq*time) <0 ) {
						series.add(time, -1);
					}
				}
			}
			break;
		}
		case 2:
		{
			for (int j = 0; j<25; j++) {
				source.calculateCoords(timestep*33);
				observer.calculateCoords(timestep*33);
				double actualFreq = freq*getFactor();
				for (int i = 0; i<33; i++) {
					double time = j*33*timestep*0.001+i*timestep*0.001;
					double angle = 2*Math.PI*actualFreq*time;
					series.add(time,Math.sin(angle)*Math.exp(Math.cos(angle)));
				}
			}
			break;
		}
		}
		//
		final XYSeriesCollection dataset = new XYSeriesCollection( ); 
		dataset.addSeries(series); 
		//		
		JFreeChart xylineChart = ChartFactory.createXYLineChart(
		         " " ,
		         "t[s]" ,
		         "f(t)" ,
		         dataset ,
		         PlotOrientation.VERTICAL ,
		         true , true , false);
		ChartPanel chartPanel = new ChartPanel(xylineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560,367));
		add(chartPanel);
		final XYPlot plot = xylineChart.getXYPlot();
		ValueAxis yaxis = plot.getRangeAxis();
		yaxis.setRange(-2, 2);
	}
	
}
	

	
	