import java.net.Socket;

public class HTTPServerThread extends Thread
{
   private Socket s;
   public HTTPServerThread(Socket sock) {super(); this.s = sock;}
   public void run()
   {
		try 
		{
		InputStream is = this.s.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "US-ASCII")); String rq = br.readLine();
		if ((rq != null) && (rq.startsWith("GET ")))
		{
		           File f = new File(rq.substring(rq.indexOf(' Õ)+1));
		           if (f.isFile())
		           {
		             DataInputStream dis = new DataInputStream(new FileInputStream(f));
		             byte[] data = new byte[(int) f.length()];
		             dis.readFully(data); dis.close();
		             this.s.getOutputStream().write(data);
		}
		           }
					br.close();
		       } catch (IOException e) {}
		try {this.s.close();} catch (IOException e) {} }
}