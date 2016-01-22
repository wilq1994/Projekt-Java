package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import controler.Controler;
import model.Model;

public class Client extends Communication
{
	private String in, ip;
	private Integer port;

	public Client(String ip, Integer port, Model m)
	{
		active = true;
		this.model = model;
		this.ip = ip;
		this.port = port;
	}
 
	public void run()
	{
		try
		{
			socket = new Socket(InetAddress.getByName(ip), port);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			Controler.connectionReady();
			while (active)
			{
				getHappiness();
				sendHappiness();
			}
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendHappiness() throws IOException
	{
		writer.write("gethappiness");
		writer.newLine();
		writer.flush();
		while ((in = reader.readLine()) == null)
		{
		}
		String tag = in.substring(0, 3);
		String data = in.substring(3);
		if (tag.equals("set"))
		{
			model.setEnemyPetHappiness(Integer.parseInt(data));
		} else
		{
			System.out.println("error: unexpected package - " + in);
		}
	}

	private void getHappiness() throws IOException
	{
		writer.write("set" + model.getOwnPetHappiness());
		writer.newLine();
		writer.flush();
		while ((in = reader.readLine()) == null)
		{
		}
		System.out.println("client got: " + in);
		String tag = in.substring(0, 3);
		String data = in.substring(3);
		if (!tag.equals("got"))
		{
			System.out.println("error: unexpected package - " + in);
		}
		writer.newLine();
		writer.flush();
	}

}
