package doppeler9k;
/**
 * @author Karol
 * CTRL + CLICK ME-> https://github.com/rassch/Doppler-9000
 */
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class ChartWin extends JFrame {
	public double soundVelocity = 343.8;
	public double timestep = 0.01;
	double freq;
	int functionChoice = 0;
	//
	public int lineCounter() throws IOException {
		int counter = 0;
		BufferedReader lineCounter = new BufferedReader(new FileReader("factorfile.txt"));
		while(lineCounter.readLine() != null) {
			counter++;
		}
		lineCounter.close();
		return counter;
	}
	public void setValues(double soundV, double frequency) {
		soundVelocity = soundV;
		freq = frequency;
	}
	public ChartWin(double soundV, double frequ, int fC) throws HeadlessException, IOException {
		BufferedReader factorReader = new BufferedReader(new FileReader("factorfile.txt"));
		double lines = lineCounter();
		double[] factor = new double[(int) lines];
		for(int n=0; n < lines; n++) {
			factor[n] = Double.parseDouble(factorReader.readLine());
		}
		setValues(soundV, frequ);
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
			for (int j = 0; j<lines; j++) {
				double actualFreq = freq*factor[j];
				for (int i = 0; i<100; i++) {
					double time = j*100*timestep*0.001+i*timestep*0.001;
					series.add(time,Math.sin(2*Math.PI*actualFreq*time));
				}
			}
			break;
		}
		case 1:
		{
			for (int j = 0; j<lines; j++) {
				double actualFreq = freq*factor[j];
				for (int i = 0; i<100; i++) {
					double time = j*100*timestep*0.001+i*timestep*0.001;
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
			for (int j = 0; j<lines; j++) {
				double actualFreq = freq*factor[j];
				for (int i = 0; i<100; i++) {
					double time = j*100*timestep*0.001+i*timestep*0.001;
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
	

	
	