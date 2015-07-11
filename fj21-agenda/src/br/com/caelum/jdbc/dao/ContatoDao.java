package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.exception.DAOException;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "INSERT INTO contatos " +
					"(nome,email,endereco,dataNascimento) " +
				    "VALUES (?,?,?,?)";
		
		try(PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getEndereco());
			ps.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			//executa a query
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Contato> getLista() {
		List<Contato> contatos = new ArrayList<Contato>();
		String sql = "SELECT * FROM contatos";
		ResultSet rs;
		
		try(PreparedStatement ps = this.connection.prepareStatement(sql)) {
			rs = ps.executeQuery();
			
			while(rs.next()){
				Contato c = new Contato();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				c.setDataNascimento(data);
				contatos.add(c);
			}
			rs.close();
		} catch (SQLException e) {
			throw new DAOException();
		}
		
		return contatos;
	}
	
	public void altera(Contato contato) {
		String sql = "UPDATE contatos set nome=?,email=?,endereco=?,dataNascimento=? where id = ?";
				
		try(PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getEndereco());
			ps.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis() ));
			
			ps.setLong(5, contato.getId());
			ps.execute();
		} catch (SQLException e) {
			throw new DAOException();
		}
	}
	
	public void remove(Contato c) {
		String sql = "DELETE FROM contatos WHERE id=?";
		
		try (PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setLong(1, c.getId());
			ps.execute();
		} catch (SQLException e) {
			throw new DAOException();
		}
	}
	
}
