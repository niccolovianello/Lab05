package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AnagrammaDAO {
	
	public List<String> getParole() {

		final String sql = "SELECT * FROM dizionario";

		List<String> parole = new LinkedList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				parole.add(rs.getString("nome"));
			}

			return parole;

		} catch (SQLException e) {
			throw new RuntimeException("Errore DB");
		}
	}
	
	public boolean isCorrect(String anagramma) {
		
		final String sql = "SELECT * FROM dizionario WHERE nome = ?";

		List<String> parole = new LinkedList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				parole.add(rs.getString("nome"));
			}

			if(parole.size() != 0)
				return true;
			return false;

		} catch (SQLException e) {
			throw new RuntimeException("Errore DB");
		}
		
	}

}
