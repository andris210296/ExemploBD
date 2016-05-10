package iniciar;

import controller.AlteracaoCtrl;
import model.AlteracaoModel;
import view.AltercaoView;
import view.ExibirAlteracao;

public class Iniciar {
	
	public static void main(String[] args) {
		AlteracaoModel alteracaoModel = new AlteracaoModel();
		AlteracaoCtrl alteracaoCtrl = new AlteracaoCtrl(alteracaoModel);
		AltercaoView altercaoView = new AltercaoView(alteracaoCtrl);
		
		altercaoView.setLocation(5,5);
		
		ExibirAlteracao exibirV = new ExibirAlteracao();
		exibirV.setLocation(120,5);
		
		alteracaoModel.addObserver(exibirV);
		
		
		// Primeiras ações assim que tudo estiver criado
		alteracaoModel.atualizarListaInformacoes();
		
		
		altercaoView.setVisible(true);
		exibirV.setVisible(true);
		
		
		
		
		
		
	}

}
