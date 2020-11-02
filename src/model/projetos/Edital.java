package model.projetos;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa é a classe Edital do projeto
 */
public class Edital extends InterfaceComum{


	public void adicionar(InterfaceComum composite) {
		getInterfaces().add(composite);
	}

	public void remover(InterfaceComum composite) {
		getInterfaces().remove(composite);
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
		for(InterfaceComum p: getInterfaces()){
			custoTotal+= p.getCustoTotal();
		}
		return custoTotal;
	}

	/**
	 * Esse método cacula o custeio total não gasto
	 * @return: retorna o custeio não gasto total em float
	 */
	public float getCusteioReaisNaoGastoTotal() {
		float custeio = 0;
		for(InterfaceComum c: getInterfaces()){
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
		for(InterfaceComum c: getInterfaces()){
			capital+=c.getCapitalReaisNaoGastoTotal();
		}
		return capital;
	}
}
