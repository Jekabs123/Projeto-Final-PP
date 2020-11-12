package model.projetos.controller;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import model.projetos.Projeto;
import model.projetos.ponto.InterfaceAcessoRemotoPonto;
import model.projetos.ponto.PontoTrabalhado;
import model.projetos.ponto.RegistradorPontoCentral;

public class ControllerTelaPonto {
	
	private InterfaceAcessoRemotoPonto ponto;
	
	public void conectarProxy (Projeto projeto, String login) {
		try {
			ponto = (InterfaceAcessoRemotoPonto) Naming.lookup("rmi://"+InetAddress.getLocalHost().getHostAddress()+":1099/PontoService");
			ponto.registrarPonto(projeto, login);
		} catch (MalformedURLException | RemoteException | NotBoundException error) {
			error.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public float deficitHoras(long dataInicio, long dataTermino, String login) {
		float retorno = 0;
		try {
			ponto = new RegistradorPontoCentral();
			retorno = ponto.deficitHoras(dataInicio, dataTermino, login);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
	
	public int pontosInvalidos(String login) {
		int count = 0;
		try {
			ponto = new RegistradorPontoCentral();
			
		for (int i = 0; i < ponto.getPontosInvalidos(login).size(); i++) {
			count ++;
		}
				
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
