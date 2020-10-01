package model.projetos;

import java.util.ArrayList;

import model.autenticacao.Membro;

public class Projeto extends Composite{
	
	private float aporteCusteioReais;
	private float aporteCapitalReais;
	private float gastoExecutadoCusteioReais;
	private float gastoExecutadoCapitalReais;
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
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public float getCusteioReaisNaoGastoTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public float getCapitalReaisNaoGastoTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void adicionar(Membro membro) {
		membros.add(membro);
	}
	@Override
	public void remover(Membro membro) {
		membros.add(membro);
	}
	
	public void mover(Grupo grupo) {
		grupo.setMembros(membros);
	}
	
	
	public float getAporteCusteioReais() {
		return aporteCusteioReais;
	}
	public void setAporteCusteioReais(float aporteCusteioReais) {
		this.aporteCusteioReais = aporteCusteioReais;
	}
	public float getAporteCapitalReais() {
		return aporteCapitalReais;
	}
	public void setAporteCapitalReais(float aporteCapitalReais) {
		this.aporteCapitalReais = aporteCapitalReais;
	}
	public float getGastoExecutadoCusteioReais() {
		return gastoExecutadoCusteioReais;
	}
	public void setGastoExecutadoCusteioReais(float gastoExecutadoCusteioReais) {
		this.gastoExecutadoCusteioReais = gastoExecutadoCusteioReais;
	}
	public float getGastoExecutadoCapitalReais() {
		return gastoExecutadoCapitalReais;
	}
	public void setGastoExecutadoCapitalReais(float gastoExecutadoCapitalReais) {
		this.gastoExecutadoCapitalReais = gastoExecutadoCapitalReais;
	}

	public ArrayList<Membro> getMembros() {
		return membros;
	}
	public void setMembros(ArrayList<Membro> membros) {
		this.membros = membros;
	}

}
