import java.util.ArrayList;

public class Etudiant {
	private String nom;
	private String prenom;
	private int id;
	private int groupe;
	protected ArrayList listeEtudiants;

	public Etudiant() {
		this.nom = null;
		this.prenom = null;
		this.groupe = 0;
	}

	public boolean ajoutLivre(Etudiant e) {
		return this.listeEtudiants.add(e);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroupe() {
		return groupe;
	}

	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}

	public String toString() {
		String result = "\n";
		result += "Nom : " + this.getNom() + " - ";
		result += "Prenom : " + this.getPrenom() + " ";
		result += "Groupe : " + this.getGroupe();
		return result;
	}
}
