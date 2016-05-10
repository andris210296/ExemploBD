package view;

import java.awt.GridLayout;

import javax.swing.*;

import controller.AlteracaoCtrl;

public class AltercaoView extends JComponent{
	
	private AlteracaoCtrl alteracaoCtrl;
	
	JFrame janela;
	
	public AltercaoView(AlteracaoCtrl alteracaoCtrl){
		this.alteracaoCtrl = alteracaoCtrl;
		
		this.janela = new JFrame("Nova Informacao");
		this.janela.getContentPane().add(this);
		this.janela.setLayout(new GridLayout(0,2));
		
		this.janela.add(alteracaoCtrl.getLblVazio());
		this.janela.add(alteracaoCtrl.getLblString()); this.janela.add(alteracaoCtrl.getTxtString());
		this.janela.add(alteracaoCtrl.getLblInt());this.janela.add(alteracaoCtrl.getTxtInt());
		this.janela.add(alteracaoCtrl.getLblDate());this.janela.add(alteracaoCtrl.getTxtDate());
		this.janela.add(alteracaoCtrl.getLblDouble());this.janela.add(alteracaoCtrl.getTxtDouble());
				
		this.janela.add(alteracaoCtrl.getBtnDeletar());
		this.janela.add(alteracaoCtrl.getBtnCadastrar());
		
		this.janela.setVisible(true);
		
		this.janela.setDefaultCloseOperation(3);
		this.janela.pack();		
		
		this.setFocusable(true);
		this.janela.setResizable(false);
		
	}
	

}
