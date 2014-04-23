
public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c1 = new Client("Jose","VARGAS","CANSII");
		Client c2 = new Client("Theo","REVEILLARD","LDSYSTEM");
		Client c3 = new Client("Patrick","DUDU","PARTY");
		Commercial C1 = new Commercial("titi","tata","Present");
		Commercial C2 = new Commercial("toto","sasa","Absent");
		Object[] tab = {c1,c2,c3,C1,C2};
		Client[] tableauClient = new Client[3];
		Commercial[] tableauCommercial = new Commercial[2];
		for(int i=0;i<tab.length;i++)
		{
			if (tab[i] instanceof Client) tableauClient[tableauClient.length - 1] = (Client) tab[i];
			else tableauCommercial[tableauCommercial.length - 1] = (Commercial) tab[i];
		}
		System.out.println(tableauClient.length);
		System.out.println(tableauCommercial.length);

	}

}
