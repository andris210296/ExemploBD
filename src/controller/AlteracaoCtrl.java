package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.AlteracaoModel;


public class AlteracaoCtrl implements ActionListener{

	private AlteracaoModel alteracaoModel;

	private JLabel lblVazio = new JLabel("");	
	private JLabel lblString = new JLabel("String:");
	private JTextField txtString = new JTextField();

	private JLabel lblInt = new JLabel("Int:");
	private JTextField txtInt = new JTextField();

	private JLabel lblDate = new JLabel("Date:");
	private JTextField txtDate = new JTextField();

	private JLabel lblDouble = new JLabel("Double:");
	private JTextField txtDouble = new JTextField();

	private JButton btnDeletar = new JButton("Deletar tudo");
	private JButton btnCadastrar = new JButton("Cadastrar");


	public AlteracaoCtrl(AlteracaoModel alteracaoModel) {		
		this.alteracaoModel = alteracaoModel;
		btnCadastrar.addActionListener(this);
		btnDeletar.addActionListener(this);

	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCadastrar){

			try{
				alteracaoModel.cadastrar(alteracaoModel.setInfo(getTxtString().getText(), getTxtInt().getText(), getTxtDate().getText(), getTxtDouble().getText()));

			}catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Algum campo foi digitado incorretamente","Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == btnDeletar){
			try{

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Excluir tudo", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					alteracaoModel.deletear();
				} 								
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null,"Algum erro ocorreu!","Erro", JOptionPane.ERROR_MESSAGE);

			}
		}
	}


	public AlteracaoModel getAlteracaoModel() {
		return alteracaoModel;
	}

	public void setAlteracaoModel(AlteracaoModel alteracaoModel) {
		this.alteracaoModel = alteracaoModel;
	}

	public JLabel getLblVazio() {
		return lblVazio;
	}

	public void setLblVazio(JLabel lblVazio) {
		this.lblVazio = lblVazio;
	}

	public JLabel getLblString() {
		return lblString;
	}


	public void setLblString(JLabel lblString) {
		this.lblString = lblString;
	}


	public JTextField getTxtString() {
		return txtString;
	}


	public void setTxtString(JTextField txtString) {
		this.txtString = txtString;
	}


	public JLabel getLblInt() {
		return lblInt;
	}


	public void setLblInt(JLabel lblInt) {
		this.lblInt = lblInt;
	}


	public JTextField getTxtInt() {
		return txtInt;
	}


	public void setTxtInt(JTextField txtInt) {
		this.txtInt = txtInt;
	}


	public JLabel getLblDate() {
		return lblDate;
	}


	public void setLblDate(JLabel lblDate) {
		this.lblDate = lblDate;
	}


	public JTextField getTxtDate() {
		return txtDate;
	}


	public void setTxtDate(JTextField txtDate) {
		this.txtDate = txtDate;
	}


	public JLabel getLblDouble() {
		return lblDouble;
	}


	public void setLblDouble(JLabel lblDouble) {
		this.lblDouble = lblDouble;
	}


	public JTextField getTxtDouble() {
		return txtDouble;
	}


	public void setTxtDouble(JTextField txtDouble) {
		this.txtDouble = txtDouble;
	}


	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}


	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}


	public JButton getBtnDeletar() {
		return btnDeletar;
	}


	public void setBtnDeletar(JButton btnDeletar) {
		this.btnDeletar = btnDeletar;
	}


}
