package model.projetos.ponto;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class RegistradorPontoCentralServer {
	
	public RegistradorPontoCentralServer() {
		try {
			//TODO Usei a classe InetAddress para pegar o IP da rede local
			System.setProperty("java.rmi.server.hostname", InetAddress.getLocalHost().getHostAddress());
			LocateRegistry.createRegistry(1099); //Colocar a porta
			InterfaceAcessoRemotoPonto registrarPontoCentral = new RegistradorPontoCentral();
			Naming.bind("PontoService", (Remote) registrarPontoCentral);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new RegistradorPontoCentralServer();
	}
	
}
