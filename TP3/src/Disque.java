public class Disque extends EquipementAbstract implements EquipementStockage{
	String statut;
	String capacite;
	

	public Disque(String statut, String capacite) {
		this.statut = statut;
		this.capacite = capacite;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getCapacite() {
		return capacite;
	}
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
	public void affecteStockage(int Mo) {
		// TODO Auto-generated method stub
		
	}
	public int infoStockage() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void resetEquipement() {
		// TODO Auto-generated method stub
		
	}
}