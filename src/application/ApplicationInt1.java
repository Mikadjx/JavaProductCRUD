package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ApplicationInt1 implements IApplication {
	
	
//Création de la base donnée 	
	
@Override
	public void createBDD(String nomBDD) {
		Connection  cn = ConnectionSingleton.getCn();
		String sql = "CREATE DATABASE if not exists " + nomBDD;
	Statement stmt;
	try {
		stmt = cn.createStatement();
		stmt.execute(sql);
		stmt.close();
	} catch(SQLException e) {
		e.printStackTrace();
		
	}
	}

//Création de table 
	
	@Override
	public void createTable(String nomBDD , String nomTable) {
		Connection  cn = ConnectionSingleton.getCn();
        String sql = "CREATE TABLE if not exists " + nomBDD + "." + nomTable + "(idProduit INT NOT NULL AUTO_INCREMENT, designation VARCHAR(45), quantite INT NOT NULL, prix DOUBLE NOT NULL, PRIMARY KEY(idProduit))";
        Statement stmt;
        try {
            stmt = cn.createStatement();
            stmt.execute(sql);
            stmt.close();
        
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        }
	
	
// Ajout de produit 
	
	@Override
	public void addProduct(String nomBBD, String nomTable, Produit produit) {
		Connection cn = ConnectionSingleton.getCn();
		String sql = " Insert into " + nomBBD + "." + nomTable + "(Designation, quantite, prix) values (?,?,?)";
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(sql);
			ps.setString(1, produit.getDesignation());
			ps.setInt(2, produit.getQuantite());
			ps.setDouble(3, produit.getPrix());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Mise à jour d'un produit 

	@Override
	public void updateProduct(String nomBDD,String nomTable, Produit produit) {
		Connection cn = ConnectionSingleton.getCn();
		String sql = " Update " + nomBDD + "." + nomTable + " SET prix = ? WHERE idProduit = 2";
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(sql);
			ps.setDouble(1, produit.getPrix());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
// Suppression d'un produit		
	
@Override
	public void deleteProduct(String nomBDD, String nomTable, int idProduit) {
		// TODO Auto-generated method stub
		Connection cn = ConnectionSingleton.getCn();
		String sql = "DELETE FROM " + nomBDD + "." + nomTable + " WHERE idProduit = ?";
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(sql);
			ps.setInt(1, idProduit);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

@Override
public Produit getProduct(String nomBDD, String nomTable, int idProduit) {
	// TODO Auto-generated method stub
	Connection cn = ConnectionSingleton.getCn();
	String sql = "SELECT * FROM " + nomBDD + "." + nomTable + " WHERE idProduit = " + idProduit;
	Produit p = new Produit();
	PreparedStatement ps;
	try {
		ps = cn.prepareStatement(sql);
		ResultSet resultSet = (ResultSet) ps.executeQuery();
		resultSet.next();
		p.setIdProduit(idProduit);
		p.setDesignation(resultSet.getString("designation"));
		p.setQuantite(resultSet.getInt("quantite"));
		p.setPrix(resultSet.getDouble("prix"));
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return p;
}
	

@Override
//ici pas d'id car pas besoin d'un id précis pour tous les prdts
public List<Produit> getProducts(String nomBDD, String nomTable) {
	// TODO Auto-generated method stub
	//Créer liste des produits
	List<Produit> produits = new ArrayList<Produit>();
	Connection cn = ConnectionSingleton.getCn();
	String sql = "SELECT * FROM " + nomBDD + "." + nomTable;
	PreparedStatement ps;
	try {
		ps = cn.prepareStatement(sql);
		ResultSet resultSet = (ResultSet) ps.executeQuery();
		//retourner chaque produit tant qu'il y a des produits dans resultSet
		while(resultSet.next()) {
			//on crée ici car ailleurs cela écrase la donnée précédente et affiche donc la même chose
			Produit p = new Produit();
			p.setIdProduit(resultSet.getInt("idProduit"));
			p.setDesignation(resultSet.getString("designation"));
			p.setQuantite(resultSet.getInt("quantite"));
			p.setPrix(resultSet.getDouble("prix"));
			//j'ajoute le produit p à la liste des produits
			produits.add(p);
		}
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//retourne les pdts de la List
	return produits;
}

	
	  @Override
	    public ArrayList<Produit> getProductsByKeyword(String nomBDD, String nomTable, String keyword) {
	        ArrayList<Produit> produits = new ArrayList<Produit>();
	        String sql = "SELECT * FROM " + nomBDD + "." + nomTable + " WHERE Designation LIKE ?";
	        Connection cn = ConnectionSingleton.getCn();
	        PreparedStatement preparedStatement;
	        Produit produit = null;
	        try {
	            preparedStatement = cn.prepareStatement(sql);
	            preparedStatement.setString(1, "%" + keyword + "%");
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()){
	                produits.add(new Produit(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getDouble(4)));
	            }
	            preparedStatement.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }

	        return produits;
	    }
	  
		@Override
		public void dropTable(String nomBDD, String nomTable) {
			// TODO Auto-generated method stub
			Connection cn = ConnectionSingleton.getCn();
			String sql = "DROP TABLE " + nomBDD + "." + nomTable;
			Statement stmt;
			try {
				stmt = cn.createStatement();
				stmt.execute(sql);
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			@Override
			public void dropBDD(String nomBDD) {
				// TODO Auto-generated method stub
				Connection cn = ConnectionSingleton.getCn();
				String sql = "DROP DATABASE " + nomBDD;
				Statement stmt;
				try {
					stmt = cn.createStatement();
					stmt.execute(sql);
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}



		}
		

