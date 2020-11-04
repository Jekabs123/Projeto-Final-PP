package model.projetos.ponto;

import model.projetos.Participacao;

public class PontoTrabalhado {
	
	private Participacao participacao;
	
	private long dataHoraEntrada;
	private long dataHoraSaida;
	private char[] justificativa;
	private boolean justificativaAceita;
	
	public int getHorasTrabalhadas() {
		return 0;
	}

	public Participacao getParticipacao() {
		return participacao;
	}

	public void setParticipacao(Participacao participacao) {
		this.participacao = participacao;
	}

	public long getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(long dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public long getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(long dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}

	public char[] getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(char[] justificativa) {
		this.justificativa = justificativa;
	}

	public boolean isJustificativaAceita() {
		return justificativaAceita;
	}

	public void setJustificativaAceita(boolean justificativaAceita) {
		this.justificativaAceita = justificativaAceita;
	}

	
}
