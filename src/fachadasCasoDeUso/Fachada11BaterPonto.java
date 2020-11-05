package fachadasCasoDeUso;

import java.rmi.RemoteException;

import model.projetos.Projeto;
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
	
	public boolean baterPonto(Projeto projeto, String login){
		return registrarPonto.registrarPonto(projeto, login);
	}
}
