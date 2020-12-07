package model.projetos;

import java.util.ArrayList;

/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa � a classe Edital do projeto
 */
public class Edital extends CompositorProjeto {
	

	@Override
	public void adicionar(CompositorProjeto compositorProjeto) {
		if(compositorProjeto instanceof Projeto || compositorProjeto instanceof Grupo){
			super.adicionar(compositorProjeto);
		}
	}

	@Override
	public void remover(CompositorProjeto compositorProjeto) {
		getCompositorProjeto().remove(compositorProjeto);
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
		for(CompositorProjeto p: getCompositorProjeto()){
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
		for(CompositorProjeto c: getCompositorProjeto()){
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
		for(CompositorProjeto c: getCompositorProjeto()){
			capital+=c.getCapitalReaisNaoGastoTotal();
		}
		return capital;
	}

	public ArrayList<Projeto> getProjetos() {
		ArrayList<Projeto> projetos = new ArrayList<>();
		for(CompositorProjeto com: getCompositorProjeto()){
			if(com instanceof Projeto){
				projetos.add((Projeto) com);
			}
		}
		return projetos;
	}
	public ArrayList<Grupo> getGrupos(){
		ArrayList<Grupo> grupos = new ArrayList<>();
		for(CompositorProjeto com: getCompositorProjeto()){
			if(com instanceof Grupo){
				grupos.add((Grupo) com);
			}
		}
		return grupos;
	}
}
