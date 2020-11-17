package model.autenticacao;

import java.util.ArrayList;

import fachadas.Fachada1Membro;

public class RegistradorSessaoLogin {
	
	private static RegistradorSessaoLogin registrador;
	private ArrayList<Membro> membros = Fachada1Membro.getMembros();
	
	private RegistradorSessaoLogin() {
		
	}
	
	public synchronized static RegistradorSessaoLogin getInstance(){
		if(registrador==null){
			registrador = new RegistradorSessaoLogin();
		}
		return registrador;
	}
	
	public void RegistradorOnline(Membro membro){
		membro.ativar();
		System.out.println("Registrado Sessão online, o Membro fez login");
	}
	public void RegistradorOffline(String login){
		for(int i = 0; i<= membros.size();i++){
			if(membros.get(i).getLogin().equals(login)){
				membros.get(i).desativar();
				System.out.println("Registrado Sessão offline, o Membro fez logout");
				break;
			}
		}
	}
	public boolean isOnline(String login){
		for(Membro membro : membros){
			if(membro.getLogin().equals(login)){
				return membro.isAtivo();
			}
		}
		return false;
	}
}
