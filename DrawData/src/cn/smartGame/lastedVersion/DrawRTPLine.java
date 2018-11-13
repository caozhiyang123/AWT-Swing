package cn.smartGame.lastedVersion;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DrawRTPLine extends ApplicationFrame  implements Runnable
{
	private static TimeSeries rtp;
	private static TimeSeries baseRTP;
	private static TimeSeries ebRTP;
	
	private static TimeSeries ebPrice;
	
    private static TimeSeries ebRoundPer;
	
//  static TimeSeries localTimeSeries = new TimeSeries("L&G European Index Trust");
  
  public DrawRTPLine(String paramString)
  {
    super(paramString);
    splitPane();
    rtp = new TimeSeries("RTP");
    baseRTP = new TimeSeries("BaseRTP");
    ebRTP = new TimeSeries("EB RTP");
    TimeSeriesCollection localXYDataset = new TimeSeriesCollection();
    localXYDataset.addSeries(rtp);
    localXYDataset.addSeries(baseRTP);
    localXYDataset.addSeries(ebRTP);
    JFreeChart localJFreeChart = createChartOfRTP(localXYDataset);
    ChartPanel localChartPanel = new ChartPanel(localJFreeChart, false);
    localChartPanel.setPreferredSize(new Dimension(1000, 300));
    localChartPanel.setMouseZoomable(true, true);
    jp1.add(localChartPanel);
    
    ebPrice = new TimeSeries("EB Price");
    TimeSeriesCollection localXYDataset2 = new TimeSeriesCollection();
    localXYDataset2.addSeries(ebPrice);
    JFreeChart localJFreeChart2 = createChartOfEbPrice(localXYDataset2);
    ChartPanel localChartPanel2 = new ChartPanel(localJFreeChart2, false);
    localChartPanel2.setPreferredSize(new Dimension(1000, 300));
    localChartPanel2.setMouseZoomable(true, true);
    jp2.add(localChartPanel2);
    
    ebRoundPer = new TimeSeries("EB Round Percent");
    TimeSeriesCollection localXYDataset3 = new TimeSeriesCollection();
    localXYDataset3.addSeries(ebRoundPer);
    JFreeChart localJFreeChart3 = createChartOfEbHit(localXYDataset3);
    ChartPanel localChartPanel3 = new ChartPanel(localJFreeChart3, false);
    localChartPanel3.setPreferredSize(new Dimension(1000, 300));
    localChartPanel3.setMouseZoomable(true, true);
    jp3.add(localChartPanel3);
  }
  
  
  public static JPanel jp1, jp2,jp3;
  public void splitPane() {
	  Container c=getContentPane();
	  c.setLayout(new GridLayout(3,1,100,1));
	  jp1 = new JPanel();
	  jp1.setBackground(Color.lightGray);
	  jp2 = new JPanel();
	  jp2.setBackground(Color.lightGray);
	  jp3 = new JPanel();
	  jp3.setBackground(Color.lightGray);
	  c.add("1", jp1);
	  c.add("2", jp2);
	  c.add("3", jp3);
	  setTitle("²ð·Ö´°¿Ú");
	  setBounds(300, 200, 500, 500);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setVisible(true);
  }

  private static JFreeChart createChartOfRTP(XYDataset paramXYDataset)
  {
	  JFreeChart localJFreeChart = ChartFactory.createTimeSeriesChart("RTP(total,base and eb)", "Date", "Percentage(%)", paramXYDataset, true, true, false);
	  localJFreeChart.setBackgroundPaint(Color.white);
	  XYPlot localXYPlot = (XYPlot)localJFreeChart.getPlot();
	  localXYPlot.getDomainAxis().setAutoRange(true);
	  localXYPlot.setBackgroundPaint(Color.lightGray);
	  localXYPlot.setDomainGridlinePaint(Color.white);
	  localXYPlot.setRangeGridlinePaint(Color.white);
	  localXYPlot.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
	  localXYPlot.setDomainCrosshairVisible(true);
	  localXYPlot.setRangeCrosshairVisible(true);
	  
	  XYItemRenderer localXYItemRenderer = localXYPlot.getRenderer();
	  Object localObject = null;
	  if (localXYItemRenderer instanceof XYLineAndShapeRenderer)
	  {
		  localObject = (XYLineAndShapeRenderer)localXYItemRenderer;
		  ((XYLineAndShapeRenderer)localObject).setDefaultShapesVisible(true);
		  ((XYLineAndShapeRenderer)localObject).setDefaultShapesFilled(true);
	  }
	  
	  localObject = (DateAxis)localXYPlot.getDomainAxis();
	  ((DateAxis)localObject).setDateFormatOverride(new SimpleDateFormat("HH:mm:ss"));
	  return ((JFreeChart)localJFreeChart);
  }
  private static JFreeChart createChartOfEbPrice(XYDataset paramXYDataset)
  {
	  JFreeChart localJFreeChart = ChartFactory.createTimeSeriesChart("EB prices per pattern", "Date", "Percentage(%)", paramXYDataset, true, true, false);
	  localJFreeChart.setBackgroundPaint(Color.white);
	  XYPlot localXYPlot = (XYPlot)localJFreeChart.getPlot();
	  localXYPlot.getDomainAxis().setAutoRange(true);
	  localXYPlot.setBackgroundPaint(Color.lightGray);
	  localXYPlot.setDomainGridlinePaint(Color.white);
	  localXYPlot.setRangeGridlinePaint(Color.white);
	  localXYPlot.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
	  localXYPlot.setDomainCrosshairVisible(true);
	  localXYPlot.setRangeCrosshairVisible(true);
	  XYItemRenderer localXYItemRenderer = localXYPlot.getRenderer();
	  Object localObject = null;
	  if (localXYItemRenderer instanceof XYLineAndShapeRenderer)
	  {
		  localObject = (XYLineAndShapeRenderer)localXYItemRenderer;
		  ((XYLineAndShapeRenderer)localObject).setDefaultShapesVisible(true);
		  ((XYLineAndShapeRenderer)localObject).setDefaultShapesFilled(true);
	  }
	  localObject = (DateAxis)localXYPlot.getDomainAxis();
	  ((DateAxis)localObject).setDateFormatOverride(new SimpleDateFormat("HH:mm:ss"));
	  return ((JFreeChart)localJFreeChart);
  }
  private static JFreeChart createChartOfEbHit(XYDataset paramXYDataset)
  {
	  JFreeChart localJFreeChart = ChartFactory.createTimeSeriesChart("EB hit count per 100 spins", "Date", "Price Per Unit", paramXYDataset, true, true, false);
	  localJFreeChart.setBackgroundPaint(Color.white);
	  XYPlot localXYPlot = (XYPlot)localJFreeChart.getPlot();
	  localXYPlot.getDomainAxis().setAutoRange(true);
	  localXYPlot.setBackgroundPaint(Color.lightGray);
	  localXYPlot.setDomainGridlinePaint(Color.white);
	  localXYPlot.setRangeGridlinePaint(Color.white);
	  localXYPlot.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D));
	  localXYPlot.setDomainCrosshairVisible(true);
	  localXYPlot.setRangeCrosshairVisible(true);
	  XYItemRenderer localXYItemRenderer = localXYPlot.getRenderer();
	  Object localObject = null;
	  if (localXYItemRenderer instanceof XYLineAndShapeRenderer)
	  {
		  localObject = (XYLineAndShapeRenderer)localXYItemRenderer;
		  ((XYLineAndShapeRenderer)localObject).setDefaultShapesVisible(true);
		  ((XYLineAndShapeRenderer)localObject).setDefaultShapesFilled(true);
	  }
	  localObject = (DateAxis)localXYPlot.getDomainAxis();
	  ((DateAxis)localObject).setDateFormatOverride(new SimpleDateFormat("HH:mm:ss"));
	  return ((JFreeChart)localJFreeChart);
  }

  
  @Override
	public void run()
	{
		createDataset();
		
	}
  private static XYDataset createDataset()
  {
    for (int i = 0; i < 1000; i++)
	{
    	double totalWon = ThreadLocalRandom.current().nextDouble(100, 100000);
        double totalBaseSpent = ThreadLocalRandom.current().nextDouble(10, 1000);
        double totalEBSpent = ThreadLocalRandom.current().nextDouble(100, 10000);
        double totalEBSpentWithoutBet =ThreadLocalRandom.current().nextDouble(0.1, 2.1);//ebPrice/bet
        double totalBaseWon = ThreadLocalRandom.current().nextDouble(100, 10000);
        double totalEBWon = ThreadLocalRandom.current().nextDouble(100, 100000);
        double rtp = totalWon / (totalBaseSpent + totalEBSpent);
        double baseRTP = totalBaseWon / totalBaseSpent;
        double ebRTP = totalEBWon / totalEBSpent;
        int spinCount = ThreadLocalRandom.current().nextInt(1, 10000);
        int ebRound = ThreadLocalRandom.current().nextInt(1, 100000);
        long ebCount = ThreadLocalRandom.current().nextInt(1, 9);

        DrawRTPLine.rtp.add(new Second(), rtp);
        DrawRTPLine.baseRTP.add(new Second(), baseRTP);
        DrawRTPLine.ebRTP.add(new Second(), ebRTP);
        DrawRTPLine.ebPrice.add(new Second(), totalEBSpentWithoutBet / ebCount);
        DrawRTPLine.ebRoundPer.add(new Second(), (double) ebRound / spinCount);
//    	localTimeSeries.addOrUpdate(new Second(new Date()), ThreadLocalRandom.current().nextInt(1, 100)*i);
    	try
		{
			Thread.currentThread().sleep(1000L);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
    
    TimeSeriesCollection localTimeSeriesCollection = new TimeSeriesCollection();
    return localTimeSeriesCollection;
  }
  
  public static void main(String[] args)
  {
	  DrawRTPLine localTimeSeriesDemo1 = new DrawRTPLine("Time Series Demo 1");
	  localTimeSeriesDemo1.setTitle("GridWindow Application");
	  localTimeSeriesDemo1.pack();
	  localTimeSeriesDemo1.setVisible(true);
	  localTimeSeriesDemo1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  localTimeSeriesDemo1.setLocationRelativeTo(null);
      RefineryUtilities.centerFrameOnScreen(localTimeSeriesDemo1);
      new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(new Thread(localTimeSeriesDemo1), 5, 5, TimeUnit.SECONDS);
	  
  }
  
  public static void start(){
	  DrawRTPLine localTimeSeriesDemo1 = new DrawRTPLine("Time Series Demo 1");
	  localTimeSeriesDemo1.setTitle("GridWindow Application");
	  localTimeSeriesDemo1.pack();
	  localTimeSeriesDemo1.setVisible(false);
	  localTimeSeriesDemo1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  localTimeSeriesDemo1.setLocationRelativeTo(null);
      RefineryUtilities.centerFrameOnScreen(localTimeSeriesDemo1);
      new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(new Thread(localTimeSeriesDemo1), 5, 5, TimeUnit.SECONDS);
  }

	
}