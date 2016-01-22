package controler;

import java.awt.event.KeyListener;

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
		view.changeView(status);
		model = m;
		model.quitGame();
	}

	static public void handleClickedButton(String clickedButton)
	{
		if (clickedButton.toUpperCase() == "NOWA GRA" || clickedButton.toUpperCase() == "NEW GAME")
		{
			startGame();
		} else if (clickedButton.toUpperCase() == "USTAWIENIA" || clickedButton.toUpperCase() == "SETTINGS")
		{

		} else if (clickedButton.toUpperCase() == "WYJSCIE" || clickedButton.toUpperCase() == "EXIT")
		{

		}
	}

	static public void handleClickedBouble(String clickedButton)
	{
		model.handleClick(clickedButton);
	}

	static private void mainLoop()
	{

	}

	static private void startGame()
	{
		status = "game";
		model.newGame(1, "fajny tytul", model.generateTrack(), false);
		view.changeView(status);
		updater = new Updater(model, view);
		Thread th = new Thread(updater);
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
