package model.projetos;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa classe é a participação do projeto
 */

import model.projetos.ponto.HorarioPrevisto;

public class Participacao extends InterfaceComum {
	/**
	 * {@link #aporteCusteioMensalReais} Esse atributo informa o custeio mensal
	 * {@link #qtdMesesCusteados} Esse atributo informa a quantidade de mêses custeados
	 * {@link #qtdMesesPagos} Esse atributo informa os mêses pagos
	 * {@link #coordenador} Esse atributo informa se tem ou não coordenador
	 */
	
	private HorarioPrevisto horarioPrevisto;
	
	private float aporteCusteioMensalReais;
	private short qtdMesesCusteados;
	private short qtdMesesPagos;
	private boolean coordenador;
	
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
		return (aporteCusteioMensalReais*qtdMesesCusteados);
	}
	@Override
	public float getCusteioReaisNaoGastoTotal() {
		return (aporteCusteioMensalReais*qtdMesesCusteados)-(aporteCusteioMensalReais*qtdMesesPagos);
	}
	@Override
	public float getCapitalReaisNaoGastoTotal() {
		return 0;
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
	public HorarioPrevisto getHorarioPrevisto() {
		return horarioPrevisto;
	}
	public void setHorarioPrevisto(HorarioPrevisto horarioPrevisto) {
		this.horarioPrevisto = horarioPrevisto;
	}
}
