package PortScanner;

import java.io.*;
import java.net.*;

public class ScanThread extends Thread {
	private String host;
	private int port;
	private Main main;
	
	public ScanThread(String host, int port, Main main)
	{
		this.host = host;
		this.port = port;
		this.main = main;
	}
	
	public void run()
	{
		try {
			Socket s = new Socket(host, port);
			main.getTaOutput().append("\n" + port);
			main.getTaOutput().setSelectionStart(main.getTaOutput().getText().length());
		}
		catch(SocketException se)
		{
			//Port is close
		}
		catch(UnknownHostException uhe) {}
		catch(IOException ioe) {}
	}
}
