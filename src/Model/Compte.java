package Model;

public class Compte {

	private int id;
	private String nomClient;
	private float solde;
	public Compte(int id, String nomClient, float solde) {
		super();
		this.id = id;
		this.nomClient = nomClient;
		this.solde = solde;
	}
	public Compte() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	@Override
	public String toString() {
		return "Compte [id=" + id + ", nomClient=" + nomClient + ", solde=" + solde + "]";
	}
	
	
	
	
	
}
