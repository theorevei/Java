
public class Message {
	private String sujet;
	private String texte;
	private int numMessage;
	
	public Message(String sujet, String texte, int numMessage) {
		this.sujet = sujet;
		this.texte = texte;
		this.numMessage = numMessage;
	}
	
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public int getNumMessage() {
		return numMessage;
	}
	public void setNumMessage(int numMessage) {
		this.numMessage = numMessage;
	}
	
	@Override
	public String toString() {
		return numMessage+"-"+sujet+"-"+texte;
	}

	

}
