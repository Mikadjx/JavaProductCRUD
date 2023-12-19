package application;

import java.util.List;

public interface IApplication {
	public void createBDD(String nomBDD);
//	
	public void createTable(String nomBDD, String nomTable);
	
	public void addProduct(String nomBDD, String nomTable,Produit produit);
	public void updateProduct(String nomBDD,String nomTable, Produit produit);
	public void deleteProduct(String nomBDD, String nomTable, int idProduit);
	public Produit getProduct(String nomBDD, String nomTable, int idProduit);
	public List<Produit> getProducts(String nomBDD,String nomTable);
	public void  getProductsByKeyword(String nomBDD, String nomTable, String keyword);
	public void dropTable(String nomBDD, String nomTable);
	public void dropBDD(String nomBDD);
	

}
