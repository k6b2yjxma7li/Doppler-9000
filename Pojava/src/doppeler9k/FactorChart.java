package doppeler9k;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.io.BufferedReader;
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

public class FactorChart extends JFrame {
	//
	public int lineCounter() throws IOException {
		int counter = 0;
		BufferedReader lineCounter = new BufferedReader(new FileReader("factorfile.txt"));
		while(lineCounter.readLine() != null) {
			counter++;
		}
		lineCounter.close();
		//System.out.println(counter);
		return counter;
	}
	//
	public FactorChart() throws HeadlessException, IOException {
		BufferedReader factorReader = new BufferedReader(new FileReader("factorfile.txt"));
		double[] factor = new double[lineCounter()];
		for(int n=0; n < lineCounter(); n++) {
			factor[n] = Double.parseDouble(factorReader.readLine());
		}
		JPanel wykres = new JPanel();
		this.setSize(640,480);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(wykres,BorderLayout.CENTER);
		//		               
		final XYSeries series = new XYSeries("k(v)");
		for(int n = 0; n<lineCounter(); n++) {
			series.add(((double)n/1000), factor[n]);
		}
		final XYSeriesCollection dataset = new XYSeriesCollection( ); 
		dataset.addSeries(series); 
		//		
		JFreeChart xylineChart = ChartFactory.createXYLineChart(
		         " " ,
		         "t[s]" ,
		         "k(v)" ,
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
