import java.io.IOException;

public class TestIO {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		FonctionsIO.copyFile("test.txt","nomsprenoms.txt","mail.txt");
		//FonctionsIO.reconstitution("nomsprenoms.txt","mail.txt","test.txt");
		FonctionsIO.reconstitution("test2.txt", "nomsprenoms.txt", "mail.txt");

	}

}
