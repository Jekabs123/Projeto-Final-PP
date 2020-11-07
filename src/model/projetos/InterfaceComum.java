package model.projetos;

import java.util.ArrayList;

import exception.ExceptionMembroDuplicado;
import model.autenticacao.Membro;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa classe � a interface comum do para o pacote projetos
 */
/*
 * TODO
 * 1. outro nome que remeta a componentes de projetos.
 * 2. metodos de add() e remove() deveriam ser apenas com o supertipo e devem ter implementacoes
 * default. Os subtipos de component que suportarem eles devem sobrescrever e fazer testes para saber 
 * se vao adicionar em si ou nao.
 */
public abstract class InterfaceComum {
	/**
	 * {@link #nome} Esse atributo � o nome da interface comum
	 * {@link #ativo} Esse atributo informa de est� ativo ou n�o
	 * {@link #dataInicio} Esse atributo infroma a data que foi iniciada
	 * {@link #dataTermino} Esse atributo informa a data que vai ser terminada
	 * {@link #interfaces} � a lista que vai guardar os conteineres
	 */
	private String nome;
	private boolean ativo;
	private long dataInicio;
	private long dataTermino;
	
	/*
	 * TODO
	 * 1. porque aqui se quem deve possuir sao os tipos compostos?
	 */
	private ArrayList<InterfaceComum> interfaces = new ArrayList<>();
	
	/**
	 * Esse m�todo seta o ativo como true
	 */
	public abstract void ativar();
	/**
	 * Esse m�todo seta o ativo como false
	 */
	public abstract void desativar();
	/**
	 * Esse m�todo  cacula o custo total
	 * @return: retorna o custo total em float
	 */
	public abstract float getCustoTotal();
	/**
	 * Esse m�todo calcula o custeio total n�o gasto
	 * @return: retorna o custeio n�o gasto em float
	 */
	public abstract float getCusteioReaisNaoGastoTotal();
	/**
	 * Esse m�todo calcula o capital total n�o gasto
	 * @return: retorna  o capital n�o gasto em float
	 */
	public abstract float getCapitalReaisNaoGastoTotal();
	/**
	 * Esse m�todo adiciona um membro na interface comum
	 * @param membro: � o membro que vai ser adicionado
	 * @throws ExceptionMembroDuplicado: esse exce��o � lan�ada quando esse membro j� existir
	 */
	public void adicionar(Membro membro)throws ExceptionMembroDuplicado{
		
	}
	/**
	 * Esse m�todo remove o membro da interface comum
	 * @param membro: � o membro que vai ser removido
	 */
	public void remover(Membro membro){
		
	}
	/**
	 * Esse m�todo adiciona a interface comum
	 * @param composite: � a interface comum a ser adicionada
	 */
	public void adicionar(InterfaceComum composite){
		
	}
	/**
	 * Esse m�todo remove a interface comum
	 * @param composite: � a interface comum a ser removida
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
	
	/*
	 * TODO
	 * 1. todos suportam ter filhos?
	 * 2. nome deve remeter ao novo nome da classe ou getSubcomponentes(), algo assim...
	 */
	public ArrayList<InterfaceComum> getInterfaces() {
		return interfaces;
	}
	
	/*
	 * TODO
	 * 1. todos suportam ter filhos?
	 * 2. nome deve remeter ao novo nome da classe ou getSubcomponentes(), algo assim...
	 * 3. deveria adicionar um por um.
	 */
	public void setInterfaces(ArrayList<InterfaceComum> interfaces) {
		this.interfaces = interfaces;
	}
	
}
