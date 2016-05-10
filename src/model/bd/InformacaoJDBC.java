package model.bd;

import java.sql.*;

import java.util.*;

import model.Informacao;

public class InformacaoJDBC implements InformacaoDAO{	
	ConexaoMysql conectar;
	
	public InformacaoJDBC() {
		conectar = ConexaoMysql.getDbCon();
	}

	@Override
	public void inserir(Informacao info) throws SQLException {		
		
		PreparedStatement prepStmt = conectar.query("insert into informacao values(0,?,?,?,?)");	

		prepStmt.setString(1,info.getStringInfo());
		prepStmt.setInt(2,info.getIntInfo());
		
		java.util.Date utilDate = info.getDateInfo();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());		
		prepStmt.setDate(3,sqlDate);
		
		prepStmt.setDouble(4,info.getDoubleInfo());				
		
		conectar.insert(prepStmt);		
			
	}
	@Override
	public List listar() throws SQLException {
		
		List<Informacao> informacoes = new ArrayList<>();
		
		String sql = "select * from informacao";
		PreparedStatement prepStmt = conectar.query(sql);
		
		ResultSet rs = conectar.select(prepStmt, sql);
		
		while (rs.next()){
			Informacao info = new Informacao();
			
			info.setId(rs.getInt("id"));
			info.setStringInfo(rs.getString("stringInfo"));
			info.setIntInfo(rs.getInt("intInfo"));
			
			java.sql.Date sqlDate = rs.getDate("dateInfo");			
			java.util.Date utilDate = new java.util.Date(sqlDate.getTime());    
			info.setDateInfo(utilDate);
			
			info.setDoubleInfo(rs.getDouble("doubleInfo"));
						
			informacoes.add(info);			
		}		
		return informacoes;
	}

	@Override
	public void deletar() throws SQLException {
		PreparedStatement prepStmt = conectar.query("delete from informacao");			
		conectar.insert(prepStmt);		
	}
	@Override
	public void alterar(Informacao info) throws SQLException {
		// TODO Auto-generated method stub		
	}

}
