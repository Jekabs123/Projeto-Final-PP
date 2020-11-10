package model.projetos.ponto;


public class ValidarHorario extends ValidarPontoIvalido{


	@Override
	public void validarPontoInvalido() {
		if(ponto.getHorasTrabalhadas()== horario.getExpectativaHorastrabalhadas()){
			ponto.setJustificativaAceita(true);
		}else{
			ponto.setJustificativaAceita(false);
		}
	}





}
