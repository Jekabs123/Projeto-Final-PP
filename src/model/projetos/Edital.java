package model.projetos;

import java.util.ArrayList;
/**
 * @author PAULO E INATHAN
 * Essa é a classe Edital do projeto
 */
public class Edital extends InterfaceComum{

	private ArrayList<InterfaceComum> projetos = new ArrayList<>();
	private ArrayList<InterfaceComum> grupos = new ArrayList<>();
	
	public void adicionar(Projeto composite) {
		projetos.add(composite);
	}
	public void adicionar(Grupo composite){
		grupos.add(composite);
	}
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
		for(InterfaceComum p: projetos){
			custoTotal+= p.getCustoTotal();
		}
		for(InterfaceComum g: grupos){
			custoTotal+= g.getCustoTotal();
		}
		return custoTotal;
	}

	@Override
	public float getCusteioReaisNaoGastoTotal() {
		float custeio = 0;
		for(InterfaceComum c: projetos){
			custeio+= c.getCusteioReaisNaoGastoTotal();
		}
		return custeio;
	}

	@Override
	public float getCapitalReaisNaoGastoTotal() {
		float capital = 0;
		for(InterfaceComum c: projetos){
			capital+=c.getCapitalReaisNaoGastoTotal();
		}
		return capital;
	}
	public ArrayList<InterfaceComum> getProjetos() {
		return projetos;
	}
	public void setProjetos(ArrayList<InterfaceComum> projetos) {
		this.projetos = projetos;
	}
	public ArrayList<InterfaceComum> getGrupos() {
		return grupos;
	}
	public void setGrupos(ArrayList<InterfaceComum> grupos) {
		this.grupos = grupos;
	}
	
	
}
