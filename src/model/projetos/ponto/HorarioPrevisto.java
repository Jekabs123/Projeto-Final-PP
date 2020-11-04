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

	public Participacao getParticipacao() {
		return participacao;
	}

	public void setParticipacao(Participacao participacao) {
		this.participacao = participacao;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	public short getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(short horaInicio) {
		this.horaInicio = horaInicio;
	}

	public short getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(short horaTermino) {
		this.horaTermino = horaTermino;
	}

	public short getToleranciaMinutos() {
		return toleranciaMinutos;
	}

	public void setToleranciaMinutos(short toleranciaMinutos) {
		this.toleranciaMinutos = toleranciaMinutos;
	}

}
