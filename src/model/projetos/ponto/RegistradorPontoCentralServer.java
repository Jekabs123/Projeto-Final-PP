package model.projetos.ponto;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class RegistradorPontoCentralServer {
	public boolean registrarPonto(RegistradorPontoCentral registrador){
		try {
			System.setProperty("java.rmi.server.hostname", "91911991");
			LocateRegistry.createRegistry(1099); //Colocar a porta
			InterfaceAcessoRemotoPonto registrarPontoCentral = registrador;
			Naming.bind("PontoService", (Remote) registrarPontoCentral);
			return true;
		} catch (Exception e) {
		}
		return false;
		
	}
}
