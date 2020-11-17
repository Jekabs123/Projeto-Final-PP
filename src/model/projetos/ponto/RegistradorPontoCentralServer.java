package model.projetos.ponto;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class RegistradorPontoCentralServer {
	

	public RegistradorPontoCentralServer(RegistradorPontoCentral registrador) {
		try {

			System.setProperty("java.rmi.server.hostname", InetAddress.getLocalHost().getHostName());
			LocateRegistry.createRegistry(1099);
			InterfaceAcessoRemotoPonto registrarPontoCentral = registrador;
			Naming.bind("PontoService", (Remote) registrarPontoCentral);
			System.out.println("Servidor rodando...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
