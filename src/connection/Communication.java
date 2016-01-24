package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.locks.Lock;

import model.Model;

public abstract class Communication implements Runnable
{
	protected Socket socket;
	protected BufferedReader reader;
	protected BufferedWriter writer;
	protected Model model;
	protected boolean active;

	public void run()
	{

	}

}
