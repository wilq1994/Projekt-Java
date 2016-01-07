package controler;

import java.awt.event.KeyListener;

import connection.Client;
import connection.Communication;
import connection.Server;
import model.Model;
//import view.View;

public class Controler
{
	private Communication communication;
	private KeyListener listener;
	private Model model;
	//private View view;
	private String signal;
	
	public Controler()
	{
		
	}
	
	private void mainLoop()
	{
		
	}
	
	private void startListen()
	{
		
	}
	
	private void stopListen()
	{
		
	}
	/**funkcja main stworzona do testowania dzia³ania po³¹czenia sieciowego
	 * 
	 */
	public void main()
	{
		communication=new Server(1234, model);
		Client client=new Client("127.0.0.1", 1234, model);
		Thread sThread=new Thread(communication);
		Thread cThread=new Thread(client);
		sThread.run();
		cThread.run();
		
	}
	
}
