package model.projetos;

import java.util.ArrayList;

public class Edital extends Composite{

	private ArrayList<Composite> projetos = new ArrayList<>();
	private ArrayList<Composite> grupos = new ArrayList<>();
	
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
		for(Composite p: projetos){
			custoTotal+= p.getCustoTotal();
		}
		return custoTotal;
	}

	@Override
	public float getCusteioReaisNaoGastoTotal() {
		float custeio = 0;
		for(Composite c: projetos){
			custeio+= c.getCusteioReaisNaoGastoTotal();
		}
		return custeio;
	}

	@Override
	public float getCapitalReaisNaoGastoTotal() {
		float capital = 0;
		for(Composite c: projetos){
			capital+=c.getCapitalReaisNaoGastoTotal();
		}
		return capital;
	}
}
