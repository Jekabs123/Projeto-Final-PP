package model.projetos.ponto;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class RegistradorPontoCentralServer {
	

	public RegistradorPontoCentralServer() {
		try {

			System.setProperty("java.rmi.server.hostname", InetAddress.getLocalHost().getHostName());
			LocateRegistry.createRegistry(1099); //Colocar a porta
			InterfaceAcessoRemotoPonto registrarPontoCentral = new RegistradorPontoCentral();
			Naming.bind("PontoService", (Remote) registrarPontoCentral);
			System.out.println("Servidor rodando...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new RegistradorPontoCentralServer();
	}
	
}
