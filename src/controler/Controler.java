package controler;

import java.awt.event.KeyListener;
import java.util.HashMap;

import connection.Client;
import connection.Communication;
import connection.Server;
import model.Model;
import view.View;

public class Controler
{
	static private Communication communication;
	static private KeyListener listener;
	static private Model model;
	static private View view;
	static private String signal;
	static private Updater updater;
	static private String status;

	public Controler()
	{

	}
	
	static public void Init(Model m,View v)
	{
		status = "menu";
		view = v;
		model = m;
		model.quitGame();
	}
	
	public static void connectionReady()
	{
		if(signal == "serwer" || signal =="client")
		{
			startGame();
		}
	}
 
	static public void handleClickedButton(String clickedButton)
	{
		if(status == "menu")
		{
			handleMenuButton(clickedButton);
		}
		else if(status == "multi")
		{
			handleMultiButton(clickedButton);
		}
		else if(status == "server")
		{
			handleServerButton(clickedButton);
		}
		else if(status == "client")
		{
			handleClientButton(clickedButton);
		}
	}

	static public void handleClickedBouble(String clickedButton)
	{
		model.handleClick(clickedButton);
	}
	
	static private void handleMenuButton(String clickedButton)
	{
		if (clickedButton.toUpperCase() == "NOWA GRA")
		{
			startGame();
		}
		else if (clickedButton.toUpperCase() == "MULTI")
		{
			status = "multi";
			view.changeView(status);
		}
		else if (clickedButton.toUpperCase() == "USTAWIENIA")
		{

		}
		else if (clickedButton.toUpperCase() == "WYJSCIE")
		{

		}
	}
	
	static private void handleMultiButton(String clickedButton)
	{
		if (clickedButton.toUpperCase() == "SERWER")
		{
			status = "serwer";
			view.changeView(status);
		}
		else if (clickedButton.toUpperCase() == "CLIENT")
		{
			status = "client";
			view.changeView(status);
		}
	}

	static private void handleServerButton(String clickedButton)
	{
		if (clickedButton.substring(0, 2).toLowerCase() == "s ")
		{
			startServer(clickedButton.substring(3));
		}
	}
	
	static private void handleClientButton(String clickedButton)
	{
		if (clickedButton.substring(0, 2).toLowerCase() == "c ")
		{
			startClient(clickedButton.substring(3));
		}
	}
	
	static private void startGame()
	{
		status = "game";
		HashMap<Integer, String> track = model.generateTrack();
		model.newGame(1, "fajny tytul", track, false);
		view.changeView(status);
		updater = new Updater(model, view);
		Thread th = new Thread(updater);
		th.start();
	}
	
	static private void startServer(String data)
	{
		int port = Integer.parseInt(data);
		communication = new Server(port, model);
		Thread th = new Thread(communication);
		th.start();
	}
	
	static private void startClient(String data)
	{
		String args[] = data.split("\\s+");
		String ip = args[0];
		int port = Integer.parseInt(args[1]);
		communication = new Client(ip, port, model);
		Thread th = new Thread(communication);
		th.start();
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
