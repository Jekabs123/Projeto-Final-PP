package model.projetos.ponto;

public class ValidarPrevisaoMinutos extends ValidarPontoIvalido{

	@Override
	public void validarPontoInvalido() {
		if((ponto.getHorasTrabalhadas() - horario.getToleranciaMinutos()) == horario.getExpectativaHorastrabalhadas()){
			ponto.setJustificativaAceita(true);
		}else{
			ponto.setJustificativaAceita(false);
		}
	}
}
