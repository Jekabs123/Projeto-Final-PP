package model.projetos;
public class Participacao extends Composite{
	
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
}
