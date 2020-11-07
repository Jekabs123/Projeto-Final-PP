package model.projetos;

import java.util.ArrayList;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa � a classe Edital do projeto
 */
public class Edital extends InterfaceComum {

	@Override
	public void adicionar(InterfaceComum composite) {
		getInterfaces().add(composite);
	}

	@Override
	public void remover(InterfaceComum composite) {
		getInterfaces().remove(composite);
	}
	/**
	 * Esse m�todo seta o atributo ativo como true
	 */
	@Override
	public void ativar() {
		setAtivo(true);
		
	}
	/**
	 * Esse m�todo seta o atributo ativo como false
	 */
	@Override
	public void desativar() {
		setAtivo(false);
	}
	/**
	 * Esse m�todo calcula o valor total do custo
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
	 * Esse m�todo cacula o custeio total n�o gasto
	 * @return: retorna o custeio n�o gasto total em float
	 */
	public float getCusteioReaisNaoGastoTotal() {
		float custeio = 0;
		for(InterfaceComum c: getInterfaces()){
			custeio+= c.getCusteioReaisNaoGastoTotal();
		}
		return custeio;
	}

	/**
	 * Esse m�todo calcula o capital total n�o gasto
	 * @return: retorna o capital total n�o gasto em float
	 */
	public float getCapitalReaisNaoGastoTotal() {
		float capital = 0;
		for(InterfaceComum c: getInterfaces()){
			capital+=c.getCapitalReaisNaoGastoTotal();
		}
		return capital;
	}
}
