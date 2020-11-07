package model.projetos;
/**
 * @author PAULO E INATHAN - TATAKAE!
 * Essa classe � a participa��o do projeto
 */
public class Participacao extends CompositorProjeto{
	/**
	 * {@link #aporteCusteioMensalReais} Esse atributo informa o custeio mensal
	 * {@link #qtdMesesCusteados} Esse atributo informa a quantidade de m�ses custeados
	 * {@link #qtdMesesPagos} Esse atributo informa os m�ses pagos
	 * {@link #coordenador} Esse atributo informa se tem ou n�o coordenador
	 */
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

	/*
	 * TODO 
	 * 1. como esta classe n suporta, melhor colocar implementacao default vazia
	 * ou com excecao no supertipo e aqui vc nem implementa.  FEITO
	 */
//	public float getCapitalReaisNaoGastoTotal() {
//		return 0;
//	}
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
