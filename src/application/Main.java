package application;



public class Main {

	public static void main(String[] args) { 
		
		String nomBDD ="gestionDeproduit1";
		String nomTable ="produit";
		ApplicationInt1 applicationInt1 = new ApplicationInt1();
		applicationInt1.createBDD(nomBDD);
		applicationInt1.createTable(nomBDD, nomTable);
		Produit prod1 = new Produit(0, "Dell Optiplex 9030", 10, 1000);
		Produit prod2 = new Produit(0, "Lenovo ThinkCentre M73", 12, 2000);
		Produit prod3 = new Produit(0, "Apple MAcbook pro 13", 5, 3000);
		//applicationInt1.addProduct(nomBDD, nomTable, prod1);
		//applicationInt1.addProduct(nomBDD, nomTable, prod2);
		//applicationInt1.addProduct(nomBDD, nomTable, prod3);
		//prod2.setPrix(500.4);
		//applicationInt1.updateProduct(nomBDD,nomTable, prod2);
		//applicationInt1.deleteProduct(nomBDD, nomTable, 2);
		//System.out.println(applicationInt1.getProduct(nomBDD, nomTable, 1));
		
      //  for(Produit p : applicationInt1.getProducts(nomBDD, nomTable)) {
      //  System.out.println(p.toString());
	//}
		//applicationInt1.dropTable(nomBDD,,nomTable);
        
        applicationInt1.dropBDD(nomBDD);

}
}
