package model.projetos;

import java.util.ArrayList;

import model.autenticacao.Membro;

public class Grupo extends Composite{
	
	private long dataCriacao;
	private char[] linkCNPq;
	private ArrayList<Membro> membros = new ArrayList<>();
	private ArrayList<Composite> projetos = new ArrayList<>();
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
		for(Composite c:projetos){
			custoTotal += c.getCustoTotal();
		}
		return custoTotal;
	}
	@Override
	public float getCusteioReaisNaoGastoTotal() {
		float custeioNaoGasto = 0;
		for(Composite c:projetos){
			custeioNaoGasto+=c.getCusteioReaisNaoGastoTotal();
		}
		return custeioNaoGasto;
	}
	@Override
	public float getCapitalReaisNaoGastoTotal() {
		float capitalNaoGasto = 0;
		for(Composite c:projetos){
			capitalNaoGasto+=c.getCapitalReaisNaoGastoTotal();
		}
		return capitalNaoGasto;
	}
	@Override
	public void adicionar(Composite composite) {
		projetos.add(composite);
	}
	@Override
	public void remover(Composite composite) {
		projetos.remove(composite);
	}
	@Override
	public void adicionar(Membro membro) {
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

}
