package model.bd;

import java.sql.SQLException;
import java.util.List;

import model.Informacao;

public interface InformacaoDAO {
	
	public void inserir(Informacao info)throws SQLException;	
	public void deletar() throws SQLException;
	public void alterar(Informacao info)throws SQLException;
	public List listar()throws SQLException;
	
	
	

}
