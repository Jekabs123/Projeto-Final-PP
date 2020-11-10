package fachadas;

import java.rmi.RemoteException;
import java.util.ArrayList;

import model.projetos.ponto.HorarioPrevisto;
import model.projetos.ponto.PontoTrabalhado;
import model.projetos.ponto.RegistradorPontoCentral;
import model.projetos.ponto.ValidarPontoIvalido;

public class Fachada12JustificarPonto {

	private RegistradorPontoCentral registrarPonto;
	
	public Fachada12JustificarPonto() {
		try {
			registrarPonto = new RegistradorPontoCentral();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public void justificarPontoInvalido(String justificativa,PontoTrabalhado ponto,HorarioPrevisto horario, ArrayList<ValidarPontoIvalido> tratadores){
		ponto.setJustificativa(justificativa);
		registrarPonto.justificarPontoInvalido(ponto, horario, tratadores);
	}
}
