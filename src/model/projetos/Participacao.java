package model.projetos;

import java.util.ArrayList;

import model.autenticacao.Membro;

public class Participacao extends Composite{
	
	private boolean ativo;
	private float aporteCusteioMensalReais;
	private short qtdMesesCusteados;
	private short qtdMesesPagos;
	private boolean coordenador;
	private ArrayList<Membro> membros = new ArrayList<Membro>();
	private ArrayList<Projeto> projetos = new ArrayList<Projeto>();
	
	@Override
	public void ativar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void desativar() {
		// TODO Auto-generated method stub
		
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
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public float getAporteCusteioMensalReais() {
		return aporteCusteioMensalReais;
	}
	public void setAporteCusteioMensalReais(float aporteCusteioMensalReais) {
		this.aporteCusteioMensalReais = aporteCusteioMensalReais;
	}
	public short getQtdMesesCusteados() {
		return qtdMesesCusteados;
	}
	public void setQtdMesesCusteados(short qtdMesesCusteados) {
		this.qtdMesesCusteados = qtdMesesCusteados;
	}
	public short getQtdMesesPagos() {
		return qtdMesesPagos;
	}
	public void setQtdMesesPagos(short qtdMesesPagos) {
		this.qtdMesesPagos = qtdMesesPagos;
	}
	public boolean isCoordenador() {
		return coordenador;
	}
	public void setCoordenador(boolean coordenador) {
		this.coordenador = coordenador;
	}
	public ArrayList<Membro> getMembros() {
		return membros;
	}
	public void setMembros(ArrayList<Membro> membros) {
		this.membros = membros;
	}
	public ArrayList<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(ArrayList<Projeto> projetos) {
		this.projetos = projetos;
	}

}
