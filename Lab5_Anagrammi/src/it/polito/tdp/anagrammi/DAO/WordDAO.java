package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WordDAO {

	public boolean isCorrect(String word) {
		
		final String sql = "SELECT * "+
							"FROM parola "+
							"WHERE nome=?";
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			st.setString(1, word);
			ResultSet rs = st.executeQuery();

			if(rs.next()) 
				return true;
		return false;
	
		}catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
}
