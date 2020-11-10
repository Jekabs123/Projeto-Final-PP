package model.projetos.ponto;


public class TratadorIntervalo extends TratadorDePontoIvalido{

	@Override
	public void justificarPontoInvalido() {
		if((ponto.getHorasTrabalhadas()-1) == horario.getExpectativaHorastrabalhadas()){
			ponto.setJustificativaAceita(true);
		}else{
			ponto.setJustificativaAceita(false);
		}
	}
}
