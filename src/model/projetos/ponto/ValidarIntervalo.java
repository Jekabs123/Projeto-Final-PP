package model.projetos.ponto;


public class ValidarIntervalo extends ValidarPontoIvalido{

	@Override
	public void validarPontoInvalido() {
		if((ponto.getHorasTrabalhadas()-1) == horario.getExpectativaHorastrabalhadas()){
			ponto.setJustificativaAceita(true);
		}else{
			ponto.setJustificativaAceita(false);
		}
	}
}
