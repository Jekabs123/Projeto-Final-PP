package model.projetos.ponto;


public abstract class ValidarPontoIvalido {

	protected PontoTrabalhado ponto;
	protected HorarioPrevisto horario;
	private ValidarPontoIvalido tratador;
	public abstract void validarPontoInvalido();
	
	
	public ValidarPontoIvalido getProximaEtapa(){
		return tratador;
	}
	public void setProximaEtapa(ValidarPontoIvalido tratador){
		this.tratador = tratador;
	}
	public void setPonto(PontoTrabalhado ponto) {
		this.ponto = ponto;
	}
	public void setHorario(HorarioPrevisto horario) {
		this.horario = horario;
	}
	
}
