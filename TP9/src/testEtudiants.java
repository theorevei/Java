import java.io.File;

public class testEtudiants {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		etudiants ets = new etudiants();
		Etudiant javaXML = new Etudiant();
		javaXML.setNom("Ducros");
		javaXML.setPrenom("Matthieu");
		javaXML.setGroupe((int) 2);
		ets.ajoutEtudiant(javaXML);
		System.out.println(ets.toString());
		boolean sauve = ets.ecritureFichier(new File("etudiant2.xml"));
		if (!sauve) {
			System.err.println("Erreur lors de la sauvegarde du fichier");
			System.exit(1);
		}
		boolean lu = ets.lectureFichier(new File("etudiants2.xml"));
		if (!lu) {
			System.err.println("Erreur lors de la lecture du fichier");
			System.exit(1);
		}
		System.out.println(ets.toString());
	}

}
