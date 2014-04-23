
public class Personne {
private String nom;
private String prenom;
private Message message;

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
public Message getMessage() {
	return message;
}
public void setMessage(Message message) {
	this.message = message;
}
public Personne(String nom, String prenom, Message message) {
	nom = nom.toUpperCase();
	this.nom = nom;
	prenom = prenom.substring(0, 1).toUpperCase()+prenom.substring(1, prenom.length());
	this.prenom = prenom;
	this.message = message;
}
@Override
public String toString() {
	return nom +"-"+ prenom +"-"+ message.getNumMessage() +"-"+ message.getSujet() +"-"+ message.getTexte();
}

}

