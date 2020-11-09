package model.projetos.ponto;

import model.projetos.Participacao;

public class PontoTrabalhado {
	
	private long dataHoraEntrada;
	private long dataHoraSaida;
	private String justificativa;
	private boolean justificativaAceita;
	private Participacao participacao;
	
	public int getHorasTrabalhadas() {
		//TODO Paulo - implementei o método getHorasTrabalhadas
		return (int)(dataHoraSaida-dataHoraEntrada);
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

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public boolean isJustificativaAceita() {
		return justificativaAceita;
	}

	public void setJustificativaAceita(boolean justificativaAceita) {
		this.justificativaAceita = justificativaAceita;
	}

	public Participacao getParticipacao() {
		return participacao;
	}

	public void setParticipacao(Participacao participacao) {
		this.participacao = participacao;
	}

	
}
