
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarteReseau cartereseau = new CarteReseau("UneCR","actif","40go");
		Disque disque1 = new Disque("actif","20go");
		Disque disque2 = new Disque("actif","100go");
		Disque[] disque; 
		disque[0] = disque1;
		disque[1] = disque2;
		
		Ordinateur ordi = new Ordinateur(cartereseau,disque);
	}

}
