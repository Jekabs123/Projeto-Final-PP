package fachadas;

import model.projetos.Participacao;
import model.projetos.ponto.DiaSemana;
import model.projetos.ponto.HorarioPrevisto;

public class Fachada10ParticipacaoHorarioPrevisto {

	private HorarioPrevisto horario = new HorarioPrevisto();
	
	public Fachada10ParticipacaoHorarioPrevisto(Participacao participacao) {
		horario.addParticipacao(participacao);
	}
	public void informarHorarioPrevisto(DiaSemana diaSemana,short inicio,short termino,short tolerancia){
		horario.setDiaSemana(diaSemana);
		horario.setHoraInicio(inicio);
		horario.setHoraTermino(termino);
		horario.setToleranciaMinutos(tolerancia);
	}
}
