package fachadas;

import java.rmi.RemoteException;

import model.projetos.Participacao;
import model.projetos.ponto.PontoTrabalhado;
import model.projetos.ponto.RegistradorPontoCentral;

public class Fachada11BaterPonto {
 
	private RegistradorPontoCentral registrarPonto;
	
	public Fachada11BaterPonto() {
		try {
			registrarPonto = new RegistradorPontoCentral();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public void baterPonto(Participacao participacao,long dataHoraEntrada, long dataHoraSaida, String login){
		PontoTrabalhado ponto = new PontoTrabalhado();
		ponto.setDataHoraEntrada(dataHoraEntrada);
		ponto.setDataHoraSaida(dataHoraSaida);
		participacao.adicionarPontoTrabalhado(ponto);
	}

}
