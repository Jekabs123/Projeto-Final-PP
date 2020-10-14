package model.projetos;

import exception.ExceptionMembroDuplicado;
import model.autenticacao.Membro;

public class FachadaCompositeEditalGrupo {
	 // TODO - Fachada do composite
	
	private InterfaceComum edital = new Edital();
	private InterfaceComum grupo = new Grupo();
	private Projeto projeto = new Projeto();
	private InterfaceComum participacao = new Participacao();
	
	//Métodos de Edital
	public void ativarEdital() {
		edital.ativar();
	}
	
	public void desativarEdital() {
		edital.desativar();
	}
	
	public void adicionarProjetoParaEdital(Projeto projeto) {
		edital.adicionar(projeto);
	}
	
	public void removerProjetoDeEdital(Projeto projeto) {
		edital.remover(projeto);
	}
	
	public void adicionarGrupoParaEdital(Grupo grupo) {
		edital.remover(grupo);
	}
	
	public void removerGrupoDeEdital(Grupo grupo) {
		edital.remover(grupo);
	}
	
	public void mostrarBalancamentoFinanceiroEdital() {
		edital.getCustoTotal();
		edital.getCusteioReaisNaoGastoTotal();
		edital.getCapitalReaisNaoGastoTotal();
	}
	
	//Métodos de Grupo
	public void ativarGrupo() {
		grupo.ativar();
	}
	
	public void desativarGrupo() {
		grupo.desativar();
	}
	
	public void adicinarProjetoParaGrupo(Projeto projeto) {
		grupo.adicionar(projeto);
	}
	
	public void removerProjetoDeGrupo(Projeto projeto) {
		grupo.remover(projeto);
	}
	
	public void adicionarMembroParaGrupo(Membro membro) {
		try {
			grupo.adicionar(membro);
		} catch (ExceptionMembroDuplicado e) {
			e.printStackTrace();
		}
	}
	
	public void removerMembroDeGrupo(Membro membro) {
		grupo.remover(membro);
	}
	
	public void mostrarBalancamentoFinanceiroGrupo() {
		grupo.getCustoTotal();
		grupo.getCusteioReaisNaoGastoTotal();
		grupo.getCapitalReaisNaoGastoTotal();
	}

	
	//Métodos de grupo
	public void ativarProjeto() {
		projeto.ativar();
	}
	
	public void desativarProjeto() {
		projeto.desativar();
	}
	
	public void adicionarMembroParaProjeto(Membro membro) {
		try {
			projeto.adicionar(membro);
		} catch (ExceptionMembroDuplicado e) {
			e.printStackTrace();
		}
	}
	
	public void removerMembroParaProjeto(Membro membro) {
		projeto.remover(membro);
	}
	
	public void moverGrupoDeProjeto(Grupo grupo) {
		projeto.mover(grupo);
	}
	
	public void getCustoTotalProjeto() {
		projeto.getCustoTotal();
	}
	
	public void getCusteioReaisNaoGastoTotalProjeto() {
		projeto.getCusteioReaisNaoGastoTotal();
	}
	
	public void getCapitalReaisNaoGastoTotalProjeto() {
		projeto.getCapitalReaisNaoGastoTotal();
	}
	
	public void mostrarBalancamentoFinanceiroProjeto() {
		projeto.getCustoTotal();
		projeto.getCusteioReaisNaoGastoTotal();
		projeto.getCapitalReaisNaoGastoTotal();
	}
	
	//Métodos de Participação
	public void ativarParticipacao() {
		participacao.ativar();
	}
	
	public void desativarParticipacao() {
		participacao.desativar();
	}
	
	public void mostrarBalancamentoFinanceiroParticipacao() {
		participacao.getCustoTotal();
		participacao.getCusteioReaisNaoGastoTotal();
		participacao.getCapitalReaisNaoGastoTotal();
	}
	
}
