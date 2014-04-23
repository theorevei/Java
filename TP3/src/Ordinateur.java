import java.util.Arrays;

public class Ordinateur extends EquipementAbstract{

	private CarteReseau carteReseau;
	private Disque[] disque;

	
	
	public Ordinateur(CarteReseau carteReseau, Disque[] disque) {
		this.carteReseau = carteReseau;
		this.disque = disque;
	}

	public void resetEquipement() {
		// TODO Auto-generated method stub
		
	}
	
	public CarteReseau getCarteReseau() {
		return carteReseau;
	}
	public void setCarteReseau(CarteReseau carteReseau) {
		this.carteReseau = carteReseau;
	}
	public Disque[] getDisque() {
		return disque;
	}
	public void setDisque(Disque[] disque) {
		this.disque = disque;
	}
	
	public void disque(Disque d1,Disque d2){
		d1 = disque[0];
		d2 = disque[1];
	}
	
	@Override
	public String toString() {
		return "Ordinateur [carteReseau=" + carteReseau + ", disque="
				+ Arrays.toString(disque) + "]";
	}

}
