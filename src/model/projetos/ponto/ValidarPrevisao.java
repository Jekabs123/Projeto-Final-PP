package model.projetos.ponto;

public class ValidarPrevisao extends ValidarPontoIvalido{

	@Override
	public void validarPontoInvalido() {
		if(horario.getDiaSemana() == DiaSemana.SEG || horario.getDiaSemana() == DiaSemana.TER ||
				horario.getDiaSemana() == DiaSemana.QUA || horario.getDiaSemana() == DiaSemana.QUI ||
				horario.getDiaSemana() == DiaSemana.SEX|| horario.getDiaSemana() == DiaSemana.SAB ||
				horario.getDiaSemana() == DiaSemana.DOM){
			if(horario.getExpectativaHorastrabalhadas() == ponto.getHorasTrabalhadas()){
				ponto.setJustificativaAceita(true);
			}else{
				ponto.setJustificativaAceita(false);
			}
		}else{
			ponto.setJustificativaAceita(false);
		}
	}


}
