package model.projetos.ponto;

public class TratadorHorario extends TratadorDePontoIvalido{

	@Override
	public void justificarPontoInvalido(PontoTrabalhado ponto) {
		if (ponto.getDataHoraEntrada() == 0|| ponto.getDataHoraSaida() == 0) {
			
		}
	}

}
