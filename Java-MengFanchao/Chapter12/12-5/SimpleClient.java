import java.net.*;
import java.io.*;

public class SimpleClient
{
	Socket s;
	InputStream sis;
	DataInputStream sdis;
	String receiveMessage;

	static public void main(String args[])
	{
		SimpleClient that = new SimpleClient();
		that.go();
	}

	public void go()
	{
		try
		{
			s = new Socket("127.0.0.1", 5432);				
			sis = s.getInputStream();
			sdis = new DataInputStream(sis);
			receiveMessage = sdis.readUTF();
			System.out.println("接收到的信息是：");
			System.out.println(receiveMessage);

			sdis.close();
			sis.close();
			s.close();
		}
		catch(IOException e) 
		{
			System.out.println(e);
		}
	}
}
