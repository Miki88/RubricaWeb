package rubricaweb.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rubricaweb.classi.Persona;

public class DBUtils {

	  public static List<Persona> queryPersona(Connection conn) throws SQLException {
		  
	      String sql = "Select p.id, p.nome, p.cognome, p.indirizzo, p.telefono, p.eta from Persona p ";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      ResultSet rs = pstm.executeQuery();
	      List<Persona> list = new ArrayList<Persona>();
	      while (rs.next()) {
	    	  int id = rs.getInt("id");
	          String nome = rs.getString("nome");
	          String cognome = rs.getString("cognome");
	          String indirizzo = rs.getString("indirizzo");
	          String telefono = rs.getString("telefono");
	          int eta = rs.getInt("eta");
	          Persona pers = new Persona(id, nome, cognome, indirizzo, telefono, eta);
	          System.out.println(pers.getDatiPersona());
	          list.add(pers);
	      }
	      return list;
	  }
	 
	  public static Persona trovaPersona(Connection conn, String CodId) throws SQLException {
	      String sql = "Select p.id, p.nome, p.cognome, p.indirizzo, p.telefono, p.eta from persona p where p.id=?";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	      pstm.setString(1, CodId);
	 
	      ResultSet rs = pstm.executeQuery();
	 
	      while (rs.next()) {
	    	  int id = rs.getInt("id");
	          String nome = rs.getString("nome");
	          String cognome = rs.getString("cognome");
	          String indirizzo = rs.getString("indirizzo");
	          String telefono = rs.getString("telefono");
	          int eta = rs.getInt("eta");
	          Persona pers = new Persona(id, nome, cognome, indirizzo, telefono, eta);
	          return pers;
	      }
	      return null;
	  }
	 
	  
	  
	  public static void modificaPersona(Connection conn, Persona p) throws SQLException { //, String codId
	      String sql = "Update persona set nome =?, cognome =?, indirizzo =?, telefono =?, eta=? where id=? ";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      pstm.setString(1, p.getNome());
	      pstm.setString(2, p.getCognome());
	      pstm.setString(3, p.getIndirizzo());
	      pstm.setString(4, p.getTelefono());
	      pstm.setInt(5, p.getEta());
	      pstm.setInt(6, p.getId()); //codId
	      System.out.println("id da modificare "+p.getId());
	      pstm.executeUpdate();
	  }
	 
	  
	  public static void inserisciPersona(Connection conn, Persona p) throws SQLException {
	      String sql = "Insert into persona(nome, cognome, indirizzo, telefono, eta) values (?,?,?,?,?)";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      pstm.setString(1, p.getNome());
	      pstm.setString(2, p.getCognome());
	      pstm.setString(3, p.getIndirizzo());
	      pstm.setString(4, p.getTelefono());
	      pstm.setInt(5, p.getEta());
	 
	      pstm.executeUpdate();
	  }
	 
	  
	  public static void cancellaPersona(Connection conn, String codId) throws SQLException {
	      String sql = "Delete from persona where id= ?";
	 
	      PreparedStatement pstm = conn.prepareStatement(sql);
	 
	      pstm.setString(1, codId);
	 
	      pstm.executeUpdate();
	  }
	 
	
}
