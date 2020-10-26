package model.projetos.ponto;

import model.projetos.Participacao;

public class HorarioPrevisto {
	
	private Participacao participacao;
	
	private DiaSemana diaSemana;
	private short horaInicio;
	private short horaTermino;
	private short toleranciaMinutos;
	
	public int getExpectativaHorastrabalhadas() {
		return 0;
	}

}
