
public class Client extends Personne implements Cloneable {
	
	private String nomSociete;
	

	public Client(String nom, String prenom, String nomSociete) {
		super(nom, prenom);
		this.nomSociete = nomSociete;
	}

	public String getNomSociete() {
		return nomSociete;
	}

	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	
	public Client clone() throws CloneNotSupportedException{
		Client copie = (Client)super.clone();
		return copie;
	}
	
	@Override
	public String toString() {
		return " "+getPrenom()+" "+getNom()+" (société "+nomSociete+")";
	}

}
