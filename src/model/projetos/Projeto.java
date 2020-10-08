package model.projetos;

import java.util.ArrayList;

import Exception.ExceptionMembroDuplicado;
import model.autenticacao.Membro;

public class Projeto extends InterfaceComum{
	
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
		return aporteCapitalReais+aporteCusteioReais;
	}
	@Override
	public float getCusteioReaisNaoGastoTotal() {
		return aporteCusteioReais-gastoExecutadoCusteioReais;
	}
	@Override
	public float getCapitalReaisNaoGastoTotal() {
		return aporteCapitalReais-gastoExecutadoCapitalReais;
	}
	@Override
	public void adicionar(Membro membro) throws ExceptionMembroDuplicado{
		for(Membro m: membros){
			if(m.getMatricula()==membro.getMatricula()){
				 throw new ExceptionMembroDuplicado("Algum membro possui essa matricula");
			}
		}
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
