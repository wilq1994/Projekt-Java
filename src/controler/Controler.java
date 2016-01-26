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
		
		if(status.equals("server") || status.equals("client"))
		{
			startGame(true);
			view.changeView(status);
		}
	}
 
	static public void handleClickedButton(String clickedButton)
	{
		if (clickedButton.toUpperCase().equals("MAIN"))
		{
			status = "menu";
			view.changeView(status);
		}
		else if (clickedButton.toUpperCase().equals("MULTI"))
		{
			status = "multi";
			view.changeView(status);
		}
		else if(status.equals("menu"))
		{
			handleMenuButton(clickedButton);
		}
		else if(status.equals("multi"))
		{
			handleMultiButton(clickedButton);
		}
		else if(status.equals("server"))
		{
			handleServerButton(clickedButton);
		}
		else if(status.equals("client"))
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
		if (clickedButton.toUpperCase().equals("NOWA GRA"))
		{
			startGame(false);
		}
		else if (clickedButton.toUpperCase().equals("MULTI"))
		{
			status = "multi";
			view.changeView(status);
		}
		else if (clickedButton.toUpperCase().equals("USTAWIENIA"))
		{

		}
		else if (clickedButton.toUpperCase().equals("WYJSCIE"))
		{

		}
	}
	
	static private void handleMultiButton(String clickedButton)
	{
		if (clickedButton.toUpperCase().equals("SERVER"))
		{
			status = "server";
			view.changeView(status);
		}
		else if (clickedButton.toUpperCase().equals("CLIENT"))
		{
			status = "client";
			view.changeView(status);
		}
	}

	static private void handleServerButton(String clickedButton)
	{
		if (clickedButton.substring(0, 3).toLowerCase().equals("s, "))
		{
			startServer(clickedButton.substring(3));
		}
	}
	
	static private void handleClientButton(String clickedButton)
	{
		if (clickedButton.substring(0, 3).toLowerCase().equals("c, "))
		{
			startClient(clickedButton.substring(3));
		}
	}
	
	static private void startGame(boolean multi)
	{
		status = "game";
		HashMap<Integer, String> track = model.generateTrack();
		model.newGame(1, "fajny tytul", track, multi);
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
		String args[] = data.split(",\\s+");
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

	public static void gameFinished()
	{
		if (status.equals("game"))
		{
			status = "menu";
			view.changeView(status);
			//view.setScore(model.getOwnPetHappiness(), model.getEnemyPetHappiness());
			model.quitGame();
		}
	}
}
