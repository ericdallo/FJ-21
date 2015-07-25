package br.com.caelum.jdbc.exception;

import java.sql.SQLException;

public class DAOException extends RuntimeException{

	public DAOException(SQLException e) {
		e.printStackTrace();
	}
	
}
