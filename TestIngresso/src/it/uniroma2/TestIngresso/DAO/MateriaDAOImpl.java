package it.uniroma2.TestIngresso.DAO;

import it.uniroma2.TestIngresso.Model.Materia;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

/**
 * Classe che implementa le funzionalità DAO per l'oggetto Materia
 * @author roberto
 * @version 26-10-14
 */
public class MateriaDAOImpl implements MateriaDAO{
	private String sql;
	
	/**
	 * Seleziona tutte le materie presenti nel DB
	 * @return Lista di oggetti Materia
	 */
	public List<Materia> selectAll() {
		List<Materia> materie = new ArrayList<Materia>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "SELECT * FROM materia";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Materia m = new Materia();
				m.setId(rs.getInt("idMateria"));
				m.setNome(rs.getString("nome"));
				materie.add(m);
			}
			return materie;
		}
		catch(Exception e){
	    	  System.out.println(e);
	    	  return null;
		}
		finally{
			if(DAO.conn != null){
				try{
					DAO.conn.close();
				}
				catch(Exception e){
				}
			}
		}
	}
	
	/**
	 * Seleziona un id materia per restituirne il nome
	 * @return nome della materia
	 */
	public String selectById(int id) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "SELECT * FROM materia WHERE (idMateria = ?)";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString("nome");
		}
		catch(Exception e){
	    	  System.out.println(e);
	    	  return null;
		}
		finally{
			if(DAO.conn != null){
				try{
					DAO.conn.close();
				}
				catch(Exception e){
				}
			}
		}
	}
	
	/**
	 * Seleziona l'id di una materia in base al nome
	 * @return idMateria corrispondente. -1 in caso di errore
	 */
	public int selectByNome(String nome) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "SELECT * FROM materia WHERE (nome = ?)";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt("idMateria");
		}
		catch(Exception e){
	    	  System.out.println(e);
	    	  return -1;
		}
		finally{
			if(DAO.conn != null){
				try{
					DAO.conn.close();
				}
				catch(Exception e){
				}
			}
		}
	}
	
	/**
	 * Modifica un oggetto materia nel DB in base all'id della materia
	 * @return true nel caso va a buon fine
	 */
	public boolean update(Materia m){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "UPDATE materia SET nome = ? WHERE (idMateria = ?)";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ps.setString(1, m.getNome());
			ps.setInt(2, m.getId());
			ps.executeUpdate();
			return true;
		}
		catch(Exception e){
	    	  System.out.println(e);
	    	  return false;
		}
		finally{
			if(DAO.conn != null){
				try{
					DAO.conn.close();
				}
				catch(Exception e){
				}
			}
		}
	}
}
