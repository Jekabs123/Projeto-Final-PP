package fachadas;

import model.autenticacao.Membro;
import model.autenticacao.RegistradorSessaoLogin;

public class Fachada9MembroRealizarLogout {
	private static RegistradorSessaoLogin registradorSessao = RegistradorSessaoLogin.getInstance();
	private static Fachada1Membro fachadaMembro = new Fachada1Membro();
	
	public static void realizarLogin(Membro membro){
		registradorSessao.RegistradorOnline(membro);
		fachadaMembro.atualizarMembro();
	}
	
	public static void realizarLogout(String login){
		registradorSessao.RegistradorOffline(login);
		fachadaMembro.atualizarMembro();
	}
	
	public static boolean isOnline(String login){
		return registradorSessao.isOnline(login);
	}
}
