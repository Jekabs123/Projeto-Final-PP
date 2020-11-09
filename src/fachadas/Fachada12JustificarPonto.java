package fachadas;

import java.rmi.RemoteException;
import java.util.ArrayList;

import model.projetos.ponto.HorarioPrevisto;
import model.projetos.ponto.PontoTrabalhado;
import model.projetos.ponto.RegistradorPontoCentral;
import model.projetos.ponto.TratadorDePontoIvalido;

public class Fachada12JustificarPonto {

	private RegistradorPontoCentral registrarPonto;
	
	public Fachada12JustificarPonto() {
		try {
			registrarPonto = new RegistradorPontoCentral();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public void justificarPontoInvalido(PontoTrabalhado ponto,HorarioPrevisto horario, ArrayList<TratadorDePontoIvalido> tratadores){
		registrarPonto.justificarPontoInvalido(ponto, horario, tratadores);
	}
}
