package model.projetos;

import exception.ExceptionMembroDuplicado;
import model.autenticacao.Membro;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa classe é a interface comum do para o pacote projetos
 */
public abstract class InterfaceComum {
	/**
	 * {@link #nome} Esse atributo é o nome da interface comum
	 * {@link #ativo} Esse atributo informa de está ativo ou não
	 * {@link #dataInicio} Esse atributo infroma a data que foi iniciada
	 * {@link #dataTermino} Esse atributo informa a data que vai ser terminada
	 */
	private String nome;
	private boolean ativo;
	private long dataInicio;
	private long dataTermino;
	
	/**
	 * Esse método seta o ativo como true
	 */
	public abstract void ativar();
	/**
	 * Esse método seta o ativo como false
	 */
	public abstract void desativar();
	/**
	 * Esse método  cacula o custo total
	 * @return: retorna o custo total em float
	 */
	public abstract float getCustoTotal();
	/**
	 * Esse método calcula o custeio total não gasto
	 * @return: retorna o custeio não gasto em float
	 */
	public abstract float getCusteioReaisNaoGastoTotal();
	/**
	 * Esse método calcula o capital total não gasto
	 * @return: retorna  o capital não gasto em float
	 */
	public abstract float getCapitalReaisNaoGastoTotal();
	/**
	 * Esse método adiciona um membro na interface comum
	 * @param membro: é o membro que vai ser adicionado
	 * @throws ExceptionMembroDuplicado: esse exceção é lançada quando esse membro já existir
	 */
	public void adicionar(Membro membro)throws ExceptionMembroDuplicado{
		
	}
	/**
	 * Esse método remove o membro da interface comum
	 * @param membro: é o membro que vai ser removido
	 */
	public void remover(Membro membro){
		
	}
	/**
	 * Esse método adiciona a interface comum
	 * @param composite: é a interface comum a ser adicionada
	 */
	public void adicionar(InterfaceComum composite){
		
	}
	/**
	 * Esse método remove a interface comum
	 * @param composite: é a interface comum a ser removida
	 */
	public void remover(InterfaceComum composite){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public long getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(long dataInicio) {
		this.dataInicio = dataInicio;
	}

	public long getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(long dataTermino) {
		this.dataTermino = dataTermino;
	}
	
}
