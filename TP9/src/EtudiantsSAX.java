import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EtudiantsSAX extends DefaultHandler {
	private Locator loc;
	private String sortieHTML;
	private ArrayList listeEtudiants;

	public void setDocumentLocator(Locator locator) {
		this.loc = locator;
	}

	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		if (prefix.equals(""))
			prefix = "<default>";
		System.out.println("Ligne " + this.loc.getLineNumber() + ", \tcolonne "
				+ this.loc.getColumnNumber()
				+ " \t:début de portée de l'espace de nommage (" + prefix
				+ ", " + uri + ")");
	}

	public void endPrefixMapping(String prefix) throws SAXException {
		System.out.println("Ligne " + this.loc.getLineNumber() + ", \tcolonne "
				+ this.loc.getColumnNumber()
				+ " \t:fin de portée de l'espace de nommage " + prefix);
	}

	public void startDocument() throws SAXException {
		etudiants ets = new etudiants();
		boolean lu = ets.lectureFichier(new File("etudiants.xml"));
		if (!lu) {
			System.err.println("Erreur lors de la lecture du fichier");
			System.exit(1);
		}
		this.listeEtudiants = ets.getListeEtudiants();
		System.out
				.println("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><title>Etudiants</title></head><body>");
	}

	public void endDocument() throws SAXException {
		sortieHTML += "</body></html>";
	}

	public void startElement(String uri, String local, String qName,
			Attributes attrs) throws SAXException {

		if (qName == "listeEtudiants") {
			for (int i = 0; this.listeEtudiants != null; i++) {
				System.out.println(this.listeEtudiants.get(i));
			}
		}
		if (qName == "etudiant") {

		}
		/*
		 * System.out.print("<h1>"+qName+"</h1>"); int l = attrs.getLength(); if
		 * (l > 0) { for (int i = 0; i < l; i++)
		 * System.out.print(attrs.getQName(i) + attrs.getValue(i)); }
		 * System.out.println();
		 */
	}

	public void endElement(String uri, String local, String qName)
			throws SAXException {
		// System.out.println("Ligne "+this.loc.getLineNumber()+", \tcolonne "+this.loc.getColumnNumber()+" \t:fin d'un élément "
		// + qName);
	}

	public void characters(char[] ch, int start, int l) throws SAXException {
		String s = new String(ch, start, l);
		/*
		 * if (!(s.equals("\n"))) System.out.println("<li>" + s + "</li>");
		 */
	}

}