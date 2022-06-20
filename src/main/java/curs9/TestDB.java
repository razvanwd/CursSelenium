package curs9;

import java.sql.Connection;

public class TestDB {
	
	static String hostname = "jdbc:mysql://keytraining-demo.c050jeowbe1q.eu-central-1.rds.amazonaws.com:3306/KeyTraining";
	static String user = "demouser";
	static String password = "demouser";
	
	
	public static void main(String[] args) {
	
		Connection conn = DBConn.openDbConnection(hostname, user, password);
		
		System.out.println(DBquery.dbSelectQuery(conn, QueryStatements.SELECT.getQuery()));
		DBquery.dbUpdateQuery(conn, QueryStatements.UPDATE_CUSTOMER.getQuery());
		System.out.println(DBquery.dbSelectQuery(conn, QueryStatements.SELECT.getQuery()));
		
		DBConn.closeDBconnection(conn);
	}

}
