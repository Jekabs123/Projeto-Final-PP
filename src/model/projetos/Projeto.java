package model.projetos;

import java.util.ArrayList;

import exception.ExceptionMembroDuplicado;
import model.autenticacao.Membro;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Esse Classe é o projeto do sistema
 */
public class Projeto extends InterfaceComum{
	/**
	 * {@link #aporteCusteioReais} Esse atributo é o aporte destinado para o custeio
	 * {@link #aporteCapitalReais} Esse atributo é o aporte destinado para o capital
	 * {@link #gastoExecutadoCusteioReais} Esse atributo é o gasto do custeio
	 * {@link #gastoExecutadoCapitalReais} Esse atributo é o gasto do capital
	 * {@link #membros} Esse atributo armazena os embros do projeto
	 */
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
	/**
	 * Esse método move os membros do projeto para outro grupo
	 * @param grupo: é o grupo que vai ser movido os membros
	 */
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
	/**
	 * Esse método pesquisa um membro a partir do login e a senha da conta do membro
	 * @param login: é o login da conta do membro
	 * @param senha: é a senha da conta do membro
	 * @return: retorna o membro se tiver o mesmo login e senha passado e null se não for igual
	 */
	public Membro pesquisarMembroPorLoginESenha(char[] login, char[] senha){
		for(Membro membro: membros){
			if(membro.getLogin().equals(login)&&membro.getSenha()==senha){
				return membro;
			}
		}
		return null;
	}
}
