package model.projetos.ponto;


public class TratadorIntervalo extends TratadorDePontoIvalido{

	@Override
	public void justificarPontoInvalido() {
		//TODO Paulo - implementei o justificar do chain
		if((ponto.getHorasTrabalhadas()-1) == horario.getExpectativaHorastrabalhadas()){
			ponto.setJustificativaAceita(true);
		}else{
			ponto.setJustificativaAceita(false);
		}
	}
}
