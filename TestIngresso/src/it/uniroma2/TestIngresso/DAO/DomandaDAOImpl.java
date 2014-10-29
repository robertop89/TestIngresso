package it.uniroma2.TestIngresso.DAO;
import it.uniroma2.TestIngresso.Model.Domanda;
import it.uniroma2.TestIngresso.Model.DomandaTest;
import it.uniroma2.TestIngresso.Model.Risposta;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;

/**
 * Claase di implementazione di DomandaDAO
 * @author roberto
 * @version 25-10-14
 */
public class DomandaDAOImpl implements DomandaDAO{
	/** Stringa addetta a contenere la query sql */
	private String sql;
	
	/**
	 * Seleziona tutte le domande contenute nel DB
	 * @return Lista di oggetti Domanda
	 */
	public List<Domanda> selectAll() {
		List<Domanda> domande = new ArrayList<Domanda>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "SELECT * FROM domanda";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Domanda d = new Domanda();
				d.setId(rs.getInt("idDomanda"));
				d.setMateria(rs.getInt("materia"));
				d.setTesto(rs.getString("testo"));
				d.setRisp1(rs.getString("risposta1"));
				d.setRisp2(rs.getString("risposta2"));
				d.setRisp3(rs.getString("risposta3"));
				d.setRisp4(rs.getString("risposta4"));
				d.setRisp5(rs.getString("risposta5"));
				d.setIndiceCorretta(rs.getByte("indiceCorretta"));
				d.setMotivazione(rs.getString("motivazione"));
				domande.add(d);
			}
			return domande;
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
	 * Seleziona tutte le domande di una singola materia presenti nel DB
	 * @return Lista di oggetti Domanda
	 */
	public List<Domanda> selectByMateria(int materia){
		List<Domanda> domande = new ArrayList<Domanda>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "SELECT * FROM domanda WHERE (materia = ?)";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ps.setInt(1, materia);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Domanda d = new Domanda();
				d.setId(rs.getInt("idDomanda"));
				d.setMateria(rs.getInt("materia"));
				d.setTesto(rs.getString("testo"));
				d.setRisp1(rs.getString("risposta1"));
				d.setRisp2(rs.getString("risposta2"));
				d.setRisp3(rs.getString("risposta3"));
				d.setRisp4(rs.getString("risposta4"));
				d.setRisp5(rs.getString("risposta5"));
				d.setIndiceCorretta(rs.getByte("indiceCorretta"));
				d.setMotivazione(rs.getString("motivazione"));
				domande.add(d);
			}
			return domande;
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
	 * Seleziona in modo casuale un numero "numero" di domande di una materia
	 * @return Lista di oggetti Domanda. -1 in caso di errore di connessione
	 */
	public List<DomandaTest> selectRandomByMateria(int materia, int numero){
		List<DomandaTest> domande = new ArrayList<DomandaTest>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "SELECT * FROM domanda WHERE (materia = ?) ORDER BY RAND() LIMIT 0,?";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ps.setInt(1, materia);
			ps.setInt(2, numero);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				DomandaTest d = new DomandaTest();
				d.setId(rs.getInt("idDomanda"));
				d.setTesto(rs.getString("testo"));
				d.setRisp1(rs.getString("risposta1"));
				d.setRisp2(rs.getString("risposta2"));
				d.setRisp3(rs.getString("risposta3"));
				d.setRisp4(rs.getString("risposta4"));
				d.setRisp5(rs.getString("risposta5"));
				domande.add(d);
			}
			return domande;
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
	
	public int countDomandeMateria(int materia){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "SELECT COUNT(*) FROM domanda WHERE (materia = ?)";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ps.setInt(1, materia);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt("COUNT(*)");
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
	 * Seleziona la domanda corrispondente ad un id.
	 * @return Oggetto Domanda
	 */
	public Domanda selectById(int id){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "SELECT * FROM domanda WHERE (idDomanda = ?)";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Domanda d = new Domanda();
			d.setId(rs.getInt("idDomanda"));
			d.setMateria(rs.getInt("materia"));
			d.setTesto(rs.getString("testo"));
			d.setRisp1(rs.getString("risposta1"));
			d.setRisp2(rs.getString("risposta2"));
			d.setRisp3(rs.getString("risposta3"));
			d.setRisp4(rs.getString("risposta4"));
			d.setRisp5(rs.getString("risposta5"));
			d.setIndiceCorretta(rs.getByte("indiceCorretta"));
			d.setMotivazione(rs.getString("motivazione"));
			return d;
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
	 * Metodo che riceve un idDomanda e restituisce la risposta corretta e la motivazione
	 * @return oggetto Risposte
	 */
	public Risposta selectRispById(int id){
		Risposta risp = new Risposta();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "SELECT indiceCorretta, motivazione FROM domanda WHERE (idDomanda = ?)";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			risp.setIdDomanda(id);
			risp.setIndiceCorretta(rs.getInt("indiceCorretta"));
			risp.setMotivazione(rs.getString("motivazione"));
			return risp;
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
	 * Inserisce un nuovo elemento Domanda nel DB
	 * @return true se va a buon fine
	 */
	public boolean insert(Domanda d){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "INSERT INTO domanda (materia,testo,risposta1,risposta2,risposta3,"
					+ "risposta4,risposta5,indiceCorretta,motivazione) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ps.setInt(1, d.getMateria());
			ps.setString(2, d.getTesto());
			ps.setString(3, d.getRisp1());
			ps.setString(4, d.getRisp2());
			ps.setString(5, d.getRisp3());
			ps.setString(6, d.getRisp4());
			ps.setString(7, d.getRisp5());
			ps.setInt(8, d.getIndiceCorretta());
			ps.setString(9, d.getMotivazione());
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
	
	/**
	 * Modifica un oggetto domanda di id = d.idDomanda
	 * @return true se va a buon fine
	 */
	public boolean update(Domanda d){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "UPDATE domanda SET materia = ?, testo = ?, risposta1 = ?, "
					+ "risposta2 = ?, risposta3 = ?, risposta4 = ?, risposta5 = ?, "
					+ "indiceCorretta = ?, motivazione = ? WHERE (idDomanda = ?)";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ps.setInt(1, d.getMateria());
			ps.setString(2, d.getTesto());
			ps.setString(3, d.getRisp1());
			ps.setString(4, d.getRisp2());
			ps.setString(5, d.getRisp3());
			ps.setString(6, d.getRisp4());
			ps.setString(7, d.getRisp5());
			ps.setInt(8, d.getIndiceCorretta());
			ps.setString(9, d.getMotivazione());
			ps.setInt(10, d.getId());
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
	
	/**
	 * elimina un oggetto Domanda dal DB con idDomanda = id
	 * @return true se va a buon fine
	 */
	public boolean delete(int id){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			DAO.conn = (Connection) DriverManager.getConnection(DAO.URL,DAO.DBuser,DAO.DBpassword);
			sql = "DELETE FROM domanda WHERE (idDomanda = ?)";
			PreparedStatement ps = DAO.conn.prepareStatement(sql);
			ps.setInt(1, id);
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

