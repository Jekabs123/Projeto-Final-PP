package model.projetos.ponto;

public abstract class TratadorDePontoIvalido {

	protected PontoTrabalhado ponto;
	
	private TratadorDePontoIvalido tratador;
	
	public abstract void justificarPontoInvalido(PontoTrabalhado ponto);
	
	
	public TratadorDePontoIvalido getProximaEtapa(){
		return tratador;
	}
	public void setProximaEtapa(TratadorDePontoIvalido tratador){
		this.tratador = tratador;
	}
	
}
