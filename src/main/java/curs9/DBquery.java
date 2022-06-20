package curs9;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class DBquery {
	
	public static List<String> dbSelectQuery(Connection conn, String query) {
		
		List<String> resultList = new ArrayList<>();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				resultList.add(resultSet.getString(2));
			}
			
		} catch(SQLException e) {
			System.out.println("Nu am putut efectua Query!");
		}
		return resultList;
	}
	
	public static void dbUpdateQuery(Connection conn, String query) {
		try {
			
			Statement statement = conn.createStatement();
			statement.executeUpdate(query);
			System.out.println("Am facut Update");
			
		}catch(SQLException e) {
			System.out.println("nu am putut face update");
		}
		
	}
	
	public static void dbDeleteQuery(Connection conn, String query) {
		try {
			
			Statement statement = conn.createStatement();
			statement.executeUpdate(query);
			System.out.println("Am facut Delete");
			
		}catch(SQLException e) {
			System.out.println("nu am putut face Delete");
		}

}
	}
