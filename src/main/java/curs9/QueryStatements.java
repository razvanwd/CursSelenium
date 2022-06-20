package curs9;

public enum QueryStatements {
	
	SELECT("select * from customers;"),
	UPDATE_CUSTOMER("update customers set CustomerName ='Nimic' where CustomerName = 'Ionut';");
	private String query;
	
	QueryStatements(String string) {
		this.query = string;
	}
	public String getQuery() {
		return query;
	}

}
