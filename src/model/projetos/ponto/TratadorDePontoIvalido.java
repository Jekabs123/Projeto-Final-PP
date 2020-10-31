package model.projetos.ponto;

public abstract class TratadorDePontoIvalido {

	private TratadorDePontoIvalido tratador;
	
	public abstract void justificarPontoInvalido();
	
	
	public TratadorDePontoIvalido getProximaEtapa(){
		return tratador;
	}
	public void setProximaEtapa(TratadorDePontoIvalido tratador){
		this.tratador = tratador;
	}
	
}
