import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Anagrammes {
	
private String mot;
private int indice;
public Collection<Character> maCollection;

public Anagrammes(String mot, int indice) {
	this.mot = mot;
	this.indice = indice;
	this.maCollection = new ArrayList<Character>();
}

public String TraiteMot(String s, int indice, int profondeur)
{
	s=s.toLowerCase();
	indice=this.indice;
	String res[];
	for(int i=0; i < s.length(); i=i+1)
	{
		char c = s.charAt(i);
		maCollection.add(c);
	}
	
	maCollection resultat = new maCollection;
	
	Iterator<Character> it = maCollection.iterator();
	int i=0;
	if (profondeur != 1)
	{
		
	}
	while(it.hasNext())
	{
		if(i < it.)
		{
			it.toString();
		}
		else
			TraiteMot(s,0,profondeur+1);
		i=1+1;
	}
}

	/*public char[] getLetters(String word) {
	      word = word.toLowerCase();
	      ArrayList list = this.maCollection;
	      String next;
	      int num = list.countTokens();
	      char[] answer = new char[num];
	      for (int i = 0; i < num; i++ ) {
	         next = list.nextToken();
	         if (next.length()>=1)
	            answer[i]= next.charAt(0);
	      }
	      return answer;
	   } */

public String getMot() {
	return mot;
}
public void setMot(String mot) {
	this.mot = mot;
}
public int getIndice() {
	return indice;
}
public void setIndice(int indice) {
	this.indice = indice;
}

}
