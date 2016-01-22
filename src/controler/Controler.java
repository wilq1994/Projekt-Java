package controler;

import java.awt.event.KeyListener;

import connection.Client;
import connection.Communication;
import connection.Server;
import model.Model;
//import view.View;

public class Controler
{
	static private Communication communication;
	static private KeyListener listener;
	static private Model model;
	// private View view;
	static private String signal;

	public Controler()
	{

	}

	static private void mainLoop()
	{

	}

	static private void startListen()
	{

	}

	static private void stopListen()
	{

	}

	static public void handleClickedButton (String  clickedButton)
	{
		
	}
	
	static public void handleClickedBouble (String  clickedButton)
	{
		
	}
	
	
	
	/**
	 * funkcja main stworzona do testowania dzia³ania po³¹czenia sieciowego
	 * 
	 */
	static public void main()
	{
		communication = new Server(1234, model);
		Client client = new Client("127.0.0.1", 1234, model);
		Thread sThread = new Thread(communication);
		Thread cThread = new Thread(client);
		sThread.run();
		cThread.run();

	}

}
