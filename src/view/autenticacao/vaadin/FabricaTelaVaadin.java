package view.autenticacao.vaadin;

import view.autenticacao.FabricaTela;
import view.autenticacao.TelaAutenticacao;
import view.autenticacao.TelaConfiguracaoAdmin;
import view.autenticacao.TelaCriarConta;

public class FabricaTelaVaadin implements FabricaTela {

	@Override
	public TelaAutenticacao fabricarTelaAutenticacao() {
		return new TelaAutenticacaoVaadin();
	}

	@Override
	public TelaCriarConta fabricarTelaCriarConta() {
		return new TelaCriarContaVaadin();
	}

	@Override
	public TelaConfiguracaoAdmin fabricarTelaConfiguracaoAdmin() {
		return new TelaConfiguracaoAdminVaadin();
	}

}
