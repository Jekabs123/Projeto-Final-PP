package fachadasCasoDeUso;

import model.autenticacao.Membro;
import model.autenticacao.RegistradorSessaoLogin;

public class Fachada9MembroRealizarLogout {
	private RegistradorSessaoLogin registradorSessao = RegistradorSessaoLogin.getInstance();
	
	
	public void realizarLogin(Membro membro){
		registradorSessao.RegistradorOnline(membro);
		
	}
	
	public void realizarLogout(char[] login){
		registradorSessao.RegistradorOffline(login);
	}
	
	public boolean isOnline(char[] login){
		return registradorSessao.isOnline(login);
	}
}
