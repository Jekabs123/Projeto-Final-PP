package view.autenticacao.swt;

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
import view.projetos.swt.TelaCadastroEditaisSWT;
import view.projetos.swt.TelaCadastroGruposSWT;
import view.projetos.swt.TelaCadastroProjetosSWT;
import view.projetos.swt.TelaJustificativaPontoSWT;
import view.projetos.swt.TelaPontoSWT;
import view.projetos.swt.TelaPrincipalSWT;

public class FabricaTelaSWT implements FabricaTela {

	@Override
	public TelaAutenticacao fabricarTelaAutenticacao() {
		return new TelaAutenticacaoSWT();
	}

	@Override
	public TelaCriarConta fabricarTelaCriarConta() {
		return new TelaCriarContaSWT();
	}

	@Override
	public TelaConfiguracaoAdmin fabricarTelaConfiguracaoAdmin() {
		return new TelaConfiguracaoAdminSWT();
	}

	@Override
	public TelaJustificativaPonto fabricarTelaJustificativaPonto() {
		return new TelaJustificativaPontoSWT();
	}

	@Override
	public TelaCadastroEditais fabricarTelaCadastrarEditais() {
		return new TelaCadastroEditaisSWT();
	}

	@Override
	public TelaCadastroGrupos fabricarTelaCadastroGrupos() {
		return new TelaCadastroGruposSWT();
	}

	@Override
	public TelaCadastroProjetos fabricarTelaCadastroProjetos() {
		return new TelaCadastroProjetosSWT();
	}

	@Override
	public TelaPonto fabricarTelaPonto() {
		return new TelaPontoSWT();
	}

	@Override
	public TelaPrincipal fabricarTelaPrincipal() {
		return new TelaPrincipalSWT();
	}

}
