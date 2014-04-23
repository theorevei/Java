
public class CarteReseau extends EquipementAbstract implements EquipementReseau{
	String statut;
	String addressIp;
	
	public CarteReseau(String nom,String statut, String addressIp) {
		super.setNom(nom);
		this.statut = statut;
		this.addressIp = addressIp;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getAddressIp() {
		return addressIp;
	}
	public void setAddressIp(String addressIp) {
		this.addressIp = addressIp;
	}
	
	public String infoAdresseIP() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void resetEquipement() {
		// TODO Auto-generated method stub
		this.statut = "";
		this.addressIp = "";
	}
}
