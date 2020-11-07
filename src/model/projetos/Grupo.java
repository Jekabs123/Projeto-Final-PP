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
	private char[] linkCNPq;
	private ArrayList<Membro> membros = new ArrayList<>();
	private ArrayList<Grupo> grupos = new ArrayList<>();
	
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
		for(CompositorProjeto c : grupos){
			custoTotal += c.getCustoTotal();
		}
		return custoTotal;
	}
	@Override
	public float getCusteioReaisNaoGastoTotal() {
		float custeioNaoGasto = 0;
		for(CompositorProjeto c : grupos){
			custeioNaoGasto+=c.getCusteioReaisNaoGastoTotal();
		}
		return custeioNaoGasto;
	}
	@Override
	public float getCapitalReaisNaoGastoTotal() {
		float capitalNaoGasto = 0;
		for(CompositorProjeto c : grupos){
			capitalNaoGasto+=c.getCapitalReaisNaoGastoTotal();
		}
		return capitalNaoGasto;
	}
	@Override
	public void adicionar(CompositorProjeto compositorProjeto) {
		grupos.add((Grupo) compositorProjeto);
	}
	@Override
	public void remover(CompositorProjeto compositorProjeto) {
		grupos.remove(compositorProjeto);
	}

	@Override
	public void adicionar(Membro membro) throws ExceptionMembroDuplicado {
		for(Membro m: membros){
			if(m.getMatricula()==membro.getMatricula()){
				 throw new ExceptionMembroDuplicado("Alguem membro possui essa matricula");
			}
		}
		membros.add(membro);
	}
	@Override
	public void remover(Membro membro) {
		membros.add(membro);
	}
	public long getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(long dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public char[] getLinkCNPq() {
		return linkCNPq;
	}
	public void setLinkCNPq(char[] linkCNPq) {
		this.linkCNPq = linkCNPq;
	}
	public ArrayList<Membro> getMembros() {
		return membros;
	}
	public void setMembros(ArrayList<Membro> membros) {
		this.membros = membros;
	}
	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(Grupo grupo) {
		for (int i = 0; i < grupos.size(); i++) {
			this.grupos.set(i, grupo);
		}
	}
	
}
