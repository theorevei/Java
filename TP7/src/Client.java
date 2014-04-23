import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client implements Runnable
{
	ExecutorService es;
	Socket sockcli = null;

	public Client (ExecutorService es)
	{
		this.es = es;
	}

	private int connexion(String url)
	{
		try
		{
			sockcli = new Socket (url, 6020);
		}
		catch (IOException ex)
		{ return -1; }

		if(sockcli.isConnected())
			return 1;
		else
			return 0;
	}

	public void run ()
	{
		boolean boucle = true;

		while(boucle)
		{
			switch(connexion("127.0.0.1"))
			{
				case 1 :
					System.out.println("Hello world!");
					break;
				default :
					boucle = false;
					break;
			}
		}
	}

	public static void main (String args[]) throws Exception
	{
		ExecutorService es = Executors.newFixedThreadPool(3);
		Client client = new Client(es);
		es.execute(client);
	}
}
