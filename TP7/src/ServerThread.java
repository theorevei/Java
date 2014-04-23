import java.net.Socket;
import java.util.concurrent.ExecutorService;


public class ServerThread implements Runnable
{
	ExecutorService es;
	Socket sockcli = null;

	public ServerThread (ExecutorService es, Socket sockcli)
	{
		this.es = es;
		this.sockcli = sockcli;
	}

	public void run()
	{
		for(int i=0;i<=4;i++)
		{
			System.out.println("opŽration "+i);
		}

		System.out.println("fin des opŽrations");
	}
}
