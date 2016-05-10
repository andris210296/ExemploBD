package model;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import model.bd.ConexaoMysql;
import model.bd.InformacaoDAO;
import model.bd.InformacaoJDBC;

public class AlteracaoModel extends Observable{

	Informacao info;
	ConexaoMysql conectar;

	private List<Informacao> informacoes;
	private InformacaoDAO infoDAO;

	public AlteracaoModel( ){
		informacoes = new ArrayList<>();	
		infoDAO = new InformacaoJDBC();

	}
	public Informacao setInfo(String stringInfo, String intInfo,String dateInfo,String doubleInfo){

		Integer intInformacao = Integer.valueOf(intInfo);
		Date date = null;

		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = (java.util.Date)formatter.parse(dateInfo);

		} catch (ParseException e) {

			e.printStackTrace();
		}


		Double doubleInformacao = Double.valueOf(doubleInfo);

		info = new Informacao(stringInfo, intInformacao, date, doubleInformacao);
		return info;

	}
	public void cadastrar(Informacao info){

		try {						
			infoDAO.inserir(info);			
			atualizarListaInformacoes();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void deletear(){
		try{
			infoDAO.deletar();
			atualizarListaInformacoes();

		}catch(Exception ex){
			ex.printStackTrace();

		}
	}
	public void atualizarListaInformacoes(){				
		try {							

			List<Informacao> infor = infoDAO.listar();

			if(!infor.isEmpty()){
				for (Informacao informacao :  infor) {				
					informacoes.add(informacao);
				}
			}else informacoes.clear();

			adicionarInformacao(informacoes);			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}


	public void adicionarInformacao(List informacoes){		
		this.informacoes = informacoes;		
		setChanged();
		notifyObservers(informacoes);		

	}


	public List<Informacao> getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(List<Informacao> informacoes) {
		this.informacoes = informacoes;
	}



}
