import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

public class etudiants {

	public ArrayList listeEtudiants;

	public etudiants() {
		this.listeEtudiants = new ArrayList();
	}

	public boolean ajoutEtudiant(Etudiant e) {
		return this.listeEtudiants.add(e);
	}

	public String toString() {
		String result = "Etudiants : ";
		int nbEtudiants = this.listeEtudiants.size();
		result += "" + nbEtudiants + " etudiant(s) \n\n";
		for (int i = 0; i < nbEtudiants; i++) {
			Etudiant e = (Etudiant) (this.listeEtudiants.get(i));
			result += "Etudiant " + (i + 1) + " :\n";
			result += e.toString();
			result += "\n";
		}
		return result;
	}

	public boolean lectureFichier(File in) {
		boolean result = true;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			FileInputStream fis = new FileInputStream(in);
			InputSource is = new InputSource(fis);
			Document document = db.parse(is);
			this.listeEtudiants = new ArrayList();
			// obtenir la liste de tous les éléments « Livre » de l’arbre DOM
			NodeList etudiants = document.getElementsByTagName("Etudiant");
			for (int i = 0; i < etudiants.getLength(); i++) {
				Etudiant e = new Etudiant();
				Element etudiant = (Element) (etudiants.item(i));
				Element nom = (Element) (etudiant.getElementsByTagName("Nom")
						.item(0));
				Text nom_text = (Text) (nom.getFirstChild());
				e.setNom(nom_text.getData().replaceAll("\n", ""));

				Element prenom = (Element) (etudiant
						.getElementsByTagName("Prenom").item(0));
				Text prenom_text = (Text) (prenom.getFirstChild());
				e.setPrenom(prenom_text.getData().replaceAll("\n", ""));

				Element groupe = (Element) (etudiant
						.getElementsByTagName("Groupe").item(0));
				Text groupe_text = (Text) (groupe.getFirstChild());
				e.setGroupe(new Integer(groupe_text.getData().replaceAll("\n",
						"")).intValue());
				this.listeEtudiants.add(e);
			}
			fis.close();
		} catch (Exception e) {
			return false;
		}
		return result;
	}

	public boolean ecritureFichier(File out) {
		boolean result = true;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.newDocument();
			Element etudiants = d.createElement("Etudiants");
			d.appendChild(etudiants);
			for (int i = 0; i < this.listeEtudiants.size(); i++) {
				Etudiant e = (Etudiant) (this.listeEtudiants.get(i));
				Element etudiant = d.createElement("Etudiant");
				Element nom = d.createElement("Nom");
				Text t_nom = d.createTextNode(e.getNom());
				nom.appendChild(t_nom);
				etudiant.appendChild(nom);
				etudiants.appendChild(nom);
			}
			TransformerFactory etud = TransformerFactory.newInstance();
			Transformer transformer = etud.newTransformer();
			Result resultat = new StreamResult(out);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			Source source = new DOMSource(d);
			transformer.transform(source, resultat);

		} catch (Exception e) {
			return false;
		}
		return result;
	}

	public ArrayList getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(ArrayList listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}

}
