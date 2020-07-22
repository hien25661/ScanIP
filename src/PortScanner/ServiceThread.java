package PortScanner;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceThread extends Thread {
	public boolean isStop;
	private String host;
	private int startPort;
	private int endPort;
	private Main main;
	
	public ServiceThread(String host, int startPort, int endPort, Main main)
	{
		isStop = false;
		this.host = host;
		this.startPort = startPort;
		this.endPort = endPort;
		this.main = main;
	}
	
	public void run()
	{
		main.getTaOutput().setText("");
		main.getTaOutput().append("Scan Started\n============");
		main.getTaOutput().append("\nOpen Ports:");
		for (int i = startPort; i <= endPort; i++)
		{
			if (isStop != true)
			{
				main.getLblStatus().setText("Scanning port: " + i);
				ScanThread t = new ScanThread(host, i, main);
				t.start();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ServiceThread.class.getName()).log(Level.SEVERE, null, ex);
                }
			}
			else
			{
				break;
			}
		}
		
		if (isStop)
			main.getLblStatus().setText("Scan Stopped");
		else
			main.getLblStatus().setText("Scan complete");
		
		main.getBtnScan().setEnabled(true);
		main.getBtnStop().setEnabled(false);
		main.getTaOutput().setSelectionStart(main.getTaOutput().getText().length());
	}
}
