package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
	
	private static  Connection cn;
	
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				cn = DriverManager.getConnection("jdbc:mysql://localhost/","root","yoba");
				System.out.println("connexion établie");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	public static Connection getCn() {
		return cn;
	}

}
