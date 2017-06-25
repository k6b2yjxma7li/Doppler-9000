package doppeler9k;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * An example to show how we can create a dynamic chart.
*/
public class Chart extends ApplicationFrame implements ActionListener {

    /** The time series data. */
    private XYSeries series;
   
    

    /** The most recent value added. */
    static private double lastValue = 0;
    static private int cycle = 0;
    private int timestep = 15;

    /** Timer to refresh graph after every 1/4th of a second */
    private Timer timer = new Timer(timestep, this);

    /**
     * Constructs a new dynamic chart application.
     *
     * @param title  the frame title.
     */
    public Chart(final String title) {

        super(title);
        this.series = new XYSeries("Random Data");
        final XYSeriesCollection dataset1 = new XYSeriesCollection(this.series);
        final JFreeChart chart = createChart(dataset1);
        

       

        //Sets background color of chart
        //chart.setBackgroundPaint(Color.LIGHT_GRAY);

        //Created JPanel to show graph on screen
        final JPanel content = new JPanel(new BorderLayout());

        //Created Chartpanel for chart area
        final ChartPanel chartPanel = new ChartPanel(chart);
      

        //Added chartpanel to main panel
        content.add(chartPanel);
      

        //Sets the size of whole window (JPanel)
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));

        //Puts the whole content on a Frame
        setContentPane(content);

        timer.start();

    }

    /**
     * Creates a sample chart.
     *
     * @param dataset  the dataset.
     *
     * @return A sample chart.
     */
    private JFreeChart createChart(final XYDataset dataset1) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
            " ",
            " ",
            " ",
            dataset1,
            false,
            false,
            false
        );
       
        final XYPlot plot = result.getXYPlot();

        plot.setBackgroundPaint(new Color(0xffffe0));
        plot.setDomainGridlinesVisible(false);
        plot.setRangeGridlinesVisible(false);
             
        

        ValueAxis xaxis = plot.getDomainAxis();
        xaxis.setAutoRange(true);

       
        xaxis.setFixedAutoRange(300.0);  // 300/15= 20 cycles
        ValueAxis yaxis = plot.getRangeAxis();
        yaxis.setRange(-1.0, 1.0);
        yaxis.setVisible(false);
        xaxis.setVisible(false);

        return result;
    }
    
       
    
    /**
     * Generates an random entry for a particular call made by time for every 1/4th of a second.
     *
     * @param e  the action event.
     */
    public void actionPerformed(final ActionEvent e) {

      
    	double freq = 2;
    	this.lastValue = this.lastValue+(2*3.14*timestep*0.001*freq); 
    	this.cycle++;
        this.series.add(cycle*timestep,Math.sin(lastValue));
        System.out.println("Current Time in Milliseconds = " + ", Current Value : "+this.lastValue+" "+this.cycle);
    }

    /**
     * Starting point for the dynamic graph application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final Chart demo = new Chart("Dynamic Line And TimeSeries Chart");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}