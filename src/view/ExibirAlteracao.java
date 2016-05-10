package view;

import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import model.AlteracaoModel;
import model.Informacao;

import javax.swing.*;

public class ExibirAlteracao extends JComponent implements Observer{	
	private List<JLabel> labels = new ArrayList<JLabel>();
	private List<Integer> id =  new ArrayList<>();
	private List<Informacao> informacoes = new ArrayList<Informacao>();
	
	JFrame janela = new JFrame("Informações Cadastradas");
	JLabel lblInformacoes = new JLabel();
	
	public ExibirAlteracao(){		
		this.janela.setLayout(new GridLayout(0,1));
		this.janela.add(new JLabel("Informações"));
		this.janela.add(new JLabel());		
		this.janela.setVisible(true);		
		this.janela.setDefaultCloseOperation(3);
		this.janela.pack();
		
	}
	
	public void novoLabel(Informacao informacao){				
			String sId = "ID: "+ informacao.getId()+" - ";
			String sString = "String: "+informacao.getStringInfo()+" - ";
			String sInt = "Int: "+informacao.getIntInfo()+" - ";
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = informacao.getDateInfo();
			String sDate = "Date: "+dateFormat.format(date)+" - ";
			
			String sDouble = "Double: "+ informacao.getDoubleInfo();
			
			String linha = sId + sString +sInt + sDate +sDouble;
			JLabel label = new JLabel(linha);
			labels.add(label);			
					
			for(int i = 0;i < labels.size();i++){
				this.janela.add(labels.get(i));
			}		
	}	
	
	@Override
	public void update(Observable o, Object arg) {				
		AlteracaoModel alteracaoM = (AlteracaoModel) o;
		informacoes = alteracaoM.getInformacoes();	
		
		if(informacoes.size()==0){			
			for (JLabel label : labels) {
				this.janela.getContentPane().remove(label);				
				this.janela.getContentPane().revalidate();				
			}	
			labels.clear();
			id.clear();
		}		
		for (Informacao informacao : informacoes) {
			if(!id.contains(informacao.getId())){
				novoLabel(informacao);
				this.janela.getContentPane().revalidate();
				id.add(informacao.getId());
			}		
		}					
	}
}
