package view.autenticacao.swing;

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
import view.projetos.swing.TelaJustificativaPontoSwing;
import view.projetos.swing.TelaPontoSwing;
import view.projetos.swing.TelaPrincipalSwing;
import view.projetos.swing.edital.TelaAdicionarEdital;
import view.projetos.swing.edital.TelaAtualizarEdital;
import view.projetos.swing.edital.TelaCadastrarEditaisSwing;
import view.projetos.swing.edital.TelaMostrarEditais;
import view.projetos.swing.edital.TelaRemoverEdital;
import view.projetos.swing.grupo.TelaAdicionarGrupo;
import view.projetos.swing.grupo.TelaAtualizarGrupo;
import view.projetos.swing.grupo.TelaCadastroGruposSwing;
import view.projetos.swing.grupo.TelaMostrarGrupos;
import view.projetos.swing.grupo.TelaRemoverGrupo;
import view.projetos.swing.projeto.TelaAdicionarProjeto;
import view.projetos.swing.projeto.TelaAtualizarProjeto;
import view.projetos.swing.projeto.TelaCadastrarProjetosSwing;
import view.projetos.swing.projeto.TelaMostrarProjetos;
import view.projetos.swing.projeto.TelaRemoverProjeto;

public class FabricaTelaSwing implements FabricaTela {

	@Override
	public TelaAutenticacao fabricarTelaAutenticacao() {
		return new TelaAutenticacaoSwing();
	}

	@Override
	public TelaCriarConta fabricarTelaCriarConta() {
		return new TelaCriarContaSwing();
	}

	@Override
	public TelaConfiguracaoAdmin fabricarTelaConfiguracaoAdmin() {
		return new TelaConfiguracaoAdminSwing();
	}

	@Override
	public TelaJustificativaPonto fabricarTelaJustificativaPonto() {
		return new TelaJustificativaPontoSwing();
	}

	@Override
	public TelaCadastroEditais fabricarTelaCadastrarEditais() {
		return new TelaCadastrarEditaisSwing();
	}

	@Override
	public TelaCadastroGrupos fabricarTelaCadastroGrupos() {
		return new TelaCadastroGruposSwing();
	}

	@Override
	public TelaCadastroProjetos fabricarTelaCadastroProjetos() {
		return new TelaCadastrarProjetosSwing();
	}

	@Override
	public TelaPonto fabricarTelaPonto() {
		return new TelaPontoSwing();
	}

	@Override
	public TelaPrincipal fabricarTelaPrincipal() {
		return new TelaPrincipalSwing();
	}
	
	//MÉTODOS ÚNICOS DE SWING
	
	public TelaAdicionarEdital fabricarTelaAdicionarEdital() {
		return new TelaAdicionarEdital();
	}
	
	public TelaAtualizarEdital fabricarTelaAtualizarEdital() {
		return new TelaAtualizarEdital();
	}
	
	public TelaMostrarEditais fabricarTelaMostrarEditais() {
		return new TelaMostrarEditais();
	}
	
	public TelaRemoverEdital fabricarTelaRemoverEdital() {
		return new TelaRemoverEdital();
	}
	
	public TelaAdicionarGrupo fabricarTelaAdicionarGrupo() {
		return new TelaAdicionarGrupo();
	}
	
	public TelaAtualizarGrupo fabricarTelaAtualizarGrupo() {
		return new TelaAtualizarGrupo();
	}
	
	public TelaMostrarGrupos fabricarTelaMostrarGrupos() {
		return new TelaMostrarGrupos();
	}
	
	public TelaRemoverGrupo fabricarTelaRemoverGrupo() {
		return new TelaRemoverGrupo();
	}
	
	public TelaAdicionarProjeto fabricarTelaAdicionarProjeto() {
		return new TelaAdicionarProjeto();
	}
	
	public TelaAtualizarProjeto fabricarTelaAtualizarProjeto() {
		return new TelaAtualizarProjeto();
	}
	
	public TelaMostrarProjetos fabricarTelaMostrarProjetos() {
		return new TelaMostrarProjetos();
	}
	
	public TelaRemoverProjeto fabricarTelaRemoverProjeto() {
		return new TelaRemoverProjeto();
	}
	

}
