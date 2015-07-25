package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private final String HOST = "localhost";
	private final String USER = "root";
	private final String PASS = "akee1337";
	private final String DB = "fj21";
	
	public Connection getConnection() {
		String database_url = "jdbc:mysql://" + HOST + "/" + DB;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(database_url,USER,PASS);
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
