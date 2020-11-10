package model.projetos.ponto;

public class TratadorPrevisaoMinutos extends TratadorDePontoIvalido{

	@Override
	public void justificarPontoInvalido() {
		if((ponto.getHorasTrabalhadas() - horario.getToleranciaMinutos()) == horario.getExpectativaHorastrabalhadas()){
			ponto.setJustificativaAceita(true);
		}else{
			ponto.setJustificativaAceita(false);
		}
	}
}
