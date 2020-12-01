package view.autenticacao.vaadin;

import view.autenticacao.FabricaTela;
import view.autenticacao.TelaAutenticacao;
import view.autenticacao.TelaConfiguracaoAdmin;
import view.autenticacao.TelaCriarConta;
import view.projetos.TelaCadastroEditais;
import view.projetos.TelaCadastroGrupos;
import view.projetos.TelaCadastroProjetos;
import view.projetos.TelaJustificativaPonto;
import view.projetos.TelaPonto;
import view.projetos.TelaPrincipal;
import view.projetos.vaadin.TelaCadastroEditaisVaadin;
import view.projetos.vaadin.TelaCadastroGruposVaadin;
import view.projetos.vaadin.TelaCadastroProjetosVaadin;
import view.projetos.vaadin.TelaJustificativaPontoVaadin;
import view.projetos.vaadin.TelaPontoVaadin;
import view.projetos.vaadin.TelaPrincipalVaadin;

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
	
	@Override
	public TelaJustificativaPonto fabricarTelaJustificativaPonto() {
		return new TelaJustificativaPontoVaadin();
	}

	@Override
	public TelaCadastroEditais fabricarTelaCadastrarEditais() {
		return new TelaCadastroEditaisVaadin();
	}

	@Override
	public TelaCadastroGrupos fabricarTelaCadastroGrupos() {
		return new TelaCadastroGruposVaadin();
	}

	@Override
	public TelaCadastroProjetos fabricarTelaCadastroProjetos() {
		return new TelaCadastroProjetosVaadin();
	}

	@Override
	public TelaPonto fabricarTelaPonto() {
		return new TelaPontoVaadin();
	}

	@Override
	public TelaPrincipal fabricarTelaPrincipal() {
		return new TelaPrincipalVaadin();
	}


}
