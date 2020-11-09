package model.projetos.ponto;


public class TratadorHorario extends TratadorDePontoIvalido{


	@Override
	public void justificarPontoInvalido() {
		//TODO Paulo - implementei o justificar do chain
		if(ponto.getHorasTrabalhadas()== horario.getExpectativaHorastrabalhadas()){
			ponto.setJustificativaAceita(true);
		}else{
			ponto.setJustificativaAceita(false);
		}
	}





}
