import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Serveur implements Runnable
{
	ExecutorService es;
	ServerSocket sockserv = null;
	ServerThread chaine = null;

	public Serveur(ExecutorService es)
	{
		this.es = es;

		try
		{
			sockserv = new ServerSocket (6020);
		}
		catch (IOException ex) { }
	}

	public void run()
	{
		int nb_clients = 0;
		System.out.println("le serveur demarre");

		try
		{
			while (true)
			{
				Socket sockcli = sockserv.accept();
				nb_clients++;

				System.out.println("connexion établie : "+nb_clients+"ème client");

				chaine = new ServerThread(es, sockcli);
				es.execute(chaine);
			}
		}
		catch (IOException ex) { }
	}

	public static void main (String args[])
	{
		ExecutorService es = Executors.newFixedThreadPool(10);
		Serveur serv = new Serveur(es);
		es.execute(serv);
	}
}
