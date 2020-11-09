package model.projetos.ponto;

import model.projetos.Participacao;

public class HorarioPrevisto {
	
	private DiaSemana diaSemana;
	private short horaInicio;
	private short horaTermino;
	private short toleranciaMinutos;
	private Participacao participacao;
	
	public int getExpectativaHorastrabalhadas() {
		return horaTermino-horaInicio;
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

	public Participacao getParticipacao() {
		return participacao;
	}

	public void setParticipacao(Participacao participacao) {
		this.participacao = participacao;
	}

}
