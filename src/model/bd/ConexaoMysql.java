package model.bd;

import java.sql.*;
public final class ConexaoMysql {
	// final impede herança

	public Connection conn;
	private Statement statement;
	public static ConexaoMysql db;
	
	private ConexaoMysql(){
		String url= "jdbc:mysql://localhost:3306/";
		String dbName = "informacoes";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "mysql";

		try{
			Class.forName(driver).newInstance();
			this.conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
		}catch(Exception sqle){
			sqle.printStackTrace();
		}  		

	}
	// synchronized evita concorrencia de threads
	// static impede que o método seja chamado
	public static synchronized ConexaoMysql getDbCon(){

		if(db == null){
			db = new ConexaoMysql();
		}
		return db;
	}	

	public PreparedStatement query(String query) throws SQLException{		
		return db.conn.prepareStatement(query);
	}   
		
	public void insert(PreparedStatement prepStmt) throws SQLException{
		prepStmt.executeUpdate();
	}
	
	public ResultSet select(PreparedStatement prepStmt, String sql) throws SQLException{
		ResultSet rs = prepStmt.executeQuery(sql );
		return rs;
	}


}
