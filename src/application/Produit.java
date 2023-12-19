package application;

public class Produit  {


private int idProduit;
private String designation;
private int quantite;
private double prix;
public int getIdProduit() {
	return idProduit;
}
public void setIdProduit(int idProduit) {
	this.idProduit = idProduit;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public Produit(int idProduit, String designation, int quantite, double prix) {
	super();
	this.idProduit = idProduit;
	this.designation = designation;
	this.quantite = quantite;
	this.prix = prix;
}
public Produit() {
	super();

}
@Override
public String toString() {
	return "Produit [idProduit=" + idProduit + ", designation=" + designation + ", quantite=" + quantite + ", prix="
			+ prix + "]";
}

}

