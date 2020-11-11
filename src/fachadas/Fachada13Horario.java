package fachadas;

import java.rmi.RemoteException;

import model.projetos.ponto.RegistradorPontoCentral;

public class Fachada13Horario {

	RegistradorPontoCentral registrador;
	
	public Fachada13Horario() {
		try {
			registrador = new RegistradorPontoCentral();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public float horasTrabalhadasValidasEInvalidasNoMes(long dataInicio, long dataTermino, String login){
		float horasTrabalhadas = 0;
		for(int x = 0;x<30;x++){
			horasTrabalhadas+=registrador.horasTrabalhadasValidas(dataInicio, dataTermino, login);
		}
		return horasTrabalhadas;
	}
	public float horasTrabalhadas(long dataInicio, long dataTermino, String login){
		return registrador.horasTrabalhadasValidas(dataInicio, dataTermino, login);
	}
}
