package model.projetos;

import java.util.ArrayList;

import exception.ExceptionMembroDuplicado;
import model.autenticacao.Membro;
/**
 * 
 * @author PAULO E INATHAN - TATAKAE!
 * Essa classe Grupo do projeto
 */
public class Grupo extends CompositorProjeto{
	/**
	 * {@link #dataCriacao} Esse atributo armazena a data de criação do grupo
	 * {@link #linkCNPq} Esse atributo armazena o link do CNPq do grupo
	 * {@link #membros} Esse atributo armazena a lista de membros do grupo
	 */
	private long dataCriacao;
	private String linkCNPq;
	private ArrayList<Membro> membros = new ArrayList<>();
	
	@Override
	public void ativar() {
		setAtivo(true);
		
	}
	@Override
	public void desativar() {
		setAtivo(false);
		
	}
	@Override
	public float getCustoTotal() {
		float custoTotal = 0;
		for(CompositorProjeto c : getCompositorProjeto()){
			custoTotal += c.getCustoTotal();
		}
		return custoTotal;
	}
	@Override
	public float getCusteioReaisNaoGastoTotal() {
		float custeioNaoGasto = 0;
		for(CompositorProjeto c : getCompositorProjeto()){
			custeioNaoGasto+=c.getCusteioReaisNaoGastoTotal();
		}
		return custeioNaoGasto;
	}
	@Override
	public float getCapitalReaisNaoGastoTotal() {
		float capitalNaoGasto = 0;
		for(CompositorProjeto c : getCompositorProjeto()){
			capitalNaoGasto+=c.getCapitalReaisNaoGastoTotal();
		}
		return capitalNaoGasto;
	}
	@Override
	public void adicionar(CompositorProjeto compositorProjeto) {
		if(compositorProjeto instanceof Projeto){
			super.adicionar(compositorProjeto);
		}
	}
	@Override
	public void remover(CompositorProjeto compositorProjeto) {
		getCompositorProjeto().remove(compositorProjeto);
	}

	public void adicionarMembro(Membro membro) throws ExceptionMembroDuplicado {
		for(Membro m: membros){
			if(m.getMatricula()==membro.getMatricula()){
				 throw new ExceptionMembroDuplicado("Alguem membro possui essa matricula");
			}
		}
		membros.add(membro);
	}
	public void removerMembro(Membro membro) {
		membro.getParticipacao().desativar();
		membros.remove(membro);
	}
	public long getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(long dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getLinkCNPq() {
		return linkCNPq;
	}
	public void setLinkCNPq(String linkCNPq) {
		this.linkCNPq = linkCNPq;
	}
	public ArrayList<Membro> getMembros() {
		return membros;
	}
	public void setMembros(ArrayList<Membro> membros) {
		this.membros = membros;
	}
	public ArrayList<Projeto> getGrupos(){
		ArrayList<Projeto> projetos = new ArrayList<>();
		for(CompositorProjeto com: getCompositorProjeto()){
			projetos.add((Projeto)com);
		}
		return projetos; 
	}
	public Membro pesquisarMembroPorLoginESenha(String login, String senha){
		for(Membro membro: membros){
			if(membro.getLogin().equals(login)&&membro.getSenha().equals(senha)){
				return membro;
			}
		}
		return null;
	}
}
