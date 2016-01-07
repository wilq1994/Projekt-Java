package connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;

import model.Model;

public class Server extends Communication
{
	private ServerSocket serverSocket;
	private String in;
	private Integer port;
	
	public Server(Integer port, Model model)
	{
		active=true;
		this.model=model;
		this.port=port;
	}
	
	public void run()
	{
		try
		{
			serverSocket = new ServerSocket(port);
			socket= serverSocket.accept();
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(active)
			{
				while((in=reader.readLine())==null)
				{}
				String tag=in.substring(0, 3);
				String data=in.substring(3);
				if(tag.equals("get"))
				{
					sendHappiness();
					
				}
				else if(tag.equals("set"))
				{
					getHappiness(Integer.parseInt(data));
				}
				else
				{
					System.out.println("error: unexpected package - " + in);
				}
			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sendHappiness() throws IOException
	{
		//writer.write("set" + model.gethappiness());
		writer.newLine();
		writer.flush();
	}
	
	private void getHappiness(Integer data) throws IOException
	{
		//model.sethappiness(data);
		writer.write("got" + data);
		writer.newLine();
		writer.flush();
	}

}
