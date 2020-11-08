package model.projetos.controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import model.projetos.Projeto;
import model.projetos.ponto.InterfaceAcessoRemotoPonto;

public class ControllerTelaPonto {
	
	public void conectarProxy (Projeto projeto, String login) {
		try {
			InterfaceAcessoRemotoPonto ponto = (InterfaceAcessoRemotoPonto) Naming.lookup("rmi://999999/PontoService"); //Aqui preciso botar a porta
			ponto.registrarPonto(projeto, login);
		} catch (MalformedURLException | RemoteException | NotBoundException error) {
			// TODO Auto-generated catch block
			error.printStackTrace();
		}
	}

}
