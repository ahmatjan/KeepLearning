import java.net.*;
import java.io.*;

public class SimpleServer
{
	ServerSocket ss;
	Socket s;
	OutputStream sos;
	DataOutputStream sdos;
	String sendMessage;

	static public void main(String args[])
	{
		SimpleServer that = new SimpleServer();
		that.go();
	}

	public void go()
	{
		try
		{
			ss = new ServerSocket(5432);
		}
		catch(IOException e)
		{
			System.out.print(e);
		}

		try
		{
			while (true)
			{
				s = ss.accept();
				sos = s.getOutputStream();
				sdos = new DataOutputStream(sos);
				sendMessage = "I am Simple Server.";
				sdos.writeUTF(sendMessage);

				sdos.close();
				sos.close();
				s.close();
			}
		}
		catch(IOException e) 
		{
			System.out.println(e);
		}
	}
}
