package model.projetos.controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import model.projetos.Projeto;
import model.projetos.ponto.InterfaceAcessoRemotoPonto;

public class ControllerTelaPonto {
	
	public void conectarProxy (Projeto projeto, String login) {
		//TODO tá dando erro nessa parte do RMI do IP, será que é 
		//melhor deixar automático igual ao RegistradorPontoCentral/Server?
		try {
			InterfaceAcessoRemotoPonto ponto = (InterfaceAcessoRemotoPonto) Naming.lookup("rmi://168.232.112.127:1099/PontoService");
			ponto.registrarPonto(projeto, login);
		} catch (MalformedURLException | RemoteException | NotBoundException error) {
			error.printStackTrace();
		}
	}

}
