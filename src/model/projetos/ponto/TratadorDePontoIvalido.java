package model.projetos.ponto;


public abstract class TratadorDePontoIvalido {

	protected PontoTrabalhado ponto;
	protected HorarioPrevisto horario;
	private TratadorDePontoIvalido tratador;
	public abstract void justificarPontoInvalido();
	
	
	public TratadorDePontoIvalido getProximaEtapa(){
		return tratador;
	}
	public void setProximaEtapa(TratadorDePontoIvalido tratador){
		this.tratador = tratador;
	}
	public void setPonto(PontoTrabalhado ponto) {
		this.ponto = ponto;
	}
	public void setHorario(HorarioPrevisto horario) {
		this.horario = horario;
	}
	
}
