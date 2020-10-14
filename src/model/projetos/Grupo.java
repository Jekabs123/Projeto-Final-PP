package model.projetos;

import java.util.ArrayList;

import exception.ExceptionMembroDuplicado;
import model.autenticacao.Membro;
/**
 * 
 * @author PAULO E INATHAN - TATAKAE!
 * Essa classe Grupo do projeto
 */
public class Grupo extends InterfaceComum{
	/**
	 * {@link #dataCriacao} Esse atributo armazena a data de criação do grupo
	 * {@link #linkCNPq} Esse atributo armazena o link do CNPq do grupo
	 * {@link #membros} Esse atributo armazena a lista de membros do grupo
	 */
	private long dataCriacao;
	private char[] linkCNPq;
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
		for(InterfaceComum c:getInterfaces()){
			custoTotal += c.getCustoTotal();
		}
		return custoTotal;
	}
	@Override
	public float getCusteioReaisNaoGastoTotal() {
		float custeioNaoGasto = 0;
		for(InterfaceComum c:getInterfaces()){
			custeioNaoGasto+=c.getCusteioReaisNaoGastoTotal();
		}
		return custeioNaoGasto;
	}
	@Override
	public float getCapitalReaisNaoGastoTotal() {
		float capitalNaoGasto = 0;
		for(InterfaceComum c:getInterfaces()){
			capitalNaoGasto+=c.getCapitalReaisNaoGastoTotal();
		}
		return capitalNaoGasto;
	}
	@Override
	public void adicionar(InterfaceComum composite) {
		getInterfaces().add(composite);
	}
	@Override
	public void remover(InterfaceComum composite) {
		getInterfaces().remove(composite);
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
}
