
public class Commercial extends Personne implements Cloneable {
	
private String statut;

private Client[] tab = new Client[4];

public Commercial(String nom, String prenom, String statut) {
	super(nom, prenom);
	this.statut = statut;
}

public Client[] getTab() {
	return tab;
}

public void setTab(Client[] tab) {
	this.tab = tab;
}

public String getStatut() {
	return statut;
}

public void setStatut(String statut) {
	this.statut = statut;
}

public Commercial clone() throws CloneNotSupportedException{
	Commercial copie = (Commercial)super.clone();
	copie.tab = tab.clone();
	System.arraycopy(tab, 0, copie.tab, 0 , tab.length);
	return copie;
}

@Override
public String toString() 
{
	
	Client cl1 = new Client("Vargas","José","Cansii");
	Client cl2 = new Client("Reveillard","Théo","Tata");
	Client cl3 = new Client("titi","Toto","TEST");
	Client cl4 = new Client("tutu","José","Cansii");
	tab[0] = cl1;
	tab[1] = cl2;
	tab[2] = cl3;
	tab[3] = cl4;
	String temp = "";
	for(int i=0;i<3;i++){
		temp+=tab[i];
	}
	return "Le commercial "+getNom()+" "+getPrenom()+" est "+ statut+"\nLes clients sont"+temp;
}


}
