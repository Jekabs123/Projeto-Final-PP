package model.projetos;

import Exception.ExceptionMembroDuplicado;
import model.autenticacao.Membro;

public abstract class Composite {
	private char[] nome;
	private boolean ativo;
	private long dataInicio;
	private long dataTermino;
	
	public abstract void ativar();
	
	public abstract void desativar();
	
	public abstract float getCustoTotal();
	
	public abstract float getCusteioReaisNaoGastoTotal();
	
	public abstract float getCapitalReaisNaoGastoTotal();
	
	public void adicionar(Membro membro)throws ExceptionMembroDuplicado{
		
	}
	public void remover(Membro membro){
		
	}
	public void adicionar(Composite composite){
		
	}
	public void remover(Composite composite){
		
	}

	public char[] getNome() {
		return nome;
	}

	public void setNome(char[] nome) {
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
	
}
