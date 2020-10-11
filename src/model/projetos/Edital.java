package model.projetos;

import java.util.ArrayList;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa é a classe Edital do projeto
 */
public class Edital extends InterfaceComum{
	/**
	 * {@link #projetos} Esse atributo é a lista de de interfaceComum que pode adicionar projetos ou qualquer tipo comum
	 * {@link #grupos} Esse atributo é uma lista de interfaceComum que pode adicionar grupos ou qualquer tipo comum
	 */
	private ArrayList<InterfaceComum> projetos = new ArrayList<>();
	private ArrayList<InterfaceComum> grupos = new ArrayList<>();
	
	/**
	 * Esse método adiciona projetos na lista de interfaceComum
	 * @param composite: é o projeto qe vai ser adicionado
	 */
	public void adicionar(Projeto composite) {
		projetos.add(composite);
	}
	/**
	 * Esse método adiciona grupos na lista de interfaceComum
	 * @param composite: é o grupo que vai ser adicionado
	 */
	public void adicionar(Grupo composite){
		grupos.add(composite);
	}
	/**
	 * Esse método seta o atributo ativo como true
	 */
	public void ativar() {
		setAtivo(true);
		
	}
	/**
	 * Esse método seta o atributo ativo como false
	 */
	public void desativar() {
		setAtivo(false);
	}
	/**
	 * Esse método calcula o valor total do custo
	 *@return: retorna o valor total em float do custo 
	 */
	public float getCustoTotal() {
		float custoTotal = 0;
		for(InterfaceComum p: projetos){
			custoTotal+= p.getCustoTotal();
		}
		for(InterfaceComum g: grupos){
			custoTotal+= g.getCustoTotal();
		}
		return custoTotal;
	}

	/**
	 * Esse método cacula o custeio total não gasto
	 * @return: retorna o custeio não gasto total em float
	 */
	public float getCusteioReaisNaoGastoTotal() {
		float custeio = 0;
		for(InterfaceComum c: projetos){
			custeio+= c.getCusteioReaisNaoGastoTotal();
		}
		return custeio;
	}

	/**
	 * Esse método calcula o capital total não gasto
	 * @return: retorna o capital total não gasto em float
	 */
	public float getCapitalReaisNaoGastoTotal() {
		float capital = 0;
		for(InterfaceComum c: projetos){
			capital+=c.getCapitalReaisNaoGastoTotal();
		}
		return capital;
	}
	/**
	 * Esse método pega a lista de projetos
	 * @return: retorna a lista de interfaceComum
	 */
	public ArrayList<InterfaceComum> getProjetos() {
		return projetos;
	}
	/**
	 * Esse método seta uma lista de projetos
	 * @param projetos: é a lista de projetos que vai ser configurada
	 */
	public void setProjetos(ArrayList<InterfaceComum> projetos) {
		this.projetos = projetos;
	}
	/**
	 * Esse método pega uma lista de grupos
	 * @return: retorna uma lista de interfaceComum
	 */
	public ArrayList<InterfaceComum> getGrupos() {
		return grupos;
	}
	/**
	 * Esse método seta uma lista de grupos
	 * @param grupos: é a lista de grupos que vai ser configurada
	 */
	public void setGrupos(ArrayList<InterfaceComum> grupos) {
		this.grupos = grupos;
	}
}
