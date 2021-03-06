package model.projetos;

import exception.ExceptionMembroDuplicado;
import model.autenticacao.Membro;

public class FachadaCompositeEditalGrupo {
	
	private CompositorProjeto edital = new Edital();
	private Grupo grupo = new Grupo();
	private Projeto projeto = new Projeto();
	private CompositorProjeto participacao = new Participacao();
	
	//M�todos de Edital
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
	
	//M�todos de Grupo
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
			grupo.adicionarMembro(membro);
		} catch (ExceptionMembroDuplicado e) {
			e.printStackTrace();
		}
	}
	
	public void removerMembroDeGrupo(Membro membro) {
		grupo.removerMembro(membro);
	}
	
	public void mostrarBalancamentoFinanceiroGrupo() {
		grupo.getCustoTotal();
		grupo.getCusteioReaisNaoGastoTotal();
		grupo.getCapitalReaisNaoGastoTotal();
	}

	
	//M�todos de projeto
	public void ativarProjeto() {
		projeto.ativar();
	}
	
	public void desativarProjeto() {
		projeto.desativar();
	}
	
	public void adicionarMembroParaProjeto(Membro membro) {
		try {
			projeto.adicionarMembro(membro);
		} catch (ExceptionMembroDuplicado e) {
			e.printStackTrace();
		}
	}
	
	public void removerMembroParaProjeto(Membro membro) {
		projeto.removerMembro(membro);
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
	
	//M�todos de Participa��o
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
