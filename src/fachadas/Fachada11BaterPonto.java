package fachadas;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import model.projetos.Participacao;
import model.projetos.Projeto;
import model.projetos.ponto.PontoTrabalhado;
import model.projetos.ponto.RegistradorPontoCentral;

public class Fachada11BaterPonto {
 
	private RegistradorPontoCentral registrarPonto;
	private PontoTrabalhado ponto;
	public Fachada11BaterPonto() {
		try {
			registrarPonto = new RegistradorPontoCentral();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public void baterPonto(Participacao participacao,long dataHoraEntrada, long dataHoraSaida){
		ponto = new PontoTrabalhado();
		ponto.setDataHoraEntrada(dataHoraEntrada);
		ponto.setDataHoraSaida(dataHoraSaida);
		participacao.adicionarPontoTrabalhado(ponto);
		JOptionPane.showMessageDialog(null, "Bateu Ponto!");
	}
	public boolean registrarPonto(Projeto projeto, String login){
		return registrarPonto.registrarPonto(projeto, login);
	}
}
