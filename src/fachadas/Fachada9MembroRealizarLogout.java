package fachadas;

import model.autenticacao.Membro;
import model.autenticacao.RegistradorSessaoLogin;

public class Fachada9MembroRealizarLogout {
	private static RegistradorSessaoLogin registradorSessao = RegistradorSessaoLogin.getInstance();
	private static Fachada1Membro fachadaMembro = new Fachada1Membro();
	
	public static void realizarLogin(long id, Membro membro){
		registradorSessao.RegistradorOnline(membro);
		fachadaMembro.atualizarMembro(id, membro);
	}
	
	public static void realizarLogout(String login,long id, Membro membro){
		registradorSessao.RegistradorOffline(login);
		fachadaMembro.atualizarMembro(id, membro);
	}
	
	public boolean isOnline(String login){
		return registradorSessao.isOnline(login);
	}
}
