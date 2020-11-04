package fachadasCasoDeUso;

import model.projetos.Participacao;
import model.projetos.ponto.DiaSemana;
import model.projetos.ponto.HorarioPrevisto;

public class Fachada10ParticipacaoHorarioPrevisto {

	private HorarioPrevisto horario = new HorarioPrevisto();
	
	public Fachada10ParticipacaoHorarioPrevisto(Participacao participacao) {
		participacao.setHorarioPrevisto(horario);
		horario.setParticipacao(participacao);
	}
	public void diaSemana(DiaSemana diaSemana){
		horario.setDiaSemana(diaSemana);
	}
	public void horarioInicio(short inicio){
		horario.setHoraInicio(inicio);
	}
	public void horarioTermino(short termino, Participacao participacao){
		horario.setHoraTermino(termino);
	}
	public void toleranciaHoraMinutos(short tolerancia, Participacao participacao){
		horario.setToleranciaMinutos(tolerancia);
	}
	
}
