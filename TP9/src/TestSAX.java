import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class TestSAX {
	// argument 0 : le chemin du document xml à analyser
	public static void main(String args[]) {
		XMLReader parser = null;
		try {
			parser = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
		} catch (SAXException e) {
			System.out.println(e);
		}
		try {
			InputSource is = new InputSource(new FileInputStream(new File("etudiants.html")));
			EtudiantsSAX ce = new EtudiantsSAX();
			parser.setContentHandler(ce);
			parser.parse(is);

		} catch (SAXException e) {
			System.out.println(e);
		} catch (IOException f) {
			System.out.println(f);
		}
	}
}